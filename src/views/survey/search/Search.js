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
  CCardTitle,
  CCardText,
  CRow,
  CCol,
  CForm,
  CCardFooter,
  CListGroup,
  CListGroupItem,
  CPagination,
  CPaginationItem,
  CTable,
  CTableDataCell,
  CTableBody,
  CTableHead,
  CTableRow,
  CTableHeaderCell,
} from '@coreui/react'

const Search = () => {
  const tableRowClick = (e, link) => {
    window.location.href = link
  }
  let carddata = [
    {
      id: 1,
      title: '설문조사 1',
      content: '동아리 신청 설문조사 입니다.',
      category: '학교',
      writer: '예나',
      number: 40,
      date: '2022-09-10 ~ 2022-10-10',
      link: '#',
    },
    {
      id: 2,
      title: '설문조사 2',
      content: 'MT 수요 설문조사 입니다.',
      category: '학교',
      writer: '영주',
      number: 40,
      date: '2022-09-10 ~ 2022-10-10',
      link: '#',
    },
    {
      id: 3,
      title: '설문조사 3',
      content: '선호 기업 설문조사 입니다.',
      category: '기업',
      writer: '솔비',
      number: 40,
      date: '2022-09-10 ~ 2022-10-10',
      link: '#',
    },
    {
      id: 4,
      title: '설문조사 4',
      content: '면접 질문 설문조사 입니다.',
      category: '기업',
      writer: '예나',
      number: 40,
      date: '2022-09-10 ~ 2022-10-10',
      link: '#',
    },
    {
      id: 5,
      title: '설문조사 5',
      content: '연애 설문조사 입니다.',
      category: '연애',
      writer: '유리',
      number: 40,
      date: '2022-09-10 ~ 2022-10-10',
      link: '#',
    },
    {
      id: 6,
      title: '설문조사 6',
      content: '자영업 주문서 설문조사 입니다.',
      category: '자영업',
      writer: '유리',
      number: 40,
      date: '2022-09-10 ~ 2022-10-10',
      link: '#',
    },
    {
      id: 7,
      title: '설문조사 7',
      content: '좋아하는 여행지 설문조사 입니다.',
      category: '취미',
      writer: '영주',
      number: 40,
      date: '2022-09-10 ~ 2022-10-10',
      link: '#',
    },
  ]
  let category = [
    {
      id: 1,
      name: '학교',
    },
    {
      id: 2,
      name: '기업',
    },
    {
      id: 3,
      name: '연애',
    },
    {
      id: 4,
      name: '사업',
    },
    {
      id: 5,
      name: '취미',
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
  // const [currentPage, setCurrentPage] = useState(1)
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
      <CCard className="mb-3">
        <CCardHeader>설문 검색</CCardHeader>
        <CCardBody>
          <CTable className="table-hover">
            <CTableHead>
              <CTableRow>
                <CTableHeaderCell scope="col">#</CTableHeaderCell>
                <CTableHeaderCell scope="col">설문종류</CTableHeaderCell>
                <CTableHeaderCell scope="col">설문명</CTableHeaderCell>
                <CTableHeaderCell scope="col">설문내용</CTableHeaderCell>
                <CTableHeaderCell scope="col">설문생성자</CTableHeaderCell>
                <CTableHeaderCell scope="col">설문참여자</CTableHeaderCell>
                <CTableHeaderCell scope="col">설문일</CTableHeaderCell>
              </CTableRow>
            </CTableHead>
            <CTableBody>
              {carddata.map((data) => (
                <CTableRow key={data.id} onClick={(e) => tableRowClick(e, data.link)}>
                  <CTableHeaderCell scope="row">{data.id}</CTableHeaderCell>
                  <CTableDataCell>{data.category}</CTableDataCell>
                  <CTableDataCell>{data.title}</CTableDataCell>
                  <CTableDataCell>{data.content}</CTableDataCell>
                  <CTableDataCell>{data.writer}</CTableDataCell>
                  <CTableDataCell>{data.number}명</CTableDataCell>
                  <CTableDataCell>{data.date}</CTableDataCell>
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
      {/*  <CSmartPagination*/}
      {/*    align="center"*/}
      {/*    activePage={currentPage}*/}
      {/*    pages={10}*/}
      {/*    onActivePageChange={setCurrentPage}*/}
      {/*  />*/}
    </>
  )
}

export default Search
