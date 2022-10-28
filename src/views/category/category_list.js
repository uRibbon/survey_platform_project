import React from 'react'
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
                    <CTableHeaderCell scope="col">삭제</CTableHeaderCell>
                    <CTableHeaderCell scope="col">#</CTableHeaderCell>
                    <CTableHeaderCell scope="col">카테고리명</CTableHeaderCell>
                    <CTableHeaderCell scope="col">카테고리 등록 날짜</CTableHeaderCell>
                  </CTableRow>
                </CTableHead>
                <CTableBody>
                  <CTableRow>
                    <CTableDataCell>
                      <CFormCheck id="checkboxNoLabel" value="" aria-label="..." />
                    </CTableDataCell>
                    <CTableHeaderCell scope="row">1</CTableHeaderCell>
                    <CTableDataCell>학교</CTableDataCell>
                    <CTableDataCell>2022/10/3</CTableDataCell>
                  </CTableRow>
                  <CTableRow>
                    <CTableDataCell>
                      <CFormCheck id="checkboxNoLabel" value="" aria-label="..." />
                    </CTableDataCell>
                    <CTableHeaderCell scope="row">2</CTableHeaderCell>
                    <CTableDataCell>취미</CTableDataCell>
                    <CTableDataCell>2022/10/9</CTableDataCell>
                  </CTableRow>
                  <CTableRow>
                    <CTableDataCell>
                      <CFormCheck id="checkboxNoLabel" value="" aria-label="..." />
                    </CTableDataCell>
                    <CTableHeaderCell scope="row">3</CTableHeaderCell>
                    <CTableDataCell>연애</CTableDataCell>
                    <CTableDataCell>2022/10/10</CTableDataCell>
                  </CTableRow>
                </CTableBody>
              </CTable>
            </CCardBody>
          </CCard>
          <CCardBody>
            <CButton color="danger">Delete</CButton>
          </CCardBody>
        </CCol>
      </CRow>
    </>
  )
}

export default Tables
