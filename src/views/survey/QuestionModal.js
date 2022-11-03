import React, { useState } from 'react'
import {
  CFormLabel,
  CFormCheck,
  CFormTextarea,
  CForm,
  CContainer,
  CFormInput,
  CCol,
  CRow,
  CCardHeader,
  CCloseButton,
  CCardBody,
  CButton,
  CCard,
  CFormRange,
} from '@coreui/react'

const QuestionModal = (props) => {
  const tempStyle = {
    paddingTop: '20px',
  }
  return (
    <CCard className="mb-3">
      <CCardHeader>
        <CRow>
          <CCol xs={11}>질문1</CCol>
          <CCol xs={1}><CCloseButton/></CCol>
        </CRow>
      </CCardHeader>
      <CCardBody>
        <CRow>
          <CCol className="mb-3" xs={2}><CFormLabel>Question</CFormLabel></CCol>
          <CCol className="mb-3" xs={10}><CFormInput type="text"/></CCol>
        </CRow>
        {props.answerType === '1' && (
          <CRow>
            <CCol className="mb-3" xs={2}><CFormLabel>Answer</CFormLabel></CCol>
            <CCol className="mb-3" xs={10}><CFormTextarea rows="3"/></CCol>
          </CRow>
        )}
        {props.answerType === '2' && (
          <CRow>
            <CCol className="mb-3" xs={2}><CFormLabel>Answer 1</CFormLabel></CCol>
            <CCol className="mb-3" xs={10}><CFormInput type="text"/></CCol>
            <CCol className="mb-3" xs={2}><CFormLabel>Answer 2</CFormLabel></CCol>
            <CCol className="mb-3" xs={10}><CFormInput type="text"/></CCol>
            <div className="d-grid gap-3 col-6 mx-auto">
              <CButton color="primary">Add Answer</CButton>
              <CButton color="primary">Delete Answer</CButton>
            </div>
          </CRow>
        )}
        {props.answerType === '3' && (
          <CCol>
            <CFormCheck type="radio" name="flexRadioDefault" id="flexRadioDefault1" label="예"/>
            <CFormCheck type="radio" name="flexRadioDefault" id="flexRadioDefault2" label="아니오" defaultChecked/>
          </CCol>
        )}
        {props.answerType === '4' && (
          <CRow>
            <CCol className="mb-3" xs={2}>
              <CFormLabel>Step</CFormLabel>
            </CCol>
            <CCol className="mb-3" xs={2}>
              <CFormInput type="number" min="1" max="50"></CFormInput>
            </CCol>
            <CCol className="mt-3 mb-3" xs={12}>
              <CFormRange min="0" max="100" step="10" defaultValue="50"/>
            </CCol>
          </CRow>
        )}
      </CCardBody>
    </CCard>
  )
}

export default QuestionModal
