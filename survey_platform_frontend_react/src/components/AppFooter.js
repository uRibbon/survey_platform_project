import React from 'react'
import { CFooter } from '@coreui/react'

const AppFooter = () => {
  return (
    <CFooter>
      <div>
        <span className="ms-1">Survey Based Data Sharing Platform </span>
      </div>
      <div className="ms-auto">
        <span> 2022 KEP SW ACADEMY</span>
      </div>
    </CFooter>
  )
}

export default React.memo(AppFooter)
