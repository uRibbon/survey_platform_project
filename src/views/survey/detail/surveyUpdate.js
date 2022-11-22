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
  const [answerList, setAnswerList] = useState([])

  // 답변 정보 받아오기
  axios.post("/survey-service/v1/answer/list",
    {regId: "yena", surId: 1},
    {headers: {
        'Content-Type': 'multipart/form-data'
      }}
  ).then((response) => {
    setAnswerList(response.data)
  })

  const makeAnswer = (e, queId) => {
    const answerData = {
      "queId": queId,
      "type": 0,
      "content": e.target.value,
      "regId": "yena"
    }
    setAnswerList(answerList.filter(answer => answer.queId !== queId));
    setAnswerList(answerList=>[...answerList, answerData])
  }

  const sendAnswer = () => {
    axios.post("/survey-service/v1/answer/mod",
      {
        surId: props.surId,
        answerDTOList: answerList
      })
      .then((response) => {
        window.location.reload("/survey/detail");
      })
  }


  return (
    console.log(answerList),
    <div className='mb-3'>
        <CCol lg={12} className="text-start d-flex mb-1">

        </CCol>
        <CAccordion alwaysOpen>
          {answerList.map((answer, index) => (
              <CAccordionItem itemKey={index+1} key={answer.queId}>
                <CAccordionHeader>{index+1}. {answer.queContent} </CAccordionHeader>
                <CAccordionBody>
                  {answer.queType === "YN" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck
                          type="radio"
                          name={answer.ansId}
                          key={option.queOptId}
                          label={option.optionName}
                          defaultChecked={answer.ansContent === option.optionName?true:false}
                          // onChange={(event)=>{makeAnswer(event, answer.queId)}}
                        />
                      ))}
                    </>
                  )}

                  {answer.queType === "NumOnly" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck
                          type="radio"
                          name={answer.ansId}
                          key={option.queOptId}
                          label={option.optionName}
                          defaultChecked={answer.ansContent === option.optionName?true:false}
                          // onChange={(event)=>{makeAnswer(event, answer.queId)}}
                        />
                      ))}
                    </>
                  )}

                  {answer.queType === "NumMul" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck
                          type="checkbox"
                          name={answer.ansId}
                          key={option.queOptId}
                          label={option.optionName}
                          defaultChecked={answer.ansContent === option.optionName?true:false}
                          // onChange={(event)=>{makeAnswer(event, answer.queId)}}
                        />
                      ))}
                    </>
                  )}

                  {answer.queType === "Sub" && (
                    <CFormTextarea
                      name={answer.ansId}
                      defaultValue={answer.ansContent}
                      // onChange={(event)=>{makeAnswer(event, answer.queId)}}
                    ></CFormTextarea>
                  )}

                  {answer.queType == "Grd" && (
                    <CFormRange
                      name={answer.ansId}
                      min="0" max="100" step="10"
                      defaultValue={answer.ansContent}
                      // onChange={(event)=>{makeAnswer(event, answer.queId)}}
                    />
                  )}
                </CAccordionBody>
              </CAccordionItem>
          ))}
        </CAccordion>
      <CCol lg={12} className="text-start d-flex mt-1">
        <CButton color="primary" href="#" className="ms-auto" variant="outline" onClick={sendAnswer}>
          send
        </CButton>
      </CCol>
    </div>
  )
}

export default DetailInfo
