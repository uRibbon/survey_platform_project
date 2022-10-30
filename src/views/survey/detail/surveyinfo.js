import React, { useState } from 'react'
import {
  CFormLabel,
  CForm,
  CFormTextarea,
  CButton,
  CFormInput,
  CCol,
  CRow,
  CAccordion,
  CAccordionBody,
  CAccordionHeader,
  CAccordionItem,
} from '@coreui/react'

const DetailInfo = () => {
  return (
    <div>
        <CRow>
            <CFormLabel htmlFor="surveyName" className="col-sm-2 col-form-label">
            설문조사명
            </CFormLabel>
            <CCol sm={10}>
            <CFormInput
                type="text"
                id="surveyName"
                defaultValue="팀 클라우드 설문조사 입니다!"
                readOnly
                plainText
                />
            </CCol>
        </CRow>
        <CRow>
            <CFormLabel htmlFor="category" className="col-sm-2 col-form-label">
            카테고리
            </CFormLabel>
            <CCol sm={10}>
            <CFormInput
                type="text"
                id="category"
                defaultValue="학교"
                readOnly
                plainText
                />
            </CCol>
        </CRow>

        <CRow>
            <CFormLabel htmlFor="publicYn" className="col-sm-2 col-form-label">
            공개여부
            </CFormLabel>
            <CCol sm={10}>
            <CFormInput
                type="text"
                id="publicYn"
                defaultValue="클라우드 전용 그룹(그룹)"
                readOnly
                plainText
                />
            </CCol>
        </CRow>

    </div>
  )
}

export default DetailInfo
