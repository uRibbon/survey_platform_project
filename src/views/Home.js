import React, { useState } from 'react'
import {
  CImage,
  CCarousel,
  CCarouselCaption,
  CCarouselItem,
  CRow,
  CCol,
  CWidgetStatsA,
  CWidgetStatsB,
  CWidgetStatsC,
  CWidgetStatsD,
  CWidgetStatsE,
  CDropdown,
  CDropdownToggle,
  CDropdownItem,
  CDropdownMenu,
  CCard,
  CCardImage,
  CCardTitle,
  CCardText,
  CCardBody,
  CButton,
  CCardHeader,
} from '@coreui/react'
import CIcon from "@coreui/icons-react";
import {cilOptions} from "@coreui/icons";
const image = require("../assets/images/react.jpg")

const Home = () => {
  return (
    <>
      <CRow className="m-3">
        <CCol>
          <CCard>
            {/*<CCardHeader>설문 생성하기</CCardHeader>*/}
            <CCardBody>
              <CCardTitle>설문 생성하기</CCardTitle>
              <CCardText>With supporting text below as a natural lead-in to additional content.</CCardText>
              <CButton href="#">Go somewhere</CButton>
            </CCardBody>
          </CCard>
        </CCol>
        <CCol>
          <CCard>
            {/*<CCardHeader>설문 생성함</CCardHeader>*/}
            <CCardBody>
              <CCardTitle>설문 생성함</CCardTitle>
              <CCardText>With supporting text below as a natural lead-in to additional content.</CCardText>
              <CButton href="#">Go somewhere</CButton>
            </CCardBody>
          </CCard>
        </CCol>
        <CCol>
          <CCard>
            {/*<CCardHeader>설문 참여함</CCardHeader>*/}
            <CCardBody>
              <CCardTitle>설문 참여함</CCardTitle>
              <CCardText>With supporting text below as a natural lead-in to additional content.</CCardText>
              <CButton href="#">Go somewhere</CButton>
            </CCardBody>
          </CCard>
        </CCol>
      </CRow>
      <CRow className="m-3">
        <CCarousel controls indicators>
          <CCarouselItem>
            <CImage className="d-block w-100" src={image} alt="slide 1" />
            <CCarouselCaption className="d-none d-md-block">
              <h5>First slide label</h5>
              <p>Some representative placeholder content for the first slide.</p>
            </CCarouselCaption>
          </CCarouselItem>
          <CCarouselItem>
            <CImage className="d-block w-100" src={image} alt="slide 2" />
            <CCarouselCaption className="d-none d-md-block">
              <h5>Second slide label</h5>
              <p>Some representative placeholder content for the first slide.</p>
            </CCarouselCaption>
          </CCarouselItem>
          <CCarouselItem>
            <CImage className="d-block w-100" src={image} alt="slide 3" />
            <CCarouselCaption className="d-none d-md-block">
              <h5>Third slide label</h5>
              <p>Some representative placeholder content for the first slide.</p>
            </CCarouselCaption>
          </CCarouselItem>
        </CCarousel>
      </CRow>
    </>
  )
}

export default Home
