import React, {useState} from "react";
import {
  CCard,
  CCardHeader,
  CCardBody,
  CFormCheck,
  CFormRange,
  CFormTextarea,
  CButton,
  CBadge,
  CCallout, CForm, CRow, CCol, CNav, CNavItem, CNavLink, CTabContent, CTabPane,
} from "@coreui/react";
import axios from "axios";
import SurveyInfo from "./info/SurveyInfo";
import QuestionInfo from "./info/QuestionInfo";
import Charts from "../../analysis/user_survey_analysis";

const RegisterAnswer = () => {
  const [activeKey, setActiveKey] = useState(1)
  const [surId, setSurId] = useState(2)

  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong> 설문 참여 </strong>
            <small> 설문에 참여 할 수 있습니다.</small>
          </CCardHeader>
          <CCardBody>
            <div>
              <SurveyInfo surId={surId}></SurveyInfo>
              <QuestionInfo surId={surId}/>
            </div>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}
export default RegisterAnswer
