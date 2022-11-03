import React, { useState } from 'react'
import {
  CForm,
  CFormSelect,
  CFormLabel,
  CFormTextarea,
  CFormInput,
  CCol,
  CRow,
  CCard,
  CCardBody,
  CCardHeader,
  CCloseButton, CButton,
} from '@coreui/react'

const QuestionModal = (props) => {

  const [answerType, setAnswerType] = useState()
  const [answers, setAnswers] = useState([])

  function onChangeHandler(event) {
    setAnswerType(event.target.value)
    console.log('answer', answerType)
  }

  function BtnOnclickHandler_Add() {
    // console.log(questions)
    // answers.concat({ current_answer })
    // current_answer = <QuestionModal answerType={answerType} />

    // setQuestions([current_question, ...questions])
  }

  function BtnOnclickHandler_Delete() {
    // console.log(questions)
    // current_question = <QuestionModal answerType={answerType} question_num={question_num} />
    // setQuestions(
    //   questions.slice(0, -1),
    //   // current_question
    // )
  }

  return (
    <CCard className="mb-3">
      <CCardHeader>
        <CRow>
          <CCol xs={11}>질문1</CCol>
          <CCol xs={1}><CCloseButton/></CCol>
        </CRow>
      </CCardHeader>
      <CCardBody>
      <CForm>
        <CCol xs={4}>
          <CFormSelect label="답변 종류 선택" onChange={onChangeHandler}>
            <option value="1">주관식</option>
            <option value="2">객관식</option>
          </CFormSelect>
        </CCol>
      </CForm>

        <CRow>
          <CCol className="mb-5" xs={2}><CFormLabel>Question</CFormLabel></CCol>
          <CCol className="mb-5" xs={10}><CFormInput type="text"/></CCol>
        </CRow>
        
        {answerType === '1' && (
          <CRow>
            <CCol className="mb-3" xs={2}><CFormLabel>Answer</CFormLabel></CCol>
            <CCol className="mb-3" xs={10}><CFormTextarea rows="3"/></CCol>
          </CRow>
        )}

        {answerType === '2' && (
          <CRow>
            <CCol className="mb-3" xs={2}><CFormLabel>Answer 1</CFormLabel></CCol>
            <CCol className="mb-3" xs={10}><CFormInput type="text"/></CCol>
            <CCol className="mb-3" xs={2}><CFormLabel>Answer 2</CFormLabel></CCol>
            <CCol className="mb-3" xs={10}><CFormInput type="text"/></CCol>

            <div className="d-grid gap-3 col-6 mx-auto">
              <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
              <CButton color="primary" onClick={BtnOnclickHandler_Delete}>Delete Answer</CButton>
            </div>
          </CRow>
        )}
      </CCardBody>
    </CCard>
  )
}

export default QuestionModal
