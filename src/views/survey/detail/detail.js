import React, { useState } from 'react'
import {
  CButton,
  CCol,
  CRow,
  CCard,
  CCardHeader,
  CCardBody,
  CNav,
  CNavItem,
  CNavLink,
  CTabContent,
  CTabPane,
} from '@coreui/react'

import SurveyInfo from './surveyinfo';
import SurveyQuestion from './surveyQuestion';
import Charts from '../../analysis/user_survey_analysis';
import SurveyAnswer from './surveyAnswer';

const Detail = () => {

  const [activeKey, setActiveKey] = useState(1)
  const [surId, setSurId] = useState(1)

  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong> 설문 상세 </strong>
            <small> 설문의 상세 정보를 조회 할 수 있습니다.</small>
          </CCardHeader>
          <CCardBody>
          <div>
            <SurveyInfo surId={surId}></SurveyInfo>
            <div
              style={{
                display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
                height: '10vh',
              }}
            >
              <CNav variant="pills" role="tablist">
                <CNavItem>
                  <CNavLink
                    href="javascript:void(0);"
                    active={activeKey === 1}
                    onClick={() => setActiveKey(1)}
                  >
                    설문 조회
                  </CNavLink>
                </CNavItem>
                <CNavItem>
                  <CNavLink
                    href="javascript:void(0);"
                    active={activeKey === 2}
                    onClick={() => setActiveKey(2)}
                  >
                    설문 결과
                  </CNavLink>
                </CNavItem>
              </CNav>
            </div>
            <CTabContent>
              <CTabPane role="tabpanel" aria-labelledby="home-tab" visible={activeKey === 1}>
                 <SurveyAnswer surId={surId}/>
              </CTabPane>
              <CTabPane role="tabpanel" aria-labelledby="profile-tab" visible={activeKey === 2}>
                <Charts surId={surId}/>
              </CTabPane>
            </CTabContent>
            <CCol lg={12} className="text-start d-flex">
              <CButton color="danger" href="#" variant="outline">
                delete
              </CButton>
              <CButton color="warning" href="#" variant="outline">
                copy
              </CButton>
              <CButton color="primary" href="#" className="ms-auto" variant="outline">
                <a href="/#/survey/ModifySurvey">edit</a>
              </CButton>
              <CButton color="success" href="#" variant="outline">
                excel download
              </CButton>
          </CCol>
          </div>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>

  )
}

export default Detail
