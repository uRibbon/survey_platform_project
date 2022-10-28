import React from 'react'
import { CCard, CCardBody, CCol, CCardHeader, CRow } from '@coreui/react'
import { CChartBar, CChartPie, CChartLine, CChartDoughnut } from '@coreui/react-chartjs'

const Charts = () => {
  //const random = () => Math.round(Math.random() * 100)

  return (
    <CRow>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>설문 응답자 연령대</CCardHeader>
          <CCardBody>
            <CChartBar
              data={{
                labels: ['10대', '20대', '30대', '40대', '50대', '60대'],
                datasets: [
                  {
                    label: '연령대별 추이',
                    backgroundColor: '#cfd0fe',
                    data: [40, 20, 12, 39, 10, 65],
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
          <CCardHeader>설문 응답자 직업</CCardHeader>
          <CCardBody>
            <CChartLine
              data={{
                labels: ['학생', '직장인', '자영업자', '주부', '군인'],
                datasets: [
                  {
                    label: '직업별 추이',
                    backgroundColor: 'rgba(220, 220, 220, 0.2)',
                    borderColor: 'rgba(220, 220, 220, 1)',
                    pointBackgroundColor: 'rgba(220, 220, 220, 1)',
                    pointBorderColor: '#fff',
                    data: [50, 40, 35, 30, 5],
                  }
                ],
              }}
            />
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>설문 응답자 남녀 비율</CCardHeader>
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
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>설문 응답 시간대</CCardHeader>
          <CCardBody>
            <CChartDoughnut
              data={{
                labels: [
                  '00시~04시',
                  '04시~08시',
                  '08시~12시',
                  '12시~16시',
                  '16시~20시',
                  '20시~24시',
                ],
                datasets: [
                  {
                    backgroundColor: ['#FFD700', '#90EE90', '#AFEEEE', '#DDA0DD', '#FFA2AD', '#BEBEBE'],
                    data: [5, 20, 50, 40, 50, 60],
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
