import React from 'react'
import {
  CButton,
  CCard,
  CCardBody,
  CCardFooter,
  CCardGroup,
  CCardHeader,
  CCardImage,
  CCardLink,
  CCardSubtitle,
  CCardText,
  CCardTitle,
  CListGroup,
  CListGroupItem,
  CNav,
  CNavItem,
  CNavLink,
  CCol,
  CRow,
  CButtonGroup,
} from '@coreui/react'
import { DocsExample } from 'src/components'

import ReactImg from 'src/assets/images/test_img.jpeg'

const Grouplist = () => {
  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>그룹 목록</strong> <small></small>
          </CCardHeader>
          <CCardBody>
            <p className="text-medium-emphasis small">
              피설문자 그룹 리스트를 조회 할 수 있습니다.
            </p>
            <CRow>
              <CCol lg={3}>
                <CCard style={{ width: '18rem' }}>
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
                        상세보기
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
                <CCard style={{ width: '18rem' }}>
                  <CCardImage orientation="top" src={ReactImg} />
                  <CCardBody>
                    <CCardTitle>그룹이름 2</CCardTitle>
                    <CCardText>그룹테스트입니다.</CCardText>
                  </CCardBody>
                  <CListGroup flush>
                    <CListGroupItem>개설자 : 테스트</CListGroupItem>
                    <CListGroupItem>참여인원 : 1명 </CListGroupItem>
                  </CListGroup>
                  <CCardBody className="text-end">
                    <CButton color="primary" href="#" variant="outline">
                      detail
                    </CButton>
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
                    <CCardTitle>그룹이름 3</CCardTitle>
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
            </CRow>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Grouplist
