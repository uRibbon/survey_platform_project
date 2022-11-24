import client from './client';
import apiConfig from '../apiConfig';

// 로그인
export const login = ({ username, password })=> 
  client.post(apiConfig.signin, { username, password });

// 회원가입
export const register = ({ username, password }) =>
  client.post(apiConfig.signup, { username, password });

// 로그인 상태 확인
export const check = (data) => {
    return { "data" : data };
// client.post(apiConfig.authCheck, {auth});
}

// 로그아웃
export const logout = () => client.post('/api/auth/logout');