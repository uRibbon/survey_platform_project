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
  CCallout, CForm,
} from "@coreui/react";
import axios from "axios";

const ParticipateSurvey = () => {
  const [surId, setSurId] = useState(2)
  const [surInfo, setSurInfo] = useState([])
  const [questionList, setQuestionList] = useState([])
  const [content, setContent] = useState("")
  const [answerList, setAnswerList] = useState([])



  axios.post("/survey-service/v1/survey/detail",
    {sur_id: surId},
    {headers: {
        'Content-Type': 'multipart/form-data'
      }}
  ).then((response) => {
      setSurInfo(response.data.info)
      setQuestionList(response.data.question_list)
  })

  const makeAnswer = (e, queId) => {
    const answerData = {
      "queId": queId,
      "type": 0,
      "content": e.target.value,
      "regId": "yena"
    }
    setAnswerList(answerList=>[...answerList, answerData])
  }

  const sendAnswer = () => {
    axios.post("/survey-service/v1/answer/reg",
      {
        surId: surId,
        answerDTOList: answerList
      })
      .then((response) => {
      window.location.reload("/#/survey/prtcpList");
    })
  }

  return(
    <>
      <CBadge color="secondary" className="m-3 mb-0">{surInfo.categoryContent}</CBadge>
      <h1 className="m-3">{surInfo.title}</h1>
      <CCallout className="m-3" color="secondary">{surInfo.description}</CCallout>

      {questionList.map((question, index) => (
          <CCard className="m-3" key={question.queId}>
            <CCardHeader>질문{index+1}. {question.content}</CCardHeader>
            <CCardBody>
              <CFormTextarea name="content" onChange={(e) => makeAnswer(e,question.queId)}></CFormTextarea>

              {question.qtype === "YN" && (
                <>
                  <CFormCheck type="radio" name="question4" id="question4" label="예" />
                  <CFormCheck type="radio" name="question4" id="question4" label="아니오" />
                </>
              )}

              {question.qtype === "Num" && (
                <>
                  <CFormCheck type="radio" name="question2" id="question2" label="1. 춘식이" />
                  <CFormCheck type="radio" name="question2" id="question2" label="2. 라이언" />
                  <CFormCheck type="radio" name="question2" id="question2" label="3. 어피치" />
                  <CFormCheck type="radio" name="question2" id="question2" label="4. 포르도" />
                </>
              )}

              {question.qtype === "Sub" && (
                <CFormTextarea name="content" onChange={(e) => setContent(e.target.value)}></CFormTextarea>
              )}

              {question.qtype == "Grd" && (
                <CFormRange min="0" max="100" step="10"/>
              )}

            </CCardBody>
          </CCard>
      ))}

      <CButton className="m-3" onClick={sendAnswer}>제출하기</CButton>


      {/*<CCard className="m-3">*/}
      {/*  <CCardHeader>질문1. 가장 좋아하는 카카오 캐릭터는?</CCardHeader>*/}
      {/*  <CCardBody>*/}
      {/*    <CFormTextarea></CFormTextarea>*/}
      {/*  </CCardBody>*/}
      {/*</CCard>*/}
      {/*<CCard className="m-3">*/}
      {/*  <CCardHeader>질문2. 다음 중 가장 좋아하는 캐릭터는?</CCardHeader>*/}
      {/*  <CCardBody>*/}
      {/*    <CFormCheck type="radio" name="question2" id="question2" label="1. 춘식이" />*/}
      {/*    <CFormCheck type="radio" name="question2" id="question2" label="2. 라이언" />*/}
      {/*    <CFormCheck type="radio" name="question2" id="question2" label="3. 어피치" />*/}
      {/*    <CFormCheck type="radio" name="question2" id="question2" label="4. 포르도" />*/}
      {/*  </CCardBody>*/}
      {/*</CCard>*/}
      {/*<CCard className="m-3">*/}
      {/*  <CCardHeader>질문3. 싫어하는 캐릭터를 모두 골라주세요.</CCardHeader>*/}
      {/*  <CCardBody>*/}
      {/*    <CFormCheck type="checkbox" name="question3" id="question3" label="1. 춘식이" />*/}
      {/*    <CFormCheck type="checkbox" name="question3" id="question3" label="2. 라이언" />*/}
      {/*    <CFormCheck type="checkbox" name="question3" id="question3" label="3. 어피치" />*/}
      {/*    <CFormCheck type="checkbox" name="question3" id="question3" label="4. 포르도" />*/}
      {/*  </CCardBody>*/}
      {/*</CCard>*/}
      {/*<CCard className="m-3">*/}
      {/*  <CCardHeader>질문4. 춘식이를 좋아하나요?</CCardHeader>*/}
      {/*  <CCardBody>*/}
      {/*    <CFormCheck type="radio" name="question4" id="question4" label="예" />*/}
      {/*    <CFormCheck type="radio" name="question4" id="question4" label="아니오" />*/}
      {/*  </CCardBody>*/}
      {/*</CCard>*/}
      {/*<CCard className="m-3">*/}
      {/*  <CCardHeader>질문5. 춘식이를 얼마나 좋아하나요?</CCardHeader>*/}
      {/*  <CCardBody>*/}
      {/*    <CFormRange min="0" max="100" step="10"/>*/}
      {/*  </CCardBody>*/}
      {/*</CCard>*/}

    </>

  )
}
export default ParticipateSurvey
