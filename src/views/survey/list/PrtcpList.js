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
  CCardTitle,
  CCardText,
  CRow,
  CCol,
  CForm,
  CCardFooter,
  CCardHeader,
  CBadge,
  CPagination,
  CPaginationItem,
  CCardGroup,
  CCardSubtitle,
  CListGroup,
  CListGroupItem,
} from '@coreui/react'

const PrtcpList = () => {
  let carddata = [
    {
      id: 1,
      title: '설문조사1',
      content: '동아리 설문조사 입니다.',
      category: '학업',
      writer: '예나',
      number: 40,
      date: '2022-09-10',
    },
    {
      id: 2,
      title: '설문조사2',
      content: '동아리 설문조사 입니다.',
      category: '학업',
      writer: '예나',
      number: 30,
      date: '2022-09-10',
    },
    {
      id: 3,
      title: '설문조사3',
      content: '동아리 설문조사 입니다.',
      category: '학업',
      writer: '예나',
      number: 50,
      date: '2022-09-10',
    },
  ]
  let category = [
    {
      id: 1,
      name: '만족도 조사',
    },
    {
      id: 2,
      name: '보건의료',
    },
    {
      id: 3,
      name: '시장조사',
    },
    {
      id: 4,
      name: '회의 및 행사',
    },
    {
      id: 5,
      name: '비영리 단체',
    },
    {
      id: 6,
      name: '학업',
    },
  ]
  let page = {
    prev: false,
    start: 1,
    page: 3,
    next: false,
    end: 1,
    pagelist: [1, 2, 3, 4, 5, 6],
  }
  return (
    <>
      <CForm action={'/search'} method={'post'}>
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
      <CRow>
        {/*{carddata.map((data) => (*/}
          <CCol xs={3}>
            <CCard className="mb-4">
              <CCardHeader>학업</CCardHeader>
              <CCardBody>
                <CCardTitle>수정 가능한 설문조사</CCardTitle>
                <CCardText><small>2022-09-28 ~ 2023-11-28</small>&nbsp;<CBadge color="success">배포중</CBadge></CCardText>
              </CCardBody>
              <CCardFooter>
                <CButton color="primary" variant="outline" className="m-1" size="sm">Edit</CButton>
                <CButton color="success" variant="outline" className="m-1" size="sm">Remove</CButton>
              </CCardFooter>
            </CCard>
          </CCol>
          <CCol xs={3}>
            <CCard className="mb-4">
              <CCardHeader>건강</CCardHeader>
              <CCardBody>
                <CCardTitle>수정 불가능한 설문조사</CCardTitle>
                <CCardText><small>2022-09-28 ~ 2023-11-28</small>&nbsp;<CBadge color="success">배포중</CBadge></CCardText>
              </CCardBody>
              <CCardFooter>
                <CButton color="success" variant="outline" className="m-1" size="sm">Remove</CButton>
              </CCardFooter>
            </CCard>
          </CCol>
          <CCol xs={3}>
            <CCard className="mb-4">
              <CCardHeader>학업</CCardHeader>
              <CCardBody>
                <CCardTitle>완료된 설문조사</CCardTitle>
                <CCardText><small>2022-01-12 ~ 2022-02-12</small>&nbsp;<CBadge color="secondary">완료</CBadge></CCardText>
              </CCardBody>
              <CCardFooter>
                <CButton color="success" variant="outline" className="m-1" size="sm">Remove</CButton>
                <CButton color="danger" variant="outline" className="m-1" size="sm">Details</CButton>
              </CCardFooter>
            </CCard>
          </CCol>
        {/*))}*/}
      </CRow>
      <CPagination aria-label="Page navigation example" align="center">
        {page.prev ? (
          <CPaginationItem aria-label="Previous">
            <span aria-hidden="true">
              <a href={'/search?category=' + page.category + '&page=' + page.start - 1}>&laquo;</a>
            </span>
          </CPaginationItem>
        ) : (
          <CPaginationItem aria-label="Previous" disabled>
            <span aria-hidden="true">&laquo;</span>
          </CPaginationItem>
        )}
        {page.pagelist.map((idx) =>
          idx === page.page ? (
            <CPaginationItem active>{page.page}</CPaginationItem>
          ) : (
            <CPaginationItem>
              <a href={'/search?category=' + page.category + '&page=' + idx}>{idx}</a>
            </CPaginationItem>
          ),
        )}
        {page.next ? (
          <CPaginationItem aria-label="Next">
            <span aria-hidden="true">
              <a href={'/search?category=' + page.category + '&page=' + page.end + 1}>&raquo;</a>
            </span>
          </CPaginationItem>
        ) : (
          <CPaginationItem aria-label="Next" disabled>
            <span aria-hidden="true">&raquo;</span>
          </CPaginationItem>
        )}
      </CPagination>
    </>
  )
}

export default PrtcpList
