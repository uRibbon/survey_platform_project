import React, { useState } from 'react'
import ResultSurvey from './ResultSurvey'
import ShareSurvey from './ShareSurvey'
import CreateSurvey from './CreateSurvey'
import Send from './create/Send'
import { CNav,CNavItem,CNavLink,CTabContent,CTabPane } from '@coreui/react'

const Charts = () => {
  const [activeKey, setActiveKey] = useState(1)

  return (
      <div>
        <div style={{
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        height: '10vh',
      }}>
        <CNav variant="pills" role="tablist">
          
          <CNavItem>
            <CNavLink
              href="javascript:void(0);"
              active={activeKey === 1}
              onClick={() => setActiveKey(1)}
            >
              설문 작성
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink
              href="javascript:void(0);"
              active={activeKey === 2}
              onClick={() => setActiveKey(2)}
            >
              설문 공유
            </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink
              href="javascript:void(0);"
              active={activeKey === 3}
              onClick={() => setActiveKey(3)}
            >
              설문 결과
            </CNavLink>
          </CNavItem>
        </CNav>
        </div>
        
        <CTabContent>
          <CTabPane role="tabpanel" aria-labelledby="home-tab" visible={activeKey === 1}>
            <CreateSurvey/>
          </CTabPane>
          <CTabPane role="tabpanel" aria-labelledby="profile-tab" visible={activeKey === 2}>
            <Send/>
          </CTabPane>
          <CTabPane role="tabpanel" aria-labelledby="contact-tab" visible={activeKey === 3}>
            <ResultSurvey/>
          </CTabPane>
        </CTabContent>
      </div>
    )
}

export default Charts
