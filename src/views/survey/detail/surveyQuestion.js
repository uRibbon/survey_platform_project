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

  axios.post("/survey-service/v1/survey/detail",
    {sur_id: props.surId},
    {headers: {
        'Content-Type': 'multipart/form-data'
      }}
  ).then((response) => {
    setQuestionList(response.data.question_list)
  })

  return (
    <div className='mb-3'>
        <CCol lg={12} className="text-start d-flex mb-1">
            <CButton color="success" href="#" className="ms-auto" variant="outline">
                exel download
            </CButton>
          </CCol>
        <CAccordion alwaysOpen>
          {questionList.map((question, index) => (
            <CAccordionItem itemKey={index+1} key={question.queId}>
              <CAccordionHeader>{index+1}. {question.content} </CAccordionHeader>
              <CAccordionBody>
                {question.qtype === "YN" && (
                  <>
                    <CFormCheck type="radio" name="content" id="question4" label="예" />
                    <CFormCheck type="radio" name="content" id="question4" label="아니오" />
                  </>
                )}

                {question.qtype === "Num" && (
                  <>
                    <CFormCheck type="radio" name="content" label="1. 춘식이" />
                    <CFormCheck type="radio" name="content" label="2. 라이언" />
                    <CFormCheck type="radio" name="content" label="3. 어피치" />
                    <CFormCheck type="radio" name="content" label="4. 포르도" />
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

            {/*<CAccordionItem itemKey={1}>*/}
            {/*    <CAccordionHeader>1. 이름을 입력해주세요. </CAccordionHeader>*/}
            {/*    <CAccordionBody>*/}
            {/*    <CFormInput*/}
            {/*        type="text"*/}
            {/*        placeholder="이름을 입력해주세요."*/}
            {/*        value= "고솔비"*/}
            {/*        readOnly*/}
            {/*    />               */}
            {/*    </CAccordionBody>*/}
            {/*</CAccordionItem>*/}

            {/*<CAccordionItem itemKey={2}>*/}
            {/*    <CAccordionHeader>2. 성별을 입력해주세요. </CAccordionHeader>*/}
            {/*    <CAccordionBody>*/}
            {/*    <CFormCheck*/}
            {/*    type="radio"*/}
            {/*    name="gender"*/}
            {/*    id="gender_M"*/}
            {/*    label="남성"*/}
            {/*    disabled*/}
            {/*     />*/}
            {/*    <CFormCheck*/}
            {/*    type="radio"*/}
            {/*    name="gender"*/}
            {/*    id="gender_W"*/}
            {/*    label="여성"*/}
            {/*    checked*/}
            {/*    disabled*/}
            {/*    />*/}
            {/*    </CAccordionBody>*/}
            {/*</CAccordionItem>*/}
            {/*<CAccordionItem itemKey={3}>*/}
            {/*    <CAccordionHeader>3. 기타 하고싶은 말씀을 남겨주세요. </CAccordionHeader>*/}
            {/*    <CAccordionBody>*/}
            {/*    <CFormTextarea id="exampleFormControlTextarea1" rows="3">안녕하세요~~~~~~</CFormTextarea>*/}
            {/*    </CAccordionBody>*/}
            {/*</CAccordionItem>*/}

        </CAccordion>
    </div>
  )
}

export default DetailInfo
