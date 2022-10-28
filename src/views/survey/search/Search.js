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
  CCardImage,
  CCardBody,
  CCardTitle,
  CCardText,
  CRow,
  CCol,
  CCardSubtitle,
  CForm,
} from '@coreui/react'
import { CSmartPagination } from '@coreui/react-pro'

const Search = () => {
  let carddata = [
    {
      id: 1,
      img: require('../../../assets/images/react.jpg'),
      title: '설문조사1',
      content: '동아리 설문조사 입니다.',
      date: '2022.09.10',
      writer: '예나',
    },
    {
      id: 2,
      img: require('../../../assets/images/react.jpg'),
      title: '설문조사2',
      content: '동아리 설문조사 입니다.',
      date: '2022.09.10',
      writer: '예나',
    },
    {
      id: 3,
      img: require('../../../assets/images/react.jpg'),
      title: '설문조사3',
      content: '동아리 설문조사 입니다.',
      date: '2022.09.10',
      writer: '예나',
    },
    {
      id: 4,
      img: require('../../../assets/images/react.jpg'),
      title: '설문조사4',
      content: '동아리 설문조사 입니다.',
      date: '2022.09.10',
      writer: '예나',
    },
    {
      id: 5,
      img: require('../../../assets/images/react.jpg'),
      title: '설문조사5',
      content: '동아리 설문조사 입니다.',
      date: '2022.09.10',
      writer: '예나',
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
              <CCardImage orientation="top" src={data.img} />
              <CCardBody>
                <CCardTitle>{data.title}</CCardTitle>
                <CCardSubtitle className="mb-2 text-medium-emphasis">{data.writer}</CCardSubtitle>
                <CCardText>{data.content}</CCardText>
                <CCardText>
                  <small className="text-medium-emphasis">{data.date}</small>
                </CCardText>
                <CButton href="#">상세보기</CButton>
              </CCardBody>
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
