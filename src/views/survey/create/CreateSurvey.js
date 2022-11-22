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
  return (
    <>
      <CCard className="mb-3">
        <CCardHeader>설문 설정</CCardHeader>
        <CCardBody>
          <CForm className="row g-3">
            <CCol xs={4}>
              <CFormInput label="설문 이름" placeholder="설문 이름을 입력하세요"/>
            </CCol>
            <CCol xs={4}>
              <CFormSelect label="설문 분류 선택">
                <option value="1">학교</option>
                <option value="2">기업</option>
                <option value="3">연애</option>
                <option value="4">사업</option>
                <option value="5">취미</option>
              </CFormSelect>
            </CCol>
            <CCol xs={4}>
              <CFormSelect label="설문 공개 선택">
                <option value="1">전체 공개</option>
                <option value="2">그룹 공개</option>
                <option value="3">비공개</option>
              </CFormSelect>
            </CCol>
          </CForm>
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