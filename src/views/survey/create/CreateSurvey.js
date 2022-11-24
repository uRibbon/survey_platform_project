import React, { useState } from 'react'
import {
  CButton,
  CFormSelect,
  CFormInput,
  CCol,
  CCard,
  CCardHeader,
  CCardBody,
  CForm,
} from '@coreui/react'
import CreateQuestion from './CreateQuestion'
import axios from "axios";


const Charts = (props) => {
  const [copy, setCopy] = useState(props.copy)
  const [answerType, setAnswerType] = useState()

  let current_question = <CreateQuestion answerType={answerType} />
  let question_num = 1
  const [questions, setQuestions] = useState([])

  function onChangeHandler(event) {
    setAnswerType(event.target.value)
    console.log('answer', answerType)
  }

  function BtnOnclickHandler_Add() {
    console.log(questions)
    questions.concat({ current_question })
    current_question = <CreateQuestion answerType={answerType} />

    setQuestions([current_question, ...questions])
  }

  function BtnOnclickHandler_Delete() {
    console.log(questions)
    current_question = <CreateQuestion answerType={answerType} question_num={question_num} />
    setQuestions(
      questions.slice(0, -1),
      // current_question
    )
  }
  const tempStyle = {
    paddingTop: '20px',
  }

  const [surInfo, setSurInfo] = useState([])

/*
  axios.post("/survey-service/v1/survey/detail",
    {sur_id: 2},
    {headers: {
        'Content-Type': 'multipart/form-data'
      }}
  ).then((response) => {
    setSurInfo(response.data.info)
  })
*/
  return (
    console.log(surInfo),
    <>
     <CCard className="mb-3">
        <CCardHeader>설문 생성<small> 설문을 생성 할 수 있습니다.</small>
        </CCardHeader>
        <CCardBody>
          <CCard className="mb-3">
            <CCardHeader>설문 설정</CCardHeader>
            <CCardBody>
              <CForm className="row g-3">
                <CCol xs={6}>
                  <CFormInput label="설문 이름" placeholder="설문 이름을 입력하세요" value={surInfo.title}/>
                </CCol>
                <CCol xs={6}>
                  <CFormSelect label="설문 분류 선택" value={surInfo.categoryId}>
                    <option value={1}>학교</option>
                    <option value={2}>기업</option>
                    <option value={3}>연애</option>
                    <option value={4}>사업</option>
                    <option value={5}>취미</option>
                  </CFormSelect>
                </CCol>
                <CCol xs={3}>
                  <CFormSelect label="로그인 여부" value={surInfo.isLoginYn}>
                    <option value="Y">로그인 필수</option>
                    <option value="N">로그인 필요 없음</option>
                  </CFormSelect>
                </CCol>
                <CCol xs={3}>
                  <CFormSelect label="설문 공개 선택" value={surInfo.isPrivateYn}>
                    <option value="N">전체 공개</option>
                    <option value="2">그룹 공개</option>
                    <option value="Y">비공개</option>
                  </CFormSelect>
                </CCol>
                <CCol xs={3}>
                  <CFormSelect label="답변 수정 여부" value={surInfo.isModifyYn}>
                    <option value="Y">수정 가능</option>
                    <option value="N">수정 불가능</option>
                  </CFormSelect>
                </CCol>
                <CCol xs={3}>
                  <CFormSelect label="익명 여부 선택" value={surInfo.isAnnoyYn}>
                    <option value="Y">익명 가능</option>
                    <option value="N">수정 불가능</option>
                  </CFormSelect>
                </CCol>
                <CCol xs={12}>
                  <CFormInput label="설문 상세" placeholder="설문 설명을 입력하세요" value={surInfo.description}/>
                </CCol>
              </CForm>
            </CCardBody>
          </CCard>
        </CCardBody>
      </CCard>

      {questions.map((child) => child)}
      {current_question}

      <div className="d-grid gap-2 col-6 mx-auto" style={tempStyle}>
        <CButton color="primary" onClick={BtnOnclickHandler_Add}>
          Add Question
        </CButton>
      </div>
    </>
  )
}

export default Charts