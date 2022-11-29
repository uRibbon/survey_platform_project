import React, { useState, useRef, useCallback } from 'react';
import {
  CButton,
  CCard,
  CCardHeader,
  CCardBody,
} from '@coreui/react'
import CreateSurveyInfo from './CreateSurveyInfo';
import CreateQuestion from './CreateQuestion';


const CreateSurvey = () => {
  const [questions, setQuestions] = useState([
    {
      id : 1,
      questionType : "NumOnly",
      content : "테스트",
      optionList : [{
        queOptId : 1,
        optionName : "test"
      }, {
        queOptId : 2,
        optionName : "test"
      }
    ]
    }
  ])

  const nextId = useRef(2); 

  const onInsert = useCallback( e =>{
    console.log(e);
    const question = {
      id : nextId.current,
      questionType : "Sub",
      content : "테스트",
      optionList : {
        queOptId : 1,
        optionName : "test"
      }
    }
    setQuestions (questions.concat(question));
    console.log(questions);
    nextId.current+= 1;
  }, [questions]);

  const tempStyle = {
    paddingTop: '20px',
  }

  return (
    <>
     <CCard className="mb-3">
        <CCardHeader>설문 생성<small> 설문을 생성 할 수 있습니다.</small>
        </CCardHeader>
        <CCardBody>
          <CreateSurveyInfo />
          <CreateQuestion questions={questions} />
          <div className="d-grid gap-2 col-3 mx-auto" style={tempStyle}>
            <CButton color="primary" onClick={onInsert}>
              Add
            </CButton>
          </div>
        </CCardBody>
      </CCard>
        <br/>
        <br/>
    
    </>
  )
}

export default CreateSurvey