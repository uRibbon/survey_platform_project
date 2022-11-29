import React, { useState } from 'react';
import produce from 'immer';
import {
  CFormCheck,
  CFormTextarea,
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
} from '@coreui/react'

const Question = ({question}) => {
//   const [answers, setAnswers] = useState([])

  function onChangeHandler(e) {
    const { value, name } = e.target;
    console.log(value);
    console.log(name);

  }

  function onChangeHandler2(e) {
    const { value, name } = e.target;
    console.log(value);
    console.log(name);

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

  function onclickDeleteBtn(){
    console.log(question.id);

  }
  return (
    <>
    <CRow key={question.id}>
      <CCol xs={6}>
        <CCard className="mb-3">
          <CCardHeader>
            질문{question.id}
            <CCloseButton className="float-end" onClick={onclickDeleteBtn}/>
          </CCardHeader>
          <CCardBody>
            <CRow>
              <CCol className="mb-3" xs={12}>
                <CFormSelect name="answer_type" value={question.questionType} label="Type" onChange={onChangeHandler}>
                  <option value="Sub">주관식</option>
                  <option value="NumMul">객관식(중복 허용)</option>
                  <option value="NumOnly">객관식(중복 불가)</option>
                  <option value="YN">찬부식</option>
                  <option value="Grd">서열식</option>
                </CFormSelect>
              </CCol>
              <CCol className="mb-3" xs={12}>
                <CFormInput name ="question_content" type="text" label="Question" value={question.content}  onChange={onChangeHandler2}/>
              </CCol>
            </CRow>

            {question.questionType === 'Sub' && (
              <CCol>

              </CCol>
            )}

            {question.questionType === 'NumMul' && (
              <CRow>
                <CCol className="mb-3" xs={12}><CFormInput type="text" label="Answer 1"/></CCol>
                <CCol className="mb-3" xs={12}>
                  <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
                </CCol>
              </CRow>
            )}
            {question.questionType === 'NumOnly' && (
              <CRow>
                <CCol className="mb-3" xs={12}><CFormInput type="text" label="Answer 1"/></CCol>
                <CCol className="mb-3" xs={12}>
                  <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
                </CCol>
              </CRow>
            )}
            {question.questionType === 'YN' && (
              <CCol>

              </CCol>
            )}
            {question.questionType === 'Grd' && (
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
          <CCardHeader>질문{question.id}. {question.content}</CCardHeader>
          <CCardBody>
            {question.questionType === 'Sub' && (
              <CFormTextarea></CFormTextarea>
            )}
            {question.questionType === 'NumMul' && (
              <>
                {question.optionList.map((option) => (
                  <CFormCheck key={option.queOptId} type="checkbox" label={option.optionName} />
                ))}
              </>
            )}
            {question.questionType === 'NumOnly' && (
              <>
                {question.optionList.map((option) => (
                  <CFormCheck key={option.queOptId} type="radio" label={option.optionName} />
                ))}
              </>
            )}
            {question.questionType === 'YN' && (
              <>
                {question.optionList.map((option) => (
                  <CFormCheck key={option.queOptId} type="radio" label={option.optionName} />
                ))}
              </>
            )}
            {question.questionType === 'Grd' && (
              <CFormRange min="0" max="100" step="10"/>
            )}
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
    </>
    )
}

export default Question