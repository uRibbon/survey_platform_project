import React, { useState } from 'react'
import CIcon from '@coreui/icons-react'
import {
  cilPrint,
  cilSpreadsheet,
} from '@coreui/icons'
import { CNavGroup, CNavItem, CNavTitle } from '@coreui/react'


const Test=()=>
{let dummy_data = [
  {
    "menuId": 1,
    "menuName": "survey",
    "menuUrl": null,
    "menuIcon": null,
    "menuList": [
      {
        "menuId": 101,
        "menuName": "search",
        "menuUrl": null,
        "menuIcon": "<CIcon icon={cilSpreadsheet} customClassName=\"nav-icon\" />",
        "menuList": [
          {
            "menuId": 10101,
            "menuName": "설문 검색",
            "menuUrl": "/survey/search",
            "menuIcon": null,
            "menuList": []
          }
        ]
      },
      {
        "menuId": 102,
        "menuName": "create",
        "menuUrl": null,
        "menuIcon": "<CIcon icon={cilSpreadsheet} customClassName=\"nav-icon\" />",
        "menuList": [
          {
            "menuId": 10201,
            "menuName": "설문 생성",
            "menuUrl": "/survey",
            "menuIcon": null,
            "menuList": []
          }
        ]
      },
      {
        "menuId": 103,
        "menuName": "list",
        "menuUrl": null,
        "menuIcon": "<CIcon icon={cilSpreadsheet} customClassName=\"nav-icon\" />",
        "menuList": [
          {
            "menuId": 10301,
            "menuName": "참여 목록",
            "menuUrl": "/survey/prtcpList",
            "menuIcon": null,
            "menuList": []
          },
          {
            "menuId": 10302,
            "menuName": "생성 목록",
            "menuUrl": "/survey/makeList",
            "menuIcon": null,
            "menuList": []
          }
        ]
      }
    ]
  }
]

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

console.log(typeof(dummy_data))
console.log(dummy_data)
// const [nav, setNav] = useState([])

let new_nav = [
  
  dummy_data.map((large) => {

      let L = {
        component: CNavTitle,
        name: large.menuName,
      }
      // setNav([...nav, L])
    
      // console.log('대분류만 추가함: ',nav)

      large.menuList.map((middle) =>{
        console.log('중분류: ', middle.menuName)
        console.log('소분류들: ', middle.menuList)
      }
      )
  })
]

return(
  _nav
)
}

export default Test
