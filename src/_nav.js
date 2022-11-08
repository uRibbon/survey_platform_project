import React from 'react'
import CIcon from '@coreui/icons-react'
import {
  cilSpreadsheet,
} from '@coreui/icons'
import { CNavGroup, CNavItem, CNavTitle } from '@coreui/react'

let _nav = [
  {
    component: CNavTitle,
    name: 'Survey',
  },
  {
    component: CNavGroup,
    name: 'Search',
    to: '/',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '설문검색',
        to: '/survey/search',
      },
    ],
  },
  {
    component: CNavGroup,
    name: 'Create',
    to: '/survey',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '설문생성',
        to: '/survey',
      },
      {
        component: CNavItem,
        name: '설문참여',
        to: '/survey/ParticipateSurvey',
      },
      {
        component: CNavItem,
        name: '설문수정',
        to: '/survey/ModifySurvey',
      },
    ],
  },
  {
    component: CNavGroup,
    name: 'List',
    to: '/',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '참여목록',
        to: '/survey/prtcpList',
      },
      {
        component: CNavItem,
        name: '작성목록',
        to: '/survey/makeList',
      },
    ],
  },
  {
    component: CNavTitle,
    name: 'Group',
  },
  {
    component: CNavGroup,
    name: 'List',
    to: '/group',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '그룹 목록',
        to: '/group/list',
      },
    ],
  },
  {
    component: CNavGroup,
    name: 'Manage',
    to: '/group',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '그룹 생성',
        to: '/group/create',
      },
    ],
  },
  {
    component: CNavTitle,
    name: 'Analysis',
  },
  {
    component: CNavGroup,
    name: 'Survey Analysis',
    to: '/',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '설문 분석',
        to: '/analysis/user_survey_analysis',
      },
    ],
  },
  {
    component: CNavTitle,
    name: 'Admin',
  },
  {
    component: CNavGroup,
    name: 'Group Manage',
    to: '/',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '그룹 리스트',
        to: '/',
      },
    ],
  },
  {
    component: CNavGroup,
    name: 'Survey Manage',
    to: '/',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '설문 카테고리 리스트',
        to: '/category/category_list',
      },
    ],
  },
  {
    component: CNavGroup,
    name: 'Survey Analysis',
    to: '/',
    icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
    items: [
      {
        component: CNavItem,
        name: '설문 분석',
        to: '/analysis/ad_survey_analysis',
      },
    ],
  },
]

export default _nav
