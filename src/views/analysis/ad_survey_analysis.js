import React,{ useEffect, useState } from 'react'
import { CCard, CCardBody, CCol, CCardHeader, CRow } from '@coreui/react'
import { CChartBar, CChartLine, CChartDoughnut, } from '@coreui/react-chartjs'
import axios from 'axios';
import apiConfig from '../../lib/apiConfig'


const Charts = () => {
  const [one, setOne] = useState([]);
  const [two, setTwo] = useState([]);
  const [three, setThree] = useState([]);
  const [four, setFour] = useState([]);
  let Data = {
    subject: '',
    labels: [],
    values:[]
  }



  const analysisInfo = async ()=>{

    for (let analysisId = 1; analysisId < 5; analysisId++) {
        const response = await axios.post(`${apiConfig.platformAnalysisData}?platform_analysis_Id=${analysisId}`)

        // console.log('hihi',response.data[0].platformAnalysisId.subject)
        Data['subject'] = response.data[0].platformAnalysisId.subject
        let Data_labels = []
        let Data_values = []

        response.data.map(data =>{
          Data_labels.push(data.optionName)
          Data_values.push(data.value)
        })
        Data['labels'] = Data_labels
        Data['values'] = Data_values

        if (analysisId ===1){
          setOne({'subject':response.data[0].platformAnalysisId.subject, 'label':Data_labels, 'value':Data_values});
        } else if (analysisId ===2){
          setTwo({'subject':response.data[0].platformAnalysisId.subject, 'label':Data_labels, 'value':Data_values});
        } else if (analysisId ===3){
          setThree({'subject':response.data[0].platformAnalysisId.subject, 'label':Data_labels, 'value':Data_values});
        } else if (analysisId ===4){
          setFour({'subject':response.data[0].platformAnalysisId.subject, 'label':Data_labels, 'value':Data_values});
        }
    }
  }

  useEffect(()=>{
    analysisInfo();
  },[]);
  
  return (
    <CRow>
      <CCol xs={6}>
        <CCard className="mb-4">
          <CCardHeader>{one.subject}</CCardHeader>
          <CCardBody>
            <CChartBar
              data={{
                labels: one.label,
                datasets: [
                  {
                    label: one.subject,
                    backgroundColor: '#D3D3D3',
                    data: one.value,
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
          <CCardHeader>{two.subject}</CCardHeader>
          <CCardBody>
            <CChartLine
              data={{
                labels: two.label,
                datasets: [
                  {
                    label: two.subject,
                    backgroundColor: 'rgba(151, 187, 205, 0.2)',
                    borderColor: 'rgba(151, 187, 205, 1)',
                    pointBackgroundColor: 'rgba(151, 187, 205, 1)',
                    pointBorderColor: '#fff',
                    data: two.value,
                  },
                ],
              }}
            />
          </CCardBody>
        </CCard>
      </CCol>
      <CCol xs={6}>
        <CCard className="mb-4">
            <CCardHeader>{three.subject}</CCardHeader>
            <CCardBody>
              <CChartBar
                data={{
                  labels: three.label,
                  datasets: [
                    {
                      label: three.subject,
                      backgroundColor: '#D3D3D3',
                      data: three.value,
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
          <CCardHeader>{four.subject}</CCardHeader>
          <CCardBody>
            <CChartLine
              data={{
                labels: four.label,
                datasets: [
                  {
                    label: four.subject,
                    backgroundColor: 'rgba(151, 187, 205, 0.2)',
                    borderColor: 'rgba(151, 187, 205, 1)',
                    pointBackgroundColor: 'rgba(151, 187, 205, 1)',
                    pointBorderColor: '#fff',
                    data: four.value,
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
