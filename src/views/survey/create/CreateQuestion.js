import React, { useState } from 'react';
import Question from './Question';

// 질문 리스트
const CreateQuestion = ({questions}) => {
  
  const tempStyle = {
    // height : "300px",
    // overflow : "overflow"
  }


  return (
    <div className='question_list' style={tempStyle}>
    {questions.map((question)=> (
      <Question question={question} key={question.id}/>
    )
    )}
    </div>
  )
}

export default CreateQuestion