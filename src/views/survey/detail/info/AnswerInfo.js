import React, { useState } from 'react'
import {
  CCol,
  CButton,
  CFormInput,
  CAccordion,
  CAccordionBody,
  CAccordionHeader,
  CAccordionItem,
  CFormCheck,
  CFormTextarea, CFormRange,
} from '@coreui/react'
import axios from "axios";
import apiConfig from "../../../../lib/apiConfig";
import {useSelector} from "react-redux";
import usePromise from "../../../../lib/usePromise";

const DetailInfo = (props) => {
  const { user } = useSelector(({user})=> ({user:user.user}));
  const userId = user.info.userId;

  let answerList = []

  const [loading, response, error] = usePromise(() => {
    return axios.post(apiConfig.answerList,
      {regId: userId, surId: props.surId},
      {headers: { 'Content-Type': 'multipart/form-data'}}
    )
  }, []);

  if(response != null){
    answerList = response.data
  }

  return (
    <div className="mt-3">
        <CAccordion alwaysOpen>
          {answerList.map((answer, index) => (
              <CAccordionItem itemKey={index+1} key={answer.queId}>
                <CAccordionHeader>{index+1}. {answer.queContent} </CAccordionHeader>
                <CAccordionBody>
                  {answer.queType === "YN" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck
                          type="radio"
                          name={answer.ansId}
                          key={option.queOptId}
                          label={option.optionName}
                          checked={answer.ansContent === option.optionName?true:false}
                          readOnly
                        />
                      ))}
                    </>
                  )}

                  {answer.queType === "NumOnly" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck
                          type="radio"
                          name={answer.ansId}
                          key={option.queOptId}
                          label={option.optionName}
                          checked={answer.ansContent === option.optionName?true:false}
                          readOnly
                        />
                      ))}
                    </>
                  )}

                  {answer.queType === "NumMul" && (
                    <>
                      {answer.optionList.map((option) => (
                        <CFormCheck
                          type="checkbox"
                          name={answer.ansId}
                          key={option.queOptId}
                          label={option.optionName}
                          checked={answer.ansContent === option.optionName?true:false}
                          readOnly
                        />
                      ))}
                    </>
                  )}

                  {answer.queType === "Sub" && (
                    <CFormTextarea
                      name={answer.ansId}
                      value={answer.ansContent}
                      readOnly
                    ></CFormTextarea>
                  )}

                  {answer.queType == "Grd" && (
                    <CFormRange
                      name={answer.ansId}
                      min="0" max="100" step="10"
                      value={answer.ansContent}
                      readOnly
                    />
                  )}
                </CAccordionBody>
              </CAccordionItem>
          ))}
        </CAccordion>
    </div>
  )
}

export default DetailInfo
