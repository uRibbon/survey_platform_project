import React, { useState } from 'react'
import {
  CInputGroup,
  CDropdownToggle,
  CDropdownMenu,
  CDropdownItem,
  CDropdown,
  CFormInput,
  CButton,
  CCard,
  CCardBody,
  CCardHeader,
  CForm,
  CPagination,
  CPaginationItem,
  CTable,
  CTableDataCell,
  CTableBody,
  CTableHead,
  CTableRow,
  CTableHeaderCell,
  CRow,
  CCol,
} from '@coreui/react'
import axios from "axios";
import apiConfig from 'src/lib/apiConfig';
import moment from 'moment';
import usePromise from 'src/lib/usePromise';

const VulgarismSearchList = () => {
  const current = decodeURI(window.location.href);
  const search = current.split("?")[1];
  const params = new URLSearchParams(search);
  const nowPage = params.get('page') ? params.get('page') : 1;

  let page = {
    prev: false,
    start: 1,
    page: 3,
    next: false,
    end: 1,
    pagelist: [1, 2, 3, 4, 5, 6],
  }
  let category = [
    {id: 1, name: '학교' },
    {id: 2, name: '기업',},
    {id: 3,name: '연애',},
    {id: 4,name: '사업',},
    {id: 5, name: '취미',},
  ]

  let vulgarismList = []

  // 비속어 검색 리스트
  const [loading, response, error] = usePromise(() => {
    return axios.get(apiConfig.vulgarismData);
  }, []);


  if(response != null){
    vulgarismList = response.data;
    console.log("surveyList : ",vulgarismList);
  }
  


  // 비속어 상세 페이지 링크
  const tableRowClick = (e, id) => {
    // window.location.href = "/#/survey/detail/"+id;
  }

      
  return (
    <>
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <strong> 비속어 검색 </strong>
          </CCardHeader>
          <CCardBody>
            <CCard className="mb-2">
              <CCardBody>
                <CForm action={'/#/survey/search'} method={'post'}>
                  <CInputGroup className="mb-4">
                    <CDropdown variant="input-group">
                      <CDropdownToggle color="secondary" variant="outline">
                        분류 선택
                      </CDropdownToggle>
                      <CDropdownMenu>
                        {category.map((data) => (
                          <CDropdownItem href={'/search?category=' + data.id} key={data.id}>
                            {data.name}
                          </CDropdownItem>
                        ))}
                      </CDropdownMenu>
                    </CDropdown>
                    <CFormInput aria-label="Text input with 2 dropdown buttons" />
                    <CButton type="submit">검색</CButton>
                  </CInputGroup>
                </CForm>
                <CCard className="mb-3">
                  <CCardHeader>검색 목록</CCardHeader>
                  <CCardBody>
                    <CTable className="table-hover">
                      <CTableHead>
                        <CTableRow>
                          <CTableHeaderCell scope="col">설문 ID</CTableHeaderCell>
                          <CTableHeaderCell scope="col">기본정보 비속어</CTableHeaderCell>
                          <CTableHeaderCell scope="col">질문정보 비속어</CTableHeaderCell>
                        </CTableRow>
                      </CTableHead>
                      <CTableBody>



                        {vulgarismList.map((data) => (
                          <CTableRow key={data.surId} onClick={(e) => tableRowClick(e, data.sur_id)}>
                            <CTableHeaderCell scope="row">{data.surId}</CTableHeaderCell>
                            {/* <CTableDataCell>{data.surId}</CTableDataCell> */}
                            <CTableDataCell style={{ color: data.infoYn ? "red" : "blue"}}>{String(data.infoYn).toUpperCase()}</CTableDataCell>
                            <CTableDataCell style={{ color: data.questionYn ? "red" : "blue"}}>{String(data.questionYn).toUpperCase()}</CTableDataCell>
                          </CTableRow>
                        ))}


                      </CTableBody>
                    </CTable>
                  </CCardBody>
                </CCard>
                <CPagination aria-label="Page navigation example" align="center">
                  {page.prev ? (
                    <CPaginationItem aria-label="Previous">
                      <span aria-hidden="true">
                        <a href={'/#/survey/search?page=' + page.start - 1}>&laquo;</a>
                      </span>
                    </CPaginationItem>
                  ) : (
                    <CPaginationItem aria-label="Previous" disabled>
                      <span aria-hidden="true">&laquo;</span>
                    </CPaginationItem>
                  )}
                  
                  {page.pagelist.map((idx) =>
                    idx === page.page ? (
                      <CPaginationItem active key={idx}>{page.page}</CPaginationItem>
                    ) : (
                      <CPaginationItem key={idx}>
                        <a href={'/#/survey/search?&page=' + idx}>{idx}</a>
                      </CPaginationItem>
                    ),
                  )}
                  {page.next ? (
                    <CPaginationItem aria-label="Next">
                      <span aria-hidden="true">
                        <a href={'/#/survey/search?page=' + page.end + 1}>&raquo;</a>
                      </span>
                    </CPaginationItem>
                  ) : (
                    <CPaginationItem aria-label="Next" disabled>
                      <span aria-hidden="true">&raquo;</span>
                    </CPaginationItem>
                  )}
                </CPagination>
              </CCardBody>
              </CCard>
            </CCardBody>
          </CCard>
        </CCol>
      </CRow>
    </>
  )
}

export default VulgarismSearchList
