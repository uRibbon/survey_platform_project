import React from 'react'
import {
  CFormLabel,
  CFormTextarea,
  CFormInput,
  CCol,
  CRow,
  CCard,
  CCardBody,
  CCardHeader,
  CCloseButton, CButton,
} from '@coreui/react'

const QuestionModal = (props) => {
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
          <CCol className="mb-5" xs={2}><CFormLabel>Question</CFormLabel></CCol>
          <CCol className="mb-5" xs={10}><CFormInput type="text"/></CCol>
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
      </CCardBody>
    </CCard>
  )
}

export default QuestionModal
