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
  CInputGroup,
  CListGroup,
  CListGroupItem,
  CFormCheck,
  CFormSelect,
  CImage,
} from '@coreui/react'

import ReactImg from 'src/assets/images/test_img.jpeg'
import axios from 'axios';

const FormControl = () => {

  let [groupId, setGroupId] = useState(1)

  const groupInfo = async ()=>{
    const response = await axios.get(`/auth-service/v1/group/detail/${groupId}`)
    console.log('This response',response)
    localStorage.setItem('detail', JSON.stringify(response.data))
  }

  useEffect(()=>{
    groupInfo()
  },[])

  let A = JSON.parse(localStorage.getItem('detail'))
  console.log('hihi',A.user)
  
  // let users = A.user.map(userInfo =>{
  //   <CListGroupItem className="d-flex">
  //     <span>{userInfo.name} ({userInfo.mailAddr})</span>
  //   </CListGroupItem>
  // }
  // )


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
                     
                        <CListGroupItem className="d-flex">
                          <span>{A.user.name} ({A.user.mailAddr})</span>
                        </CListGroupItem>
                        {/* <CListGroupItem className="d-flex">
                          <span>test1 (tes*****@hanmail.net)</span>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test2 (tes*****@hanmail.net)</span>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test3 (tes*****@hanmail.net)</span>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test4 (tes*****@hanmail.net)</span>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test5 (tes*****@hanmail.net)</span>
                        </CListGroupItem> */}
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
