import React, { useState, useEffect } from 'react'
import {
  CFormCheck,
  CFormLabel,
  CForm,
  CFormTextarea,
  CButton,
  CFormSelect,
  CContainer,
  CFormInput,
  CDropdownDivider,
  CDropdownItem,
  CDropdownMenu,
  CDropdownToggle,
  CDropdown,
  CInputGroup,
  CCol,
  CRow,
} from '@coreui/react'
import CreateQuestion from './CreateQuestion'

const Charts = () => {
  const [answerType, setAnswerType] = useState()

  let current_question = <CreateQuestion answerType={answerType} />
  let question_num = 1
  const [questions, setQuestions] = useState([
    <CreateQuestion answerType={1} question_num={1} key={1}/>,
    <CreateQuestion answerType={2} question_num={2} key={2}/>,
    <CreateQuestion answerType={1} question_num={3} key={3}/>,
  ])

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
    <CContainer>
      <CRow>
        <CCol xs={12}>
          <CInputGroup className="mb-3">
            <CDropdown variant="input-group">
              <CDropdownToggle color="secondary" variant="outline">
                연애
              </CDropdownToggle>
              <CDropdownMenu>
                <CDropdownItem href="#">Survey Cat1</CDropdownItem>
                <CDropdownItem href="#">Survey Cat2</CDropdownItem>
                <CDropdownItem href="#">Survey Cat3</CDropdownItem>
                <CDropdownDivider />
                <CDropdownItem href="#">Survey etc</CDropdownItem>
              </CDropdownMenu>
            </CDropdown>
            <CFormInput aria-label="Text input with dropdown button" value="연애 선호도 설문조사(예시)" />
          </CInputGroup>
        </CCol>
      </CRow>
      <CInputGroup className="mb-3">
        <CFormSelect aria-label="Default select example">
          <option>Public/Private</option>
          <option value="1" selected>Public</option>
          <option value="2">Private</option>
        </CFormSelect>
      </CInputGroup>

    {/* Dummy Data Input Start*/}
    {/* Question 1 */}
    <CContainer>
      <CRow className="mb-3">
        <CFormLabel htmlFor="staticEmail" className="col-sm-2 col-form-label">
          Question 1
        </CFormLabel>
        <CCol sm={10}>
          <CFormInput type="text" id="staticEmail" value="첫번째 주관식 질문입니다." readonly/>
        </CCol>
      </CRow>
        <CForm style={tempStyle}>
          <CFormTextarea
            id="exampleFormControlTextarea1"
            label="Answer"
            rows="3"
            text="Must be 8-20 words long."
          ></CFormTextarea>
        </CForm>
    </CContainer>

    {/* Question 2 */}
    <CContainer>
      <CRow className="mb-3">
        <CFormLabel htmlFor="staticEmail" className="col-sm-2 col-form-label">
          Question 2
        </CFormLabel>
        <CCol sm={10}>
          <CFormInput type="text" id="staticEmail" value="두번째 객관식 질문입니다." readonly/>
        </CCol>
      </CRow>
        <CRow style={tempStyle}>
          <CFormCheck label="두번째 객관식 질문의 보기 1번입니다."/>
          <CFormCheck label="두번째 객관식 질문의 보기 2번입니다." />
          <CFormCheck label="두번째 객관식 질문의 보기 3번입니다." />
          <CFormCheck label="두번째 객관식 질문의 보기 4번입니다" />
        </CRow>
    </CContainer>

    {/* Question 3 */}
    <CContainer>
      <CRow className="mb-3">
        <CFormLabel htmlFor="staticEmail" className="col-sm-2 col-form-label">
          Question 3
        </CFormLabel>
        <CCol sm={10}>
          <CFormInput type="text" id="staticEmail" value="세번째 객관식 질문입니다." readonly/>
        </CCol>
      </CRow>
        <CRow style={tempStyle}>
          <CFormCheck label="세번째 객관식 질문의 보기 1번입니다."/>
          <CFormCheck label="세번째 객관식 질문의 보기 2번입니다." />
          <CFormCheck label="세번째 객관식 질문의 보기 3번입니다." />
          <CFormCheck label="세번째 객관식 질문의 보기 4번입니다" />
        </CRow>
    </CContainer>

    {/* Question 4 */}
    <CContainer>
      <CRow className="mb-3">
        <CFormLabel htmlFor="staticEmail" className="col-sm-2 col-form-label">
          Question 4
        </CFormLabel>
        <CCol sm={10}>
          <CFormInput type="text" id="staticEmail" value="네번째 주관식 질문입니다." readonly/>
        </CCol>
      </CRow>
        <CForm style={tempStyle}>
          <CFormTextarea
            id="exampleFormControlTextarea1"
            label="Answer"
            rows="3"
            text="Must be 8-20 words long."
          ></CFormTextarea>
        </CForm>
    </CContainer>
    {/* Dummy Data Input End */}

      <div className="d-grid gap-2 col-6 mx-auto" style={tempStyle}>
        <CButton color="primary" onClick={BtnOnclickHandler_Add}>
          Add Question
        </CButton>
        <CButton color="primary" onClick={BtnOnclickHandler_Delete}>
          Delete Question
        </CButton>
      </div>
    </CContainer>
  )
}

export default Charts
