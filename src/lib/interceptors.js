
import axios from "axios";
import apiConfig from "../lib/apiConfig";
import { useSelector } from 'react-redux'

//요청시 AccessToken 계속 보내주기
// axios.interceptors.request.use(function (config) {
  
//   const token = localStorage.getItem("user");

//   if (!token) {
//     config.headers["accessToken"] = null;
//     config.headers["refreshToken"] = null;
//     return config;
//   }
//   if (config.headers && token) {
//     console.log(JSON.parse(token));

//     const accessToken = JSON.parse(token).token.access_token;
//     const refreshToken = JSON.parse(token).token.refresh_token;
//     console.log(refreshToken);
//     config.headers["Authorization"] = `Bearer ${accessToken}`;
//     config.headers["refreshToken"] = `Bearer ${refreshToken}`;
//     return config;
//   }
// });

// axios로부터 response를 받아 처리하기 전에 intercept
axios.interceptors.response.use(
    (response) => {
      return response;
    }, (error) => {
      // res에서 error가 발생했을 경우 catch로 넘어가기 전에 처리하는 부분
      let errResponseStatus = null;
      const originalRequest = error.config;
  
      try {
        errResponseStatus = error.response.status;
      } catch (e){ 
  
      }
  
      // access token이 만료되어 발생하는 에러인 경우
      if ((error.message === "Network Error" || errResponseStatus === 401) && !originalRequest.retry) {

        originalRequest.retry = true;
        const user = localStorage.getItem("user");
        const preRefreshToken = JSON.parse(user).token.refresh_token;
        
        if (preRefreshToken) {  // refresh token을 이용하여 access token 재발행 받기

          return axios.post(apiConfig.refreshToken,{ refresh_token: preRefreshToken })
          .then((res) => {
            console.log(res.data);
            
              // 새로 받은 token들의 정보 저장
              localStorage.setItem('user', JSON.stringify(res.data));
              
              const access_token = res.data.token.access_token;
              originalRequest.headers['Authorization'] = "Bearer " + access_token;
            
              const req = axios.request(originalRequest);
              return req;
              
          }).catch(() => {
            // access token을 받아오지 못하는 오류 발생시 logout 처리
            localStorage.removeItem("user");
            window.location.href = "/"; 
  
            return false;
          });
        }
        // 오류 발생 시 오류 내용 출력 후 요청 거절
        return Promise.reject(error);
      }
      // 오류 발생 시 오류 내용 출력 후 요청 거절
      return Promise.reject(error);
    });

    