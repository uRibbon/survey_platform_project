import React, { useState } from 'react'
import { CDatePicker } from '@coreui/react-pro'
import { CFormLabel, CButton, CFormCheck, CFormSelect,CFormTextarea,CForm,CContainer, CFormInput,CDropdownDivider, CDropdownItem, CDropdownMenu,CDropdownToggle,CDropdown,CInputGroup,CCard, CCardBody, CCol, CCardHeader, CRow } from '@coreui/react'



const QuestionModal=(props)=>{
const tempStyle={        
    paddingTop:"20px" }

return(
        <CContainer>
            <CRow className="mb-3">
                <CFormLabel htmlFor="staticEmail" className="col-sm-2 col-form-label">Question {props.question_num}</CFormLabel>
                <CCol sm={10}>
                <CFormInput type="text" id="staticEmail" placeholder="Input Your Question"/>
                </CCol>
            </CRow>

            {props.answerType === '1' && (
                <CForm style={tempStyle}>
                    <CFormTextarea
                        id="exampleFormControlTextarea1"
                        label="Answer"
                        rows="3"
                        text="Must be 8-20 words long."
                    ></CFormTextarea>
                </CForm>
            )}
            
            {props.answerType === '2' && (
                <CRow style={tempStyle}>
                <CFormCheck label="Disabled checkbox"/>
                <CFormCheck label="Disabled checked checkbox" />
                <CFormCheck label="Disabled checkbox"/>
                <CFormCheck label="Disabled checked checkbox" />
                </CRow>
            )}
        </CContainer>
)
}

export default QuestionModal;