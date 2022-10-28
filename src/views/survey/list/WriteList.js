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
  CListGroup,
  CListGroupItem,
} from '@coreui/react'
import { CSmartPagination } from '@coreui/react-pro'
import CIcon from '@coreui/icons-react'
import { cilSettings } from '@coreui/icons'

const Search = () => {
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
  // let page = {
  //   prev: false,
  //   start: 1,
  //   page: 3,
  //   next: false,
  //   end: 1,
  //   pagelist: [1, 2, 3, 4, 5, 6],
  // }
  const [currentPage, setCurrentPage] = useState(1)
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
        {carddata.map((data) => (
          <CCol xs={3} key={data.id}>
            <CCard className="mb-4">
              <CCardBody>
                <CCardTitle>{data.title}</CCardTitle>
                <CCardText>{data.content}</CCardText>
              </CCardBody>
              <CListGroup flush>
                <CListGroupItem>카테고리: {data.category}</CListGroupItem>
                <CListGroupItem>작성자: {data.writer}</CListGroupItem>
                <CListGroupItem>참여인원: {data.number}명</CListGroupItem>
              </CListGroup>
              <CCardFooter>
                <small className="text-medium-emphasis">생성일: {data.date}</small>
              </CCardFooter>
            </CCard>
          </CCol>
        ))}
      </CRow>
      {/*<CPagination aria-label="Page navigation example" align="center">*/}
      {/*  {page.prev ? (*/}
      {/*    <CPaginationItem aria-label="Previous">*/}
      {/*      <span aria-hidden="true">*/}
      {/*        <a href={'/search?category=' + page.category + '&page=' + page.start - 1}>&laquo;</a>*/}
      {/*      </span>*/}
      {/*    </CPaginationItem>*/}
      {/*  ) : (*/}
      {/*    <CPaginationItem aria-label="Previous" disabled>*/}
      {/*      <span aria-hidden="true">&laquo;</span>*/}
      {/*    </CPaginationItem>*/}
      {/*  )}*/}
      {/*  {page.pagelist.map((idx) =>*/}
      {/*    idx === page.page ? (*/}
      {/*      <CPaginationItem active>{page.page}</CPaginationItem>*/}
      {/*    ) : (*/}
      {/*      <CPaginationItem>*/}
      {/*        <a href={'/search?category=' + page.category + '&page=' + idx}>{idx}</a>*/}
      {/*      </CPaginationItem>*/}
      {/*    ),*/}
      {/*  )}*/}
      {/*  {page.next ? (*/}
      {/*    <CPaginationItem aria-label="Next">*/}
      {/*      <span aria-hidden="true">*/}
      {/*        <a href={'/search?category=' + page.category + '&page=' + page.end + 1}>&raquo;</a>*/}
      {/*      </span>*/}
      {/*    </CPaginationItem>*/}
      {/*  ) : (*/}
      {/*    <CPaginationItem aria-label="Next" disabled>*/}
      {/*      <span aria-hidden="true">&raquo;</span>*/}
      {/*    </CPaginationItem>*/}
      {/*  )}*/}
      {/*</CPagination>*/}
      <CSmartPagination
        align="center"
        activePage={currentPage}
        pages={10}
        onActivePageChange={setCurrentPage}
      />
    </>
  )
}

export default Search
