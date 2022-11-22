import React, { useState } from 'react'
import {
  CFormLabel,
  CFormCheck,
  CFormTextarea,
  CInputGroup,
  CForm,
  CContainer,
  CFormInput,
  CCol,
  CRow,
  CCardHeader,
  CCloseButton,
  CCardBody,
  CButton,
  CCard,
  CFormRange,
  CFormSelect,
  CFormSwitch,
} from '@coreui/react'
import axios from "axios";

const CreateQuestion = (props) => {
  const [answerType, setAnswerType] = useState()
  const [answers, setAnswers] = useState([])

  function onChangeHandler(event) {
    setAnswerType(event.target.value)
    console.log('answer', answerType)
  }

  function BtnOnclickHandler_Add() {
    // console.log(questions)
    // answers.concat({ current_answer })
    // current_answer = <CreateQuestion answerType={answerType} />

    // setQuestions([current_question, ...questions])
  }

  function BtnOnclickHandler_Delete() {
    // console.log(questions)
    // current_question = <CreateQuestion answerType={answerType} question_num={question_num} />
    // setQuestions(
    //   questions.slice(0, -1),
    //   // current_question
    // )
  }

  const [questionList, setQuestionList] = useState([])

  axios.post("/survey-service/v1/survey/detail",
    {sur_id: 2},
    {headers: {
        'Content-Type': 'multipart/form-data'
      }}
  ).then((response) => {
    setQuestionList(response.data.question_list)
  })

  return (
    questionList.map((question, index) => (
    <CRow key={question.queId}>
      <CCol xs={6}>
        <CCard className="mb-3">
          <CCardHeader>
            질문{index+1}<CCloseButton className="float-end"/>
          </CCardHeader>
          <CCardBody>
            <CRow>
              <CCol className="mb-3" xs={12}>
                <CFormSelect value={question.qtype} label="Type">
                  <option value="Sub">주관식</option>
                  <option value="NumMul">객관식(중복 허용)</option>
                  <option value="NumOnly">객관식(중복 불가)</option>
                  <option value="YN">찬부식</option>
                  <option value="Grd">서열식</option>
                </CFormSelect>
              </CCol>
              <CCol className="mb-3" xs={12}>
                <CFormInput type="text" label="Question" value={question.content}/>
              </CCol>
            </CRow>

            {question.qtype === 'Sub' && (
              <CCol>

              </CCol>
            )}

            {question.qtype === 'NumMul' && (
              <CRow>
                <CCol className="mb-3" xs={12}><CFormInput type="text" label="Answer 1"/></CCol>
                <CCol className="mb-3" xs={12}>
                  <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
                </CCol>
              </CRow>
            )}
            {question.qtype === 'NumOnly' && (
              <CRow>
                <CCol className="mb-3" xs={12}><CFormInput type="text" label="Answer 1"/></CCol>
                <CCol className="mb-3" xs={12}>
                  <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
                </CCol>
              </CRow>
            )}
            {question.qtype === 'YN' && (
              <CCol>

              </CCol>
            )}
            {question.qtype === 'Grd' && (
              <CRow>
                {/*<CCol className="mb-3" xs={4}>*/}
                {/*  <CFormInput type="number" label="Step"></CFormInput>*/}
                {/*</CCol>*/}
                {/*<CCol className="mb-3" xs={4}>*/}
                {/*  <CFormInput type="number" label="Max"></CFormInput>*/}
                {/*</CCol>*/}
                {/*<CCol className="mb-3" xs={4}>*/}
                {/*  <CFormInput type="number" label="Min"></CFormInput>*/}
                {/*</CCol>*/}
              </CRow>
            )}
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-3">
          <CCardHeader>질문{index+1}. {question.content}</CCardHeader>
          <CCardBody>
            {question.qtype === 'Sub' && (
              <CFormTextarea></CFormTextarea>
            )}
            {question.qtype === 'NumMul' && (
              <>
                {question.optionList.map((option) => (
                  <CFormCheck key={option.queOptId} type="checkbox" label={option.optionName} />
                ))}
              </>
            )}
            {question.qtype === 'NumOnly' && (
              <>
                {question.optionList.map((option) => (
                  <CFormCheck key={option.queOptId} type="radio" label={option.optionName} />
                ))}
              </>
            )}
            {question.qtype === 'YN' && (
              <>
                {question.optionList.map((option) => (
                  <CFormCheck key={option.queOptId} type="radio" label={option.optionName} />
                ))}
              </>
            )}
            {question.qtype === 'Grd' && (
              <CFormRange min="0" max="100" step="10"/>
            )}
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
    ))
  )
}

export default CreateQuestion