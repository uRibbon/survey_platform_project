import React, { useState, useEffect } from 'react'
import {
  CButton,
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CForm,
  CFormInput,
  CFormLabel,
  CFormTextarea,
  CRow,
  CListGroup,
  CListGroupItem,
  CImage,
} from '@coreui/react'

import ReactImg from 'src/assets/images/test_img.jpeg'
import axios from 'axios';

const FormControl = () => {

  const current = decodeURI(window.location.href);
  const id = current.split("/")[6];
  let [groupId, setGroupId] = useState(id)

  console.log(`/auth-service/v1/group/detail/${groupId}`)

  const groupInfo = async ()=>{
    const response = await axios.get(`/auth-service/v1/group/detail/${groupId}`)
    console.log(response)
    localStorage.setItem('detail', JSON.stringify(response.data))
  }

  groupInfo()

  let A = JSON.parse(localStorage.getItem('detail'))
  const test = A.userList.map(userInfo =>{
    return(
      <CListGroupItem className="d-flex" key={userInfo.name}>
        <span>{userInfo.name} ({userInfo.mailAddr})</span>
      </CListGroupItem>
  )}
  )

  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong> 그룹 상세 </strong>
            <small> 그룹의 상세정보를 조회 할 수 있습니다. </small>
          </CCardHeader>
          <CCardBody>
            <CForm>
              <CRow className="mb-3">
                <CFormLabel htmlFor="groupName" className="col-sm-2 col-form-label">
                  그룹명
                </CFormLabel>
                <div className="col-sm-10">
                  <CFormInput
                    type="text"
                    id="groupName"
                    placeholder="그룹명"
                    value={A.groupName}
                    readOnly
                  />
                </div>
              </CRow>
              <CRow className="mb-3">
                <CFormLabel htmlFor="formFile" className="col-sm-2 col-form-label">
                  그룹 이미지 첨부
                </CFormLabel>
                <div className="col-sm-10">
                  <div className="clearfix">
                    <CImage align="center" rounded src={ReactImg} width={200} />
                  </div>
                </div>
              </CRow>
              <CRow className="mb-3">
                <CFormLabel htmlFor="groupDescription" className="col-sm-2 col-form-label">
                  그룹 설명
                </CFormLabel>
                <div className="col-sm-10">
                  <CFormTextarea id="groupDescription" rows="3" readOnly>
                    {A.groupDescription}
                  </CFormTextarea>
                </div>
              </CRow>
              <CRow className="mb-3">
                <CFormLabel htmlFor="groupDescription" className="col-sm-2 col-form-label">
                  그룹 참여자
                </CFormLabel>
                <div className="col-sm-10">
                  <CRow>
                    <CCol lg={12}>
                      <CListGroup className="mb-1 custom_height">                   
                        {test}
                      </CListGroup>
                    </CCol>
                  </CRow>
                </div>
              </CRow>
            </CForm>
            <CCol lg={12} className="text-end d-flex">
              <CButton color="danger" href="#" variant="outline">
                delete
              </CButton>
              <CButton color="success" href="#" className="ms-auto" variant="outline">
                edit
              </CButton>
            </CCol>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default FormControl
