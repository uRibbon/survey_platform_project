import React, { useState } from 'react';
import { useSelector } from 'react-redux';
import {
  CCard,
  CCardHeader,
  CCardBody,
  CNav, 
  CNavItem, 
  CNavLink, 
  CTabContent, 
  CTabPane,
  CButton
} from '@coreui/react'
import CreateSurveyInfo from './CreateSurveyInfo';
import CreateQuestion from './CreateQuestion';
import Send from './Send';

const CreateSurvey = () => {
  const [activeKey, setActiveKey] = useState(1)
  
  const [validated, setValidated] = useState(false );

  // 설문발송탭 활성/비활성화
  function showSendTab(flag) {
    setValidated(flag);
  }


  const { questions } = useSelector(({ questions }) => ({
    questions : questions
  }));
  
  return (
    <>
     <CCard className="mb-3">
        <CCardHeader>설문 생성<small> 설문을 생성 할 수 있습니다.</small>
        </CCardHeader>
        <CCardBody>
          <div>
            <div
              style={{
              //   display: 'flex',
                alignItems: 'center',
                justifyContent: 'center',
              //   height: '10vh',
              }}
            >
              <CNav role="tablist" variant="tabs">
                <CNavItem>
                  <CNavLink
                    active={activeKey === 1}
                    onClick={() => setActiveKey(1)}
                  >
                    기본정보 작성
                  </CNavLink>
                </CNavItem>
                <CNavItem>
                  <CNavLink
                    active={activeKey === 2}
                    onClick={() => setActiveKey(2)}
                  >
                    질문 작성
                  </CNavLink>
                </CNavItem>
                <CNavItem>
                  <CNavLink 
                    disabled={!validated}
                    active={activeKey === 3}
                    onClick={() => setActiveKey(3)}
                  >
                    설문 발송
                  </CNavLink>
                </CNavItem>
              </CNav>
            </div>

            <CTabContent>
              <CTabPane role="tabpanel" aria-labelledby="home-tab" visible={activeKey === 1}>
                <CreateSurveyInfo showSendTab={showSendTab}/>
              </CTabPane>
              <CTabPane role="tabpanel" aria-labelledby="profile-tab" visible={activeKey === 2}>
                <CreateQuestion />
              </CTabPane>
              <CTabPane role="tabpanel" aria-labelledby="home-tab" visible={activeKey === 3}>
                <Send />
              </CTabPane>
            </CTabContent>

        
              <div className="d-grid gap-3 col-md-12 d-md-flex justify-content-md-end">
                <CButton color="primary">
                  Survey Create
                </CButton>
              </div>
          </div>
        </CCardBody>
      </CCard>
    </>
  )
}

export default CreateSurvey