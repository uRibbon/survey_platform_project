import React, { useState } from 'react'
import { CButton, CFormSelect, CContainer, CFormInput,CDropdownDivider, CDropdownItem, CDropdownMenu,CDropdownToggle,CDropdown,CInputGroup,CCard, CCardBody, CCol, CCardHeader, CRow } from '@coreui/react'
import QuestionModal from './QuestionModal'

const Charts = () => {
  const [answerType, setAnswerType] = useState();

  let current_question = <QuestionModal answerType={answerType}/>
  let question_num = 1
  const [questions, setQuestions] = useState([]);

  function onChangeHandler(event){
    setAnswerType(event.target.value);
    console.log('answer',answerType);
  }

  function BtnOnclickHandler_Add(){
    console.log(questions)
    questions.concat({current_question})
    current_question = <QuestionModal answerType={answerType}/>

    setQuestions(
        [
          current_question,
          ...questions
          ]
      );
  }

  function BtnOnclickHandler_Delete(){
    console.log(questions)
    current_question = <QuestionModal answerType={answerType} question_num={question_num}/>
    setQuestions(
      questions.slice(0, -1),
      // current_question
    );
  }


  const tempStyle={        
    paddingTop:"20px" }

  return (
    <CContainer>
    <CRow>
      <CCol xs={12}>
      <CInputGroup className="mb-3">
        <CDropdown variant="input-group">
          <CDropdownToggle color="secondary" variant="outline">Survey Category</CDropdownToggle>
          <CDropdownMenu>
            <CDropdownItem href="#">Survey Cat1</CDropdownItem>
            <CDropdownItem href="#">Survey Cat2</CDropdownItem>
            <CDropdownItem href="#">Survey Cat3</CDropdownItem>
            <CDropdownDivider/>
            <CDropdownItem href="#">Survey etc</CDropdownItem>
          </CDropdownMenu>
        </CDropdown>
        <CFormInput aria-label="Text input with dropdown button"/>
        <CDatePicker locale="en-US" />
      </CInputGroup>
      </CCol>
    </CRow>

    <CInputGroup className="mb-3">
      <CFormSelect aria-label="Default select example">
        <option>Question Category</option>
        <option value="1">Question Cat 1</option>
        <option value="2">Question Cat 2</option>
      </CFormSelect>
      <CFormSelect aria-label="Default select example">
        <option>Select Question</option>
        <option value="1">Question 1</option>
        <option value="2">Question 2</option>
      </CFormSelect>
      <CFormSelect aria-label="Default select example" onChange={onChangeHandler}>
        <option>Answer Type</option>
        <option value="1">Essay Question</option>
        <option value="2">Multiple choice Question</option>
      </CFormSelect>
      <CFormSelect aria-label="Default select example">
        <option>Public/Private</option>
        <option value="1">Public</option>
        <option value="2">Private</option>
      </CFormSelect>
    </CInputGroup>

    
    {questions.map(child => child)}
    {current_question}
    
    <div className="d-grid gap-2 col-6 mx-auto" style={tempStyle}>
      <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Question</CButton>
      <CButton color="primary" onClick={BtnOnclickHandler_Delete}>Delete Question</CButton>
    </div>
  </CContainer>
  
  )
}

export default Charts
