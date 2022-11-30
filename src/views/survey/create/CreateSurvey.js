import React, { useState, useRef, useCallback } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import * as questionActions from "../../../modules/questions";
import {
  CButton,
  CCard,
  CCardHeader,
  CCardBody,
} from '@coreui/react'
import CreateSurveyInfo from './CreateSurveyInfo';
import CreateQuestion from './CreateQuestion';


const CreateSurvey = () => {
  const dispatch = useDispatch();
  const { questions } = useSelector(({ questions }) => ({
    questions : questions
  }));

  const nextId = useRef(3); 

  // 질문 추가
  const onInsert = (e) =>{
    dispatch(questionActions.addQuestion(nextId.current));
    nextId.current += 1;
  };

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
          <CreateQuestion />
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