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
  CFormTextarea,
} from '@coreui/react'

const DetailInfo = () => {
  return (
    <div className='mb-3'>
        <CCol lg={12} className="text-start d-flex mb-1">
            <CButton color="success" href="#" className="ms-auto" variant="outline">
                exel download
            </CButton>
          </CCol>
        <CAccordion alwaysOpen>
            <CAccordionItem itemKey={1}>
                <CAccordionHeader>1. 이름을 입력해주세요. </CAccordionHeader>
                <CAccordionBody>
                <CFormInput
                    type="text"
                    placeholder="이름을 입력해주세요."
                    value= "고솔비"
                    readOnly
                />
               
                </CAccordionBody>
            </CAccordionItem>
            <CAccordionItem itemKey={2}>
                <CAccordionHeader>2. 성별을 입력해주세요. </CAccordionHeader>
                <CAccordionBody>
                <CFormCheck
                type="radio"
                name="gender"
                id="gender_M"
                label="남성"
                disabled
                 />
                <CFormCheck
                type="radio"
                name="gender"
                id="gender_W"
                label="여성"
                checked
                disabled
                />
                </CAccordionBody>
            </CAccordionItem>
            <CAccordionItem itemKey={3}>
                <CAccordionHeader>3. 기타 하고싶은 말씀을 남겨주세요. </CAccordionHeader>
                <CAccordionBody>
                <CFormTextarea id="exampleFormControlTextarea1" rows="3">안녕하세요~~~~~~</CFormTextarea>
                </CAccordionBody>
            </CAccordionItem>
        </CAccordion>
    </div>
  )
}

export default DetailInfo
