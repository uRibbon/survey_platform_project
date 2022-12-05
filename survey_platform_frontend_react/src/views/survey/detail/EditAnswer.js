import {
  CCard, CCardBody, CCardHeader, CCol, CRow,
} from "@coreui/react";
import React from "react";
import SurveyInfo from "./info/SurveyInfo";
import UpdateInfo from "./info/UpdateInfo";
// import { useHistory } from "react-router";
import { useParams } from 'react-router-dom'; 

const ModifySurvey = () => {

const params = useParams();
let surId = params.sur_id;

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
              <SurveyInfo surId={surId}></SurveyInfo>
              <UpdateInfo surId={surId}/>
            </div>
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>

  )
}

export default ModifySurvey
