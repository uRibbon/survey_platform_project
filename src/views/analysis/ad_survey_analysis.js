import React from 'react'
import { CCard, CCardBody, CCol, CCardHeader, CRow } from '@coreui/react'
import { CChartBar, CChartPie, CChartLine } from '@coreui/react-chartjs'

const Charts = () => {
  //const random = () => Math.round(Math.random() * 100)

  return (
    <CRow>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>참여자 연령대</CCardHeader>
          <CCardBody>
            <CChartBar
              data={{
                labels: ['10대', '20대', '30대', '40대', '50대', '60대'],
                datasets: [
                  {
                    label: '참여자 연령대',
                    backgroundColor: '#FFC314',
                    data: [40, 20, 12, 39, 10, 40, 39, 80, 40],
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
          <CCardHeader>참여자 설문 응답 시간대</CCardHeader>
          <CCardBody>
            <CChartLine
              data={{
                labels: [
                  '00:00~04:00',
                  '04:00~08:00',
                  '08:00~12:00',
                  '12:00~16:00',
                  '16:00~20:00',
                  '20:00~24:00',
                ],
                datasets: [
                  {
                    label: '시간별 추이',
                    backgroundColor: 'rgba(151, 187, 205, 0.2)',
                    borderColor: 'rgba(151, 187, 205, 1)',
                    pointBackgroundColor: 'rgba(151, 187, 205, 1)',
                    pointBorderColor: '#fff',
                    data: [2, 3, 5, 40, 48, 96],
                  },
                ],
              }}
            />
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>참여자 남여 비율</CCardHeader>
          <CCardBody>
            <CChartPie
              data={{
                labels: ['남자', '여자'],
                datasets: [
                  {
                    data: [60, 40],
                    backgroundColor: ['#CCEEFF', '#FFD2D7'],
                    hoverBackgroundColor: ['#CCEEFF', '#FFD2D7'],
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
