import React, { useState } from 'react';

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

const Question = ({question, changeContent, deleteQuestion, editQuestionType}) => {
    const [answers, setAnswers] = useState([]);

    // 질문 내용 수정
    function onChangeQuestionContent(e) {
        const { value, name } = e.target;
        const id = question.get("id");
        changeContent({id, value, name});
    }

    //질문 유형 수정
    function onChangeQuestionType(e) {
        const { value, name } = e.target;
        const id = question.get("id");
        editQuestionType({id, value, name});
    }

    // 삭제 클릭
    function onclickDeleteBtn(){
        const id = question.get("id");
        deleteQuestion({id});
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
    <>
    <CRow key={question.get("id")}>
        <CCol xs={6}>
        <CCard className="mb-3">
            <CCardHeader>
            질문{question.id}
            <CCloseButton className="float-end" onClick={onclickDeleteBtn}/>
            </CCardHeader>
            <CCardBody>
            <CRow>
                <CCol className="mb-3" xs={12}>
                <CFormSelect name="answer_type" value={question.get("questionType")} label="Type" onChange={onChangeQuestionType}>
                    <option value="Sub">주관식</option>
                    <option value="NumMul">객관식(중복 허용)</option>
                    <option value="NumOnly">객관식(중복 불가)</option>
                    <option value="YN">찬부식</option>
                    <option value="Grd">서열식</option>
                </CFormSelect>
                </CCol>
                <CCol className="mb-3" xs={12}>
                <CFormInput name ="question_content" type="text" label="Question" value={question.get("content")} onChange={onChangeQuestionContent}/>
                </CCol>
            </CRow>

            {question.get("questionType") === 'Sub' && (
                <CCol>

                </CCol>
            )}

            {question.get("questionType") === 'NumMul' && (
                <CRow>
                <CCol className="mb-3" xs={12}><CFormInput type="text" label="Answer 1"/></CCol>
                <CCol className="mb-3" xs={12}>
                    <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
                </CCol>
                </CRow>
            )}
            {question.get("questionType") === 'NumOnly' && (
                <CRow>
                <CCol className="mb-3" xs={12}><CFormInput type="text" label="Answer 1"/></CCol>
                <CCol className="mb-3" xs={12}>
                    <CButton color="primary" onClick={BtnOnclickHandler_Add}>Add Answer</CButton>
                </CCol>
                </CRow>
            )}
            {question.get("questionType") === 'YN' && (
                <CCol>

                </CCol>
            )}
            {question.get("questionType") === 'Grd' && (
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
            <CCardHeader>질문{question.get("id")}. {question.get("content")}</CCardHeader>
            <CCardBody>
            {question.get("questionType") === 'Sub' && (
                <CFormTextarea></CFormTextarea>
            )}
            {question.get("questionType") === 'NumMul' && (
                <>
                {question.get("optionList").map((option) => (
                    <CFormCheck key={option.get("queOptId")} type="checkbox" label={option.optionName} />
                ))}
                </>
            )}
            {question.get("questionType") === 'NumOnly' && (
                <>
                {question.get("optionList").map((option) => (
                    <CFormCheck key={option.queOptId} type="radio" label={option.optionName} />
                ))}
                </>
            )}
            {question.get("questionType") === 'YN' && (
                <>
                {question.get("optionList").map((option) => (
                    <CFormCheck key={option.queOptId} type="radio" label={option.optionName} />
                ))}
                </>
            )}
            {question.get("questionType") === 'Grd' && (
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