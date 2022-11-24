import React from 'react';

import {
    CToast,
    CToastHeader,
    CToastBody,
  } from '@coreui/react'
  
const LoginSuccessToast = () => {

    return (
    <>
     <CToast>
      <CToastHeader closeButton>
        <svg
          className="rounded me-2"
          width="20"
          height="20"
          xmlns="http://www.w3.org/2000/svg"
          preserveAspectRatio="xMidYMid slice"
          focusable="false"
          role="img"
        >
          <rect width="100%" height="100%" fill="#ffff00"></rect>
        </svg>
        <strong className="me-auto">SURVEY PLATFORM</strong>
        {/* <small>7 min ago</small> */}
      </CToastHeader>
      <CToastBody>Hello!</CToastBody>
    </CToast>
    </>
  )

}

export default LoginSuccessToast;
