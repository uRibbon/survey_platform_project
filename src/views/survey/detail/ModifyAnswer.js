import {
  CForm,
  CBadge, CButton, CCard, CCardBody, CCardHeader, CFormCheck, CFormRange, CFormTextarea, CCol, CRow
} from "@coreui/react";
import React from "react";
import SurveyInfo from "./surveyinfo";
import SurveyUpdate from "./surveyUpdate";
// import { useHistory } from "react-router";

const ModifySurvey = () => {

  // const history = useHistory();
  // history.push('/hi')
  return(
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong>답변 수정 </strong>
            <small> 참여한 설문의 답변을 수정 할 수 있습니다.</small>
          </CCardHeader>
          <CCardBody>
            <div>
              <SurveyInfo surId={2}></SurveyInfo>
              <SurveyUpdate surId={2}/>
            </div>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>

  )
}

export default ModifySurvey
