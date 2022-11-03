import React from "react";
import {
  CCard,
  CCardHeader,
  CCardBody,
  CFormCheck,
  CFormRange,
  CFormTextarea,
  CButton,
  CBadge,
} from "@coreui/react";

const ParticipateSurvey = () => {
  return(
    <>
      <CBadge color="secondary" className="m-3 mb-0">기업</CBadge>
      <h1 className="m-3">카카오 캐릭터 선호도 조사</h1>
      <CCard className="m-3">
        <CCardHeader>질문1. 가장 좋아하는 카카오 캐릭터는?</CCardHeader>
        <CCardBody>
          <CFormTextarea></CFormTextarea>
        </CCardBody>
      </CCard>
      <CCard className="m-3">
        <CCardHeader>질문2. 다음 중 가장 좋아하는 캐릭터는?</CCardHeader>
        <CCardBody>
          <CFormCheck type="radio" name="question2" id="question2" label="1. 춘식이" />
          <CFormCheck type="radio" name="question2" id="question2" label="2. 라이언" />
          <CFormCheck type="radio" name="question2" id="question2" label="3. 어피치" />
          <CFormCheck type="radio" name="question2" id="question2" label="4. 포르도" />
        </CCardBody>
      </CCard>
      <CCard className="m-3">
        <CCardHeader>질문3. 싫어하는 캐릭터를 모두 골라주세요.</CCardHeader>
        <CCardBody>
          <CFormCheck type="checkbox" name="question3" id="question3" label="1. 춘식이" />
          <CFormCheck type="checkbox" name="question3" id="question3" label="2. 라이언" />
          <CFormCheck type="checkbox" name="question3" id="question3" label="3. 어피치" />
          <CFormCheck type="checkbox" name="question3" id="question3" label="4. 포르도" />
        </CCardBody>
      </CCard>
      <CCard className="m-3">
        <CCardHeader>질문4. 춘식이를 좋아하나요?</CCardHeader>
        <CCardBody>
          <CFormCheck type="radio" name="question4" id="question4" label="예" />
          <CFormCheck type="radio" name="question4" id="question4" label="아니오" />
        </CCardBody>
      </CCard>
      <CCard className="m-3">
        <CCardHeader>질문5. 춘식이를 얼마나 좋아하나요?</CCardHeader>
        <CCardBody>
          <CFormRange min="0" max="100" step="10"/>
        </CCardBody>
      </CCard>
      <CButton className="m-3">제출하기</CButton>
    </>

  )
}
export default ParticipateSurvey
