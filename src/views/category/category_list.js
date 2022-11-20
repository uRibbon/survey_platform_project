import React, {useEffect} from 'react'
import { useState } from 'react'
import {
  CButton,
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CModal,
  CModalBody,
  CModalFooter,
  CModalHeader,
  CFormCheck,
  CModalTitle,
  CRow,
  CTable,
  CTableBody,
  CForm,
  CFormInput,
  CTableDataCell,
  CTableHead,
  CTableHeaderCell,
  CTableRow, CPaginationItem, CPagination,
} from '@coreui/react'
import apiConfig from "../../lib/apiConfig";
import usePromise from "../../lib/usePromise";
import axios from "axios";
import data from "@coreui/coreui/js/src/dom/data";

const Tables = () => {
  const current = decodeURI(window.location.href);
  const search = current.split("?")[1];
  const params = new URLSearchParams(search);
  const nowPage = params.get('page') ? params.get('page') : 1;

  const [visible, setVisible] = useState(false)
  const [pageData, setPageData] = useState({
    totalPage: 0,
    page: 1,
    size: 0,
    start: 0,
    end: 0,
    prev: false,
    next: false,
    pageList: []
  })
  const [categoryList, setCategoryList] = useState([])
  // let promise = usePromise(apiConfig.categoryList + "?page=1&size=3", []);
  // let promise = usePromise("/survey-service/v1/survey/category/list?page=1&size=3", []);
  // console.log(promise)

  axios.get("/survey-service/v1/survey/category/list?page=" + nowPage)
    .then((response) => {
      console.log(response.data)
      setPageData(pageData => ({...pageData, ...response.data, page: nowPage}))
      setCategoryList(response.data.dtoList)
    })

  const [checkedInputs, setCheckedInputs] = useState([]);

  const changeHandler = (checked, id) => {
    if (checked) {
      setCheckedInputs([...checkedInputs, id]);
    } else {
      // 체크 해제
      setCheckedInputs(checkedInputs.filter((el) => el !== id));
    }
  };

  const deleteCategory = () => {
    axios.post("/survey-service/v1/survey/category/del", JSON.stringify(checkedInputs),
      {
        headers: { "Content-Type": "application/json" }
      }).then((response) => {
        window.location.reload();
    })
  }



  return (
    console.log(checkedInputs),
    // console.log(pageData),
    // console.log(categoryList),
    <>
      <CCardBody className="text-end">
        <CButton className="mb-3" onClick={() => setVisible(!visible)}>
          Register
        </CButton>
      </CCardBody>
      <CModal backdrop="static" visible={visible} onClose={() => setVisible(false)}>
        <CForm method="post" action="/survey-service/v1/survey/category/reg">
        <CModalHeader>
          <CModalTitle>설문 카테고리 등록하기</CModalTitle>
        </CModalHeader>
        <CModalBody>
            <CFormInput label="카테고리명" name="content"></CFormInput>
        </CModalBody>
        <CModalFooter>
          <CButton color="secondary" onClick={() => setVisible(false)}>
            Cancel
          </CButton>
          <CButton color="primary" type="submit">Register</CButton>
        </CModalFooter>
        </CForm>
      </CModal>
      <CRow>
        <CCol xs={12}>
          <code></code>
          <CCard className="mb-4">
            <CCardHeader>
              <strong>설문 카테고리 리스트</strong>
            </CCardHeader>
            <CCardBody>
              <CTable>
                <CTableHead>
                  <CTableRow>
                    <CTableHeaderCell scope="col">삭제</CTableHeaderCell>
                    <CTableHeaderCell scope="col">#</CTableHeaderCell>
                    <CTableHeaderCell scope="col">카테고리명</CTableHeaderCell>
                    <CTableHeaderCell scope="col">카테고리 등록 날짜</CTableHeaderCell>
                  </CTableRow>
                </CTableHead>
                <CTableBody>
                  {categoryList.map((category) => (
                    <CTableRow key={category}>
                      <CTableDataCell>
                        <CFormCheck
                          id={category.surCatId}
                          onChange={(e)=>{changeHandler(e.currentTarget.checked, category.surCatId)}}
                                    checked={checkedInputs.includes(category.surCatId) ? true : false}/>
                      </CTableDataCell>
                      <CTableHeaderCell scope="row">{category.surCatId}</CTableHeaderCell>
                      <CTableDataCell>{category.content}</CTableDataCell>
                      <CTableDataCell>{category.regDt}</CTableDataCell>
                    </CTableRow>
                  ))}
                </CTableBody>
              </CTable>
              <CButton color="danger" onClick={deleteCategory}>Delete</CButton>
            </CCardBody>
          </CCard>

          <CPagination aria-label="Page navigation example" align="center">
            {pageData.prev ? (
              <CPaginationItem aria-label="Previous">
            <span aria-hidden="true">
              <a href={"/#/category/category_list?page=" + String(parseInt(pageData.start) - 1)}>&laquo;</a>
            </span>
              </CPaginationItem>
            ) : (
              <CPaginationItem aria-label="Previous" disabled>
                <span aria-hidden="true">&laquo;</span>
              </CPaginationItem>
            )}
            {pageData.pageList.map((idx) =>
              idx === parseInt(pageData.page) ? (
                <CPaginationItem active>{pageData.page}</CPaginationItem>
              ) : (
                <CPaginationItem>
                  <a href={"/#/category/category_list?page=" + idx}>{idx}</a>
                </CPaginationItem>
              ),
            )}
            {pageData.next ? (
              <CPaginationItem aria-label="Next">
            <span aria-hidden="true">
              <a href={"/#/category/category_list?page=" + String(parseInt(pageData.end) + 1)}>&raquo;</a>
            </span>
              </CPaginationItem>
            ) : (
              <CPaginationItem aria-label="Next" disabled>
                <span aria-hidden="true">&raquo;</span>
              </CPaginationItem>
            )}
          </CPagination>




        </CCol>
      </CRow>
    </>
  )
}

export default Tables
