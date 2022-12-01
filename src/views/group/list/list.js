import React, { useState, useEffect } from 'react'
import { useSelector } from 'react-redux'
import {
  CButton,
  CCard,
  CCardBody,
  CCardFooter,
  CCardHeader,
  CCardImage,
  CCardText,
  CCardTitle,
  CListGroup,
  CListGroupItem,
  CCol,
  CRow,
  CButtonGroup,
  CInputGroup,
  CInputGroupText,
  CFormInput,
  CPagination,
  CPaginationItem,
  CModal,
  CModalHeader,
  CModalTitle,
  CModalBody,
  CModalFooter,
  CFormLabel,
} from '@coreui/react'

import ReactImg_2 from 'src/assets/images/test5.jpeg';
import axios from 'axios';
import usePromise from 'src/lib/usePromise';
import apiConfig from 'src/lib/apiConfig.js';
import { Navigate } from 'react-router-dom';
import PrtcpList from 'src/views/survey/list/PrtcpList';
import { isCompositeComponent } from 'react-dom/test-utils';

const ClickParticipateBtn = () => {
  const [visible, setVisible] = useState(false)
  return (
    <>
      <CButton color="success" variant="outline" onClick={() => setVisible(!visible)}>
        participate
      </CButton>
      <CModal visible={visible} onClose={() => setVisible(false)}>
        <CModalHeader>
          <CModalTitle>그룹 참여 요청</CModalTitle>
        </CModalHeader>
        <CModalBody>
          <CRow className="mb-3">
            <CFormLabel htmlFor="groupCode" className="col-sm-2 col-form-label">
              그룹코드
            </CFormLabel>
            <div className="col-sm-10">
              <CFormInput type="password" id="groupCode" placeholder="그룹코드" />
            </div>
          </CRow>
        </CModalBody>
        <CModalFooter>
          <CButton color="primary" variant="outline">
            participate
          </CButton>
        </CModalFooter>
      </CModal>
    </>
  )
}
const Grouplist = () => {
  const current = decodeURI(window.location.href);
  const search = current.split("?")[1];
  const params = new URLSearchParams(search);
  const nowPage = params.get('page') ? params.get('page') : 1;
  // const [pageData, setPageData] = useState({
  //   totalPage: 0,
  //   page: 1,
  //   size: 0,
  //   start: 0,
  //   end: 0,
  //   prev: false,
  //   next: false,
  //   pageList: []
  // })

  let pageData= {
    totalPage: 0,
    page: 1,
    size: 0,
    start: 0,
    end: 0,
    prev: false,
    next: false,
    pageList: []
  };

  // const [setGroupList] = useState([])

  //user 정보 불러오기
  const { user } = useSelector(({user})=> ({user:user.user}));

  const loginUser = user.info.userId;
  console.log(loginUser);


  //token 가져오기
  const accessToken = user.token.access_token;
  //console.log(user)

  //token 서버로 보내기
  const [loading, response, error] = usePromise(() => {
    return axios.post(apiConfig.groupList + "?page="+ nowPage,
    {},
    {headers: {'Authorization': 'Bearer ' + accessToken }})
  }, []);

  console.log(response);

  let groupList = []
  let prtcpUser = []

  if(response != null){
    groupList = response.data.dtoList;
    
    pageData.pageList = response.data.pageList;
    pageData.page = response.data.page;
    
    for (var i = 0; i < groupList.length; i++) {
      prtcpUser.push([]);
          for (var j = 0 ; j < groupList[i].prtcpList.length ; j++) {
              prtcpUser[i].push(groupList[i].prtcpList[j].userId);
          }
    }
    console.log(prtcpUser);
  }

  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong> 그룹 목록 </strong>
          </CCardHeader>
          <CCardBody>
            <CCard className="mb-2">
              <CCardBody>
                <CCol lg={12}>
                  <CRow>
                    <CInputGroup className="mb-1" lg={6}>
                      <CInputGroupText id="basic-addon1">개설자</CInputGroupText>
                      <CFormInput
                        placeholder=""
                        aria-label="Username"
                        aria-describedby="basic-addon1"
                      />
                    </CInputGroup>
                    <CInputGroup className="mb-1" lg={6}>
                      <CInputGroupText id="basic-addon1">그룹명</CInputGroupText>
                      <CFormInput
                        placeholder=""
                        aria-label="Groupname"
                        aria-describedby="basic-addon1"
                      />
                    </CInputGroup>
                  </CRow>
                </CCol>
                <CCol lg={12} className="text-end">
                  <CButton color="primary" type='submit'>
                    Search
                  </CButton>
                </CCol>
              </CCardBody>
            </CCard>
            <CRow className="mb-4">
              {groupList.map((groupList, prtcpUser)=> (
                <CCol lg={3} key = {groupList.groupId}>
                <CCard className="mb-3">
                  <CCardImage orientation="top" src={ReactImg_2} />
                  <CCardBody>
                    <CCardTitle>{groupList.groupName}</CCardTitle>
                    <CCardText className="text-ellipsis">
                    {groupList.groupDescription}
                    </CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : {groupList.regId}</CListGroupItem>
                    <CListGroupItem>참여인원 : {groupList.groupCnt}명</CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                    {prtcpUser === loginUser &&(
                      <CButton color="success" variant="outline" size="sm">participate</CButton>
                    )}
                    {groupList.regId === loginUser &&(
                      <CButton color="primary" href={'#/group/detail/'+groupList.groupId} variant="outline" size="sm">detail</CButton>
                    )}
                    {groupList.regId === loginUser &&(
                      <CButton color="danger" variant="outline" size="sm">delete</CButton>
                    )}
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : {groupList.regDt}</small>
                  </CCardFooter>
                </CCard>
              </CCol>
              )
              )}
            </CRow>
            <CRow className="mb-4">
              <CPagination aria-label="Page navigation example" align="center">
                {pageData.prev ? (
                  <CPaginationItem aria-label="Previous">
                    <span aria-hidden="true">
                      <a href={"/#/group/list?page=" + String(parseInt(pageData.start) - 1)}>&laquo;</a>
                    </span>
                  </CPaginationItem>
                ) : (
                  <CPaginationItem aria-label="Previous" disabled>
                    <span aria-hidden="true">&laquo;</span>
                  </CPaginationItem>
                )}
                {pageData.pageList.map((idx) =>
                  idx === parseInt(pageData.page) ? (
                    <CPaginationItem active>{pageData.page}</CPaginationItem>
                  ) : (
                    <CPaginationItem>
                      <a href={"/#/group/list?page=" + idx}>{idx}</a>
                    </CPaginationItem>
                  ),
                )}
                {pageData.next ? (
                  <CPaginationItem aria-label="Next">
                    <span aria-hidden="true">
                      <a href={"/#/group/list?page=" + String(parseInt(pageData.end) + 1)}>&raquo;</a>
                    </span>
                  </CPaginationItem>
                ) : (
                  <CPaginationItem aria-label="Next" disabled>
                    <span aria-hidden="true">&raquo;</span>
                  </CPaginationItem>
                )}
              </CPagination>
            </CRow>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Grouplist
