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
  return (
    <CRow>
      <CCol xs={6}>
        <CCard className="mb-3">
          <CCardHeader>
            질문1<CCloseButton className="float-end"/>
          </CCardHeader>
          <CCardBody>
            <CRow>
              <CCol className="mb-3" xs={12}>
                <CFormSelect onChange={onChangeHandler} label="Type">
                  <option value="1">주관식</option>
                  <option value="2">객관식(중복 허용)</option>
                  <option value="3">객관식(중복 불가)</option>
                  <option value="4">찬부식</option>
                  <option value="5">서열식</option>
                </CFormSelect>
              </CCol>
              <CCol className="mb-3" xs={12}>
                <CFormInput type="text" label="Question"/>
              </CCol>
            </CRow>

            {answerType === '1' && (
              <CCol>

              </CCol>
            )}

            {answerType === '2' && (
              <CRow>
                <CCol className="mb-3" xs={12}><CFormInput type="text" label="Answer 1"/></CCol>
                <CCol className="mb-3" xs={12}>
                  <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
                </CCol>
              </CRow>
            )}
            {answerType === '3' && (
              <CRow>
                <CCol className="mb-3" xs={12}><CFormInput type="text" label="Answer 1"/></CCol>
                <CCol className="mb-3" xs={12}>
                  <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
                </CCol>
              </CRow>
            )}
            {answerType === '4' && (
              <CCol>

              </CCol>
            )}
            {answerType === '5' && (
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
          <CCardHeader>질문1. 가장 좋아하는 카카오 캐릭터는?</CCardHeader>
          <CCardBody>
            {answerType === '1' && (
              <CFormTextarea></CFormTextarea>
            )}
            {answerType === '2' && (
              <>
                <CFormCheck type="checkbox" name="flexRadioDefault" id="flexRadioDefault1" label="1. 춘식이" />
                <CFormCheck type="checkbox" name="flexRadioDefault" id="flexRadioDefault2" label="2. 라이언" />
                <CFormCheck type="checkbox" name="flexRadioDefault" id="flexRadioDefault2" label="3. 어피치" />
                <CFormCheck type="checkbox" name="flexRadioDefault" id="flexRadioDefault2" label="4. 포르도" />
              </>
            )}
            {answerType === '3' && (
              <>
                <CFormCheck type="radio" name="flexRadioDefault" id="flexRadioDefault1" label="1. 춘식이" />
                <CFormCheck type="radio" name="flexRadioDefault" id="flexRadioDefault2" label="2. 라이언" />
                <CFormCheck type="radio" name="flexRadioDefault" id="flexRadioDefault2" label="3. 어피치" />
                <CFormCheck type="radio" name="flexRadioDefault" id="flexRadioDefault2" label="4. 포르도" />
              </>
            )}
            {answerType === '4' && (
              <>
                <CFormCheck type="radio" name="flexRadioDefault" id="flexRadioDefault1" label="예"/>
                <CFormCheck type="radio" name="flexRadioDefault" id="flexRadioDefault2" label="아니오"/>
              </>
            )}
            {answerType === '5' && (
              <CFormRange min="0" max="100" step="10"/>
            )}
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default CreateQuestion
