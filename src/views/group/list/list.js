import React from 'react'
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
} from '@coreui/react'
import { DocsExample } from 'src/components'

import ReactImg from 'src/assets/images/test_img.jpeg'

const Grouplist = () => {
  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong> 그룹 목록 </strong>
            <small> 그룹을 통해 설문 대상자를 지정할 수 있습니다. </small>
          </CCardHeader>
          <CCardBody>
            <CCard className="mb-2">
              <CCardBody>
                <CCol lg={8}>
                  <CInputGroup className="mb-1">
                    <CInputGroupText id="basic-addon1">개설자</CInputGroupText>
                    <CFormInput
                      placeholder="Username"
                      aria-label="Username"
                      aria-describedby="basic-addon1"
                    />
                  </CInputGroup>
                  <CInputGroup className="mb-1">
                    <CInputGroupText id="basic-addon1">그룹명</CInputGroupText>
                    <CFormInput
                      placeholder="Groupname"
                      aria-label="Groupname"
                      aria-describedby="basic-addon1"
                    />
                  </CInputGroup>
                </CCol>
                <CCol lg={12} className="text-end">
                  <CButton color="primary" href="#">
                    Search
                  </CButton>
                </CCol>
              </CCardBody>
            </CCard>
            <CRow className="mb-4">
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }} className="mb-3">
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>클라우드 전용 그룹</CCardTitle>
                    <CCardText>8팀 클라우드만 참여가능한 그룹이에요~</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 고솔비 </CListGroupItem>
                    <CListGroupItem>참여인원 : 3명</CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                      <CButton color="primary" href="#" variant="outline">
                        detail
                      </CButton>
                      <CButton color="danger" href="#" variant="outline">
                        delete
                      </CButton>
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : 2022-10-21</small>
                  </CCardFooter>
                </CCard>
              </CCol>
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }} className="mb-3">
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>그룹이름 2</CCardTitle>
                    <CCardText>그룹테스트입니다.</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 테스트</CListGroupItem>
                    <CListGroupItem>참여인원 : 5명 </CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                      <CButton color="primary" href="#" variant="outline">
                        detail
                      </CButton>
                      <CButton color="success" href="#" variant="outline">
                        participate
                      </CButton>
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : 2022-10-25</small>
                  </CCardFooter>
                </CCard>
              </CCol>
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }} className="mb-3">
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>그룹이름 3</CCardTitle>
                    <CCardText>그룹테스트입니다.</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 테스트</CListGroupItem>
                    <CListGroupItem>참여인원 : 0명</CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                      <CButton color="success" href="#" variant="outline">
                        participate
                      </CButton>
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : 2022-10-25</small>
                  </CCardFooter>
                </CCard>
              </CCol>
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }} className="mb-3">
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>그룹이름 4</CCardTitle>
                    <CCardText>그룹테스트입니다.</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 고솔비</CListGroupItem>
                    <CListGroupItem>참여인원 : 1명</CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                      <CButton color="primary" href="#" variant="outline">
                        detail
                      </CButton>
                      <CButton color="danger" href="#" variant="outline">
                        delete
                      </CButton>
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : 2022-10-25</small>
                  </CCardFooter>
                </CCard>
              </CCol>
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }}>
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>그룹이름 5</CCardTitle>
                    <CCardText>그룹테스트입니다.</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 테스트</CListGroupItem>
                    <CListGroupItem>참여인원 : 0명</CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                      <CButton color="success" href="#" variant="outline">
                        participate
                      </CButton>
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : 2022-10-26</small>
                  </CCardFooter>
                </CCard>
              </CCol>
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }}>
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>그룹이름 6</CCardTitle>
                    <CCardText>그룹테스트입니다.</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 테스트</CListGroupItem>
                    <CListGroupItem>참여인원 : 0명</CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                      <CButton color="success" href="#" variant="outline">
                        participate
                      </CButton>
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : 2022-10-26</small>
                  </CCardFooter>
                </CCard>
              </CCol>
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }}>
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>그룹이름 7</CCardTitle>
                    <CCardText>그룹테스트입니다.</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 테스트</CListGroupItem>
                    <CListGroupItem>참여인원 : 0명</CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                      <CButton color="success" href="#" variant="outline">
                        participate
                      </CButton>
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : 2022-10-26</small>
                  </CCardFooter>
                </CCard>
              </CCol>
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }}>
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>그룹이름 8</CCardTitle>
                    <CCardText>그룹테스트입니다.</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 테스트</CListGroupItem>
                    <CListGroupItem>참여인원 : 0명</CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButtonGroup>
                      <CButton color="success" href="#" variant="outline">
                        participate
                      </CButton>
                    </CButtonGroup>
                  </CCardBody>
                  <CCardFooter>
                    <small className="text-medium-emphasis">생성일 : 2022-10-26</small>
                  </CCardFooter>
                </CCard>
              </CCol>
            </CRow>
            <CRow className="mb-4">
              <CPagination className="justify-content-center" aria-label="Page navigation example">
                <CPaginationItem>Previous</CPaginationItem>
                <CPaginationItem>1</CPaginationItem>
                <CPaginationItem>2</CPaginationItem>
                <CPaginationItem>3</CPaginationItem>
                <CPaginationItem>Next</CPaginationItem>
              </CPagination>
            </CRow>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Grouplist
