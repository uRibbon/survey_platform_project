import React, { useState } from 'react'
import {
  CFormLabel,
  CFormInput,
  CCol,
  CRow,
} from '@coreui/react'
import axios from "axios";
import apiConfig from "../../../../lib/apiConfig";
import usePromise from 'src/lib/usePromise';

const DetailInfo = (props) => {
  // const [surInfo, setSurInfo] = useState([])

  let surInfo = null;
  console.log(props.surId);
  const [loading, response, error] = usePromise(() => {
    return axios.post(apiConfig.surveyDetail,
      {sur_id: props.surId},
      {headers: { 'Content-Type': 'multipart/form-data'}}
    )
  }, []);
  
  console.log(response);
  if(response != null){
    surInfo = response.data.info;
  }

  // axios.post(apiConfig.surveyDetail,
  //   {sur_id: props.surId},
  //   {headers: {
  //       'Content-Type': 'multipart/form-data'
  //     }}
  // ).then((response) => {
  //   setSurInfo(response.data.info)
  // })

  return (
    <div>
        <CRow>
            <CFormLabel htmlFor="surveyName" className="col-sm-2 col-form-label">
            설문명
            </CFormLabel>
            <CCol sm={10}>
            <CFormInput
                type="text"
                id="surveyName"
                value={surInfo? surInfo.title:null}
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
                value={surInfo? surInfo.categoryContent:null}
                readOnly
                plainText
                />
            </CCol>
        </CRow>

        <CRow>
          <CFormLabel htmlFor="description" className="col-sm-2 col-form-label">
            설문설명
          </CFormLabel>
          <CCol sm={10}>
            <CFormInput
              type="text"
              id="description"
              value={surInfo? surInfo.description:null}
              readOnly
              plainText
            />
          </CCol>
        </CRow>

        {/* <CRow>
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
        </CRow> */}

    </div>
  )
}

export default DetailInfo
