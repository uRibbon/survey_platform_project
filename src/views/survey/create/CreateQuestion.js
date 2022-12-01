import React, { useState } from 'react';
import Question from './Question';
import { useSelector, useDispatch } from 'react-redux';
import * as questionActions from "../../../modules/questions";

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

  // 질문 삭제
  function deleteQuestion({id}) {
    dispatch(questionActions.deleteQuestion({id}));
  }

  console.log(questions);
  const questionList = questions.map(question => 
    (
      <Question 
        question={question} 
        key={question.get("id")}
        changeContent = {changeContent}
        deleteQuestion = {deleteQuestion}
        >
      </Question>
    )
  );

  return (
    <>
    {questionList}
   </>
  )
}

export default CreateQuestion

