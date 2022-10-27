import React from 'react'
import { CCard, CCardBody, CCol, CCardHeader, CRow } from '@coreui/react'
import { CChartBar, CChartDoughnut, CChartLine, CChartPie } from '@coreui/react-chartjs'
import { DocsCallout } from 'src/components'

const Charts = () => {
  const random = () => Math.round(Math.random() * 100)

  return (
    <CRow>
      <CCol xs={12}>
        <DocsCallout
          name="Chart"
          href="components/chart"
          content="React wrapper component for Chart.js 3.0, the most popular charting library."
        />
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>연령대 별 사용자</CCardHeader>
          <CCardBody>
            <CChartBar
              data={{
                labels: ['10대', '20대', '30대', '40대', '50대', '60대'],
                datasets: [
                  {
                    label: '연령대 별 사용자 수',
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
          <CCardHeader>월별 설문 등록</CCardHeader>
          <CCardBody>
            <CChartLine
              data={{
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                datasets: [
                  {
                    label: '월별 설문 등록',
                    backgroundColor: 'rgba(151, 187, 205, 0.2)',
                    borderColor: 'rgba(151, 187, 205, 1)',
                    pointBackgroundColor: 'rgba(151, 187, 205, 1)',
                    pointBorderColor: '#fff',
                    data: [random(), random(), random(), random(), random(), random(), random()],
                  },
                ],
              }}
            />
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>카테고리별 설문 갯수</CCardHeader>
          <CCardBody>
            <CChartDoughnut
              data={{
                labels: ['교육', '기업', '자영업/사업', '연애', '취미'],
                datasets: [
                  {
                    backgroundColor: ['#FFDDDD', '#DDFFDD', '#DDEEFF', '#EEDDFF', '#FFDDFF'],
                    data: [40, 20, 80, 10, 30],
                  },
                ],
              }}
            />
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>남녀 사용자 비율</CCardHeader>
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
