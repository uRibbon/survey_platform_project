import React, { useState } from 'react'
import {
  CCol,
  CButton,
  CFormInput,
  CAccordion,
  CAccordionBody,
  CAccordionHeader,
  CAccordionItem,
  CFormCheck,
  CFormTextarea, CFormRange,
} from '@coreui/react'
import axios from "axios";

const DetailInfo = (props) => {
  const [questionList, setQuestionList] = useState([])
  const [answerList, setAnswerList] = useState([])

  axios.post("/survey-service/v1/survey/detail",
    {sur_id: props.surId},
    {headers: {
        'Content-Type': 'multipart/form-data'
      }}
  ).then((response) => {
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
        surId: props.surId,
        answerDTOList: answerList
      })
      .then((response) => {
        window.location.reload("/#/survey/detail");
      })
  }


  return (
    <div className='mb-3'>
        <CCol lg={12} className="text-start d-flex mb-1">
          <CButton color="success" href="#" className="ms-auto" variant="outline">
              excel download
          </CButton>
          <CButton color="primary" href="#" variant="outline" onClick={sendAnswer}>
            send
          </CButton>
        </CCol>
        <CAccordion alwaysOpen>
          {questionList.map((question, index) => (
            <CAccordionItem itemKey={index+1} key={question.queId}>
              <CAccordionHeader>{index+1}. {question.content} </CAccordionHeader>
              <CAccordionBody>
                <CFormTextarea name="content" onChange={(e) => makeAnswer(e,question.queId)}></CFormTextarea>

                {question.qtype === "YN" && (
                  <>
                    {question.optionList.map((option) => (
                      <CFormCheck type="radio" name="content" key={option.queOptId} label={option.optionName} />
                    ))}
                  </>
                )}

                {question.qtype === "NumOnly" && (
                  <>
                    {question.optionList.map((option) => (
                      <CFormCheck type="radio" name="content" key={option.queOptId} label={option.optionName} />
                    ))}
                  </>
                )}

                {question.qtype === "NumMul" && (
                  <>
                    {question.optionList.map((option) => (
                      <CFormCheck type="checkbox" name="content" key={option.queOptId} label={option.optionName} />
                    ))}
                  </>
                )}

                {question.qtype === "Sub" && (
                  <CFormTextarea name="content"></CFormTextarea>
                )}

                {question.qtype == "Grd" && (
                  <CFormRange name="content" min="0" max="100" step="10"/>
                )}
              </CAccordionBody>
            </CAccordionItem>
          ))}
        </CAccordion>
    </div>
  )
}

export default DetailInfo
