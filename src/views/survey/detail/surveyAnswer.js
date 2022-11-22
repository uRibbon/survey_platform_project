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
    {regId: "yena", surId: props.surId},
    {headers: {
        'Content-Type': 'multipart/form-data'
      }}
  ).then((response) => {
    setAnswerList(response.data)
  })



  return (
    <div className='mb-3'>
        <CCol lg={12} className="text-start d-flex mb-1">
          <CButton color="success" href="#" className="ms-auto" variant="outline">
              excel download
          </CButton>
        </CCol>
        <CAccordion alwaysOpen>
          {answerList.map((answer, index) => (
              <CAccordionItem itemKey={index+1} key={answer.queId}>
                <CAccordionHeader>{index+1}. {answer.queContent} </CAccordionHeader>
                <CAccordionBody>
                  <CFormTextarea name="content" value={answer.ansContent} readOnly={true}></CFormTextarea>

                  {answer.quetype === "YN" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck type="radio" name="content" key={option.queOptId} label={option.optionName} />
                      ))}
                    </>
                  )}

                  {answer.quetype === "NumOnly" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck type="radio" name="content" key={option.queOptId} label={option.optionName} />
                      ))}
                    </>
                  )}

                  {answer.quetype === "NumMul" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck type="checkbox" name="content" key={option.queOptId} label={option.optionName} />
                      ))}
                    </>
                  )}

                  {answer.quetype === "Sub" && (
                    <CFormTextarea name="content"></CFormTextarea>
                  )}

                  {answer.quetype == "Grd" && (
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
