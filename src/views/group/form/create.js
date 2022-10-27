import React from 'react'
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
} from '@coreui/react'

const FormControl = () => {
  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong> 그룹생성 </strong>
            <small> 그룹을 생성 할 수 있습니다. </small>
          </CCardHeader>
          <CCardBody>
            <CForm>
              <CRow className="mb-3">
                <CFormLabel htmlFor="groupName" className="col-sm-2 col-form-label">
                  그룹명
                </CFormLabel>
                <div className="col-sm-10">
                  <CFormInput type="text" id="groupName" placeholder="그룹명" />
                </div>
              </CRow>
              <CRow className="mb-3">
                <CFormLabel htmlFor="groupCode" className="col-sm-2 col-form-label">
                  그룹코드
                </CFormLabel>
                <div className="col-sm-10">
                  <CFormInput type="password" id="groupCode" placeholder="그룹코드" />
                </div>
              </CRow>
              <CRow className="mb-3">
                <CFormLabel htmlFor="formFile" className="col-sm-2 col-form-label">
                  그룹 이미지 첨부
                </CFormLabel>
                <div className="col-sm-10">
                  <CFormInput type="file" id="formFile" />
                </div>
              </CRow>
              <CRow className="mb-3">
                <CFormLabel htmlFor="groupDescription" className="col-sm-2 col-form-label">
                  그룹 설명
                </CFormLabel>
                <div className="col-sm-10">
                  <CFormTextarea id="groupDescription" rows="3"></CFormTextarea>
                </div>
              </CRow>
              <CRow className="mb-3">
                <CFormLabel htmlFor="groupDescription" className="col-sm-2 col-form-label">
                  그룹 설명
                </CFormLabel>
                <div className="col-sm-10">
                  <CRow>
                    <CCol lg={6}>
                      <CInputGroup className="mb-1">
                        <CFormSelect id="inputGroupSelect01">
                          <option value="">닉네임 검색</option>
                          <option value="">이메일 검색</option>
                        </CFormSelect>
                        <CFormInput
                          placeholder="email"
                          aria-label="email"
                          aria-describedby="basic-addon1"
                        />
                        <CButton>search</CButton>
                      </CInputGroup>
                      <CListGroup className="mb-1 custom_height">
                        <CListGroupItem className="d-flex">
                          <span>솔비 1</span>
                          <div className="ms-auto">
                            <CButton
                              color="success"
                              size="sm"
                              shape="rounded-pill"
                              variant="outline"
                            >
                              add
                            </CButton>
                          </div>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>솔비 2</span>
                          <div className="ms-auto">
                            <CButton
                              color="success"
                              size="sm"
                              shape="rounded-pill"
                              variant="outline"
                            >
                              add
                            </CButton>
                          </div>
                        </CListGroupItem>
                      </CListGroup>
                    </CCol>
                    <CCol lg={6}>
                      <CListGroup className="mb-1">
                        <CListGroupItem active>선택된 사용자 목록</CListGroupItem>
                      </CListGroup>
                      <CListGroup className="mb-1 custom_height">
                        <CListGroupItem className="d-flex">
                          <span>솔비 (gsb*****@hanmail.net)</span>
                          <div className="ms-auto">
                            <CButton
                              color="danger"
                              size="sm"
                              shape="rounded-pill"
                              variant="outline"
                            >
                              delete
                            </CButton>
                          </div>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test1 (tes*****@hanmail.net)</span>
                          <div className="ms-auto">
                            <CButton
                              color="danger"
                              size="sm"
                              shape="rounded-pill"
                              variant="outline"
                            >
                              delete
                            </CButton>
                          </div>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test2 (tes*****@hanmail.net)</span>
                          <div className="ms-auto">
                            <CButton
                              color="danger"
                              size="sm"
                              shape="rounded-pill"
                              variant="outline"
                            >
                              delete
                            </CButton>
                          </div>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test3 (tes*****@hanmail.net)</span>
                          <div className="ms-auto">
                            <CButton
                              color="danger"
                              size="sm"
                              shape="rounded-pill"
                              variant="outline"
                            >
                              delete
                            </CButton>
                          </div>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test4 (tes*****@hanmail.net)</span>
                          <div className="ms-auto">
                            <CButton
                              color="danger"
                              size="sm"
                              shape="rounded-pill"
                              variant="outline"
                            >
                              delete
                            </CButton>
                          </div>
                        </CListGroupItem>
                        <CListGroupItem className="d-flex">
                          <span>test5 (tes*****@hanmail.net)</span>
                          <div className="ms-auto">
                            <CButton
                              color="danger"
                              size="sm"
                              shape="rounded-pill"
                              variant="outline"
                            >
                              delete
                            </CButton>
                          </div>
                        </CListGroupItem>
                      </CListGroup>
                    </CCol>
                  </CRow>
                </div>
              </CRow>
            </CForm>
            <CCol lg={12} className="text-end">
              <CButton color="primary" href="#">
                Save
              </CButton>
            </CCol>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default FormControl
