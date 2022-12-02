import React from 'react';
import {
    CFormSelect,
    CFormInput,
    CCol,
    CCard,
    CCardBody,
    CForm,
    CFormSwitch,
    CTooltip
  } from '@coreui/react'

const CreateSurveyInfo = ({showSendTab}) => {

    function changeSwitch(e){
        const checked = e.target.checked;
       showSendTab(checked);
    };


    return (
        <>
        <CCard className="mb-3">
        <CCardBody>
        <CForm className="row g-3">
            <CCol xs={6}>
                <CFormInput label="설문 이름" placeholder="설문 이름을 입력하세요" name="name"/>
            </CCol>
            <CCol xs={6}>
                <CFormSelect label="설문 분류 선택" name="catefory_id">
                    <option value={1}>학교</option>
                    <option value={2}>기업</option>
                    <option value={3}>연애</option>
                    <option value={4}>사업</option>
                    <option value={5}>취미</option>
                </CFormSelect>
            </CCol>
            <CCol xs={12}>
            <div className="row g-3">
                <CCol xs={3}>
                  <CFormInput label="설문 시작일" type="date"/>
                </CCol>
                <CCol xs={3}>
                  <CFormInput label="설문 시작 시간" type="time"/>
                </CCol>
                <CCol xs={3}>
                  <CFormInput label="설문 마감일" type="date"/>
                </CCol>
                <CCol xs={3}>
                  <CFormInput label="설문 마감 시간" type="time"/>
                </CCol>
              </div>
            </CCol>
            <CCol xs={3}>
                <CFormSelect label="설문 공개 선택" name="private_yn">
                    <option value="N">전체 공개</option>
                    {/* <option value="2">그룹 공개</option> */}
                    <option value="Y">대상자 설정</option>
                </CFormSelect>
            </CCol>
            <CCol xs={3}>
                <CFormSelect label="피설문자 로그인 여부" name="login_yn">
                    <option value="Y">로그인 필수</option>
                    <option value="N">로그인 필요 없음</option>
                </CFormSelect>
            </CCol>
            <CCol xs={3}>
                <CFormSelect label="피설문자 답변 수정 여부" name="modify_yn">
                    <option value="Y">수정 가능</option>
                    <option value="N">수정 불가능</option>
                </CFormSelect>
            </CCol>
            <CCol xs={3}>
                <CFormSelect label="피설문자 익명 여부" name="annoy_yn">
                    <option value="Y">익명 가능</option>
                    <option value="N">익명 불가능</option>
                </CFormSelect>
            </CCol>
            <CCol xs={12}>
                <CFormInput label="설문 상세" placeholder="설문 설명을 입력하세요" name="descripton"/>
            </CCol>
            <CCol xs={12}>
            <CTooltip
                content="설문조사 등록 동시에 발송됩니다. 발송 탭을 확인해 주세요."
                placement="bottom"
                >
                <CFormSwitch label="바로 배포" id="formSwitchCheckChecked" onChange={changeSwitch}/>
            </CTooltip>            
            </CCol>

            

        </CForm>
        </CCardBody>
        </CCard>
    </>
    )

}

export default CreateSurveyInfo;