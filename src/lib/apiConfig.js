 const service = {
    auth : '/auth-service',
    survey : '/survey-service',
    common : '/common-service',
};

const version = '/v1';

const apiConfig = {
    userDetail : service.auth + version + '/user/detail',       // 사용자 상세정보 조회
    surveyList : service.survey + version + '/survey/list',     // 설문 리스트 조회
    menuList : service.common + version + '/common/menu'        // 사이드바 메뉴 리스트 조회
}

export default apiConfig;
