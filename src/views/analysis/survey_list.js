import React from 'react'
import { useState } from 'react'
import { CIcon } from '@coreui/icons-react'
import { cilList, cilShieldAlt } from '@coreui/icons'
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
  //CListGroupItem,
  //CListGroup,
  CRow,
  CTable,
  CTableBody,
  CFormFloating,
  CFormTextarea,
  CFormLabel,
  CTableDataCell,
  CTableHead,
  CTableHeaderCell,
  CTableRow,
} from '@coreui/react'

const Tables = () => {
  const [visible, setVisible] = useState(false)
  return (
    <>
      <CCardBody className="text-end">
        <CButton className="mb-3" onClick={() => setVisible(!visible)}>
          Register
        </CButton>
      </CCardBody>
      <CModal backdrop="static" visible={visible} onClose={() => setVisible(false)}>
        <CModalHeader>
          <CModalTitle>Register</CModalTitle>
        </CModalHeader>
        <CModalBody>
          <CFormFloating>
            <CFormTextarea id="floatingTextarea" placeholder="Leave a comment here"></CFormTextarea>
            <CFormLabel htmlFor="floatingTextarea">카테고리명</CFormLabel>
          </CFormFloating>
        </CModalBody>
        <CModalFooter>
          <CButton color="secondary" onClick={() => setVisible(false)}>
            Cancel
          </CButton>
          <CButton color="primary">Register</CButton>
        </CModalFooter>
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
                    <CTableHeaderCell scope="col">#</CTableHeaderCell>
                    <CTableHeaderCell scope="col">카테고리명</CTableHeaderCell>
                    <CTableHeaderCell scope="col">카테고리 등록 날짜</CTableHeaderCell>
                    <CTableHeaderCell scope="col">카테고리 내 설문 개수</CTableHeaderCell>
                    <CTableHeaderCell scope="col">삭제</CTableHeaderCell>
                  </CTableRow>
                </CTableHead>
                <CTableBody>
                  <CTableRow>
                    <CTableHeaderCell scope="row">1</CTableHeaderCell>
                    <CTableDataCell>학교</CTableDataCell>
                    <CTableDataCell>2022/10/3</CTableDataCell>
                    <CTableDataCell>40</CTableDataCell>
                    <CFormCheck id="checkboxNoLabel" value="" aria-label="..."/>
                  </CTableRow>
                  <CTableRow>
                    <CTableHeaderCell scope="row">2</CTableHeaderCell>
                    <CTableDataCell>취미</CTableDataCell>
                    <CTableDataCell>2022/10/9</CTableDataCell>
                    <CTableDataCell>50</CTableDataCell>
                    <CFormCheck id="checkboxNoLabel" value="" aria-label="..."/>
                  </CTableRow>
                  <CTableRow>
                    <CTableHeaderCell scope="row">3</CTableHeaderCell>
                    <CTableDataCell>연애</CTableDataCell>
                    <CTableDataCell>2022/10/10</CTableDataCell>
                    <CTableDataCell>500</CTableDataCell>
                    <CFormCheck id="checkboxNoLabel" value="" aria-label="..."/>
                  </CTableRow>
                </CTableBody>
              </CTable>
            </CCardBody>
          </CCard>
          <CCardBody className='text-end'>
          <CButton color="danger">Delete</CButton>
          </CCardBody>
        </CCol>
      </CRow>
      </>
  )
}

export default Tables