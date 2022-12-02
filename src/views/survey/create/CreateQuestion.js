import React, { useState, useRef } from 'react';
import Question from './Question';
import { useSelector, useDispatch } from 'react-redux';
import * as questionActions from "../../../modules/questions";
import {CButton, CCard, CCardBody,} from '@coreui/react'

// 질문 리스트
const CreateQuestion = () => {
  const dispatch = useDispatch();

  const { questions } = useSelector(({ questions }) => ({
    questions : questions
  }));

  // 질문 내용 수정
  function changeContent({id, value, name}) {
    dispatch(questionActions.editQuestionContent({id, value, name}));
  }

  // 질문 유형 수정
  function editQuestionType({id, value, name}) {
    dispatch(questionActions.editQuestionType({id, value, name}));
  }

  // 질문 삭제
  function deleteQuestion({id}) {
    dispatch(questionActions.deleteQuestion({id}));
  }

  const nextId = useRef(3); 

  // 질문 추가
  const onInsert = (e) =>{
    dispatch(questionActions.addQuestion(nextId.current));
    nextId.current += 1;
  };

  const tempStyle = {
    paddingTop: '20px',
  }

  // console.log(questions);

    
  const questionList = questions.map(question => 
    (
      
      <Question 
        question={question} 
        key={question.get("id")}
        changeContent = {changeContent}
        deleteQuestion = {deleteQuestion}
        editQuestionType = {editQuestionType}
        >
      </Question>
    )
  );

  return (
    <>
    <CCard className="mb-3">
      <CCardBody>
        {questionList}
      </CCardBody>
      <div className="d-grid gap-2 col-3 mx-auto" style={tempStyle}>
        <CButton color="primary" onClick={onInsert}>
          Add
        </CButton>
      </div>
      <br/>
      <br/>

    </CCard>
    </>
  )
}

export default CreateQuestion

