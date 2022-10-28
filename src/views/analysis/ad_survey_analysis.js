import React from 'react'
import { CCard, CCardBody, CCol, CCardHeader, CRow } from '@coreui/react'
import { CChartBar, CChartLine, CChartDoughnut, } from '@coreui/react-chartjs'

const Charts = () => {
  return (
    <CRow>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>월별 회원가입</CCardHeader>
          <CCardBody>
            <CChartBar
              data={{
                labels: [
                  '1월',
                  '2월',
                  '3월',
                  '4월',
                  '5월',
                  '6월',
                  '7월',
                  '8월',
                  '9월',
                  '10월',
                  '11월',
                  '12월',],
                datasets: [
                  {
                    label: '회원가입 수',
                    backgroundColor: '#D3D3D3',
                    data: [40, 20, 12, 39, 10, 40, 39, 80, 40, 70, 35, 58],
                  },
                ],
              }}
              labels="months"
            />
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>월별 설문 등록</CCardHeader>
          <CCardBody>
            <CChartLine
              data={{
                labels: [
                  '1월',
                  '2월',
                  '3월',
                  '4월',
                  '5월',
                  '6월',
                  '7월',
                  '8월',
                  '9월',
                  '10월',
                  '11월',
                  '12월',
                ],
                datasets: [
                  {
                    label: '설문 등록 개수',
                    backgroundColor: 'rgba(151, 187, 205, 0.2)',
                    borderColor: 'rgba(151, 187, 205, 1)',
                    pointBackgroundColor: 'rgba(151, 187, 205, 1)',
                    pointBorderColor: '#fff',
                    data: [50, 68, 38, 87, 39, 49, 60, 40, 38, 68, 47, 38],
                  },
                ],
              }}
            />
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>카테고리별 설문 개수</CCardHeader>
          <CCardBody>
            <CChartDoughnut
              data={{
                labels: ['학교', '취미', '연애', '기업'],
                datasets: [
                  {
                    backgroundColor: ['#FFD700', '#90EE90', '#AFEEEE', '#DDA0DD'],
                    data: [40, 20, 50, 30],
                  },
                ],
              }}
            />
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>카테고리별 설문 조회수</CCardHeader>
          <CCardBody>
            <CChartDoughnut
              data={{
                labels: ['학교', '취미', '연애', '기업'],
                datasets: [
                  {
                    backgroundColor: ['#FFD700', '#90EE90', '#AFEEEE', '#DDA0DD'],
                    data: [36, 57, 64, 47],
                  },
                ],
              }}
            />
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Charts
