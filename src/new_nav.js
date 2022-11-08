import React from 'react'
import CIcon from '@coreui/icons-react'
import {
  cilSpreadsheet,
  cilBell,
  cilCalculator,
  cilChartPie,
  cilCursor,
  cilDescription,
  cilDrop,
  cilNotes,
  cilPencil,
  cilPuzzle,
  cilSpeedometer,
  cilStar,
} from '@coreui/icons'
import { CNavGroup, CNavItem, CNavTitle } from '@coreui/react'

let data
// const req = new Request('http://localhost:8082/v1/common/menu', {
//   method: "GET",
//   headers: {
//     'content-type': 'application/json',
//   }
// });

// fetch('http://localhost:8082/v1/common/menu', {
//   method: 'get',
//   headers: {
//     'content-type': 'application/json',
//   }
// }).then((res) => {
//   console.log(res.json())
// }).catch((err) => {
//   console.log(err)
// })


// axios({
//   method: "get",
//   url: "http://localhost:8082/v1/common/menu",
//   responseType: "type"
// }).then((response) => {
//   console.log(response.data)
//   data = response.data
// }).catch((error) => {
//   console.log(error)
// }).then(() => {
//
// })

data = [
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
  },
  {
    "menuId": 2,
    "menuName": "group",
    "menuUrl": null,
    "menuIcon": null,
    "menuList": [
      {
        "menuId": 201,
        "menuName": "list",
        "menuUrl": null,
        "menuIcon": "<CIcon icon={cilSpreadsheet} customClassName=\"nav-icon\" />",
        "menuList": [
          {
            "menuId": 20101,
            "menuName": "그룹 목록",
            "menuUrl": "/group/list",
            "menuIcon": null,
            "menuList": []
          }
        ]
      },
      {
        "menuId": 202,
        "menuName": "manage",
        "menuUrl": null,
        "menuIcon": "<CIcon icon={cilSpreadsheet} customClassName=\"nav-icon\" />",
        "menuList": [
          {
            "menuId": 20201,
            "menuName": "그룹 생성",
            "menuUrl": "/group/create",
            "menuIcon": null,
            "menuList": []
          }
        ]
      }
    ]
  },
  {
    "menuId": 3,
    "menuName": "admin",
    "menuUrl": null,
    "menuIcon": null,
    "menuList": [
      {
        "menuId": 301,
        "menuName": "group manage",
        "menuUrl": null,
        "menuIcon": "<CIcon icon={cilSpreadsheet} customClassName=\"nav-icon\" />",
        "menuList": [
          {
            "menuId": 30101,
            "menuName": "그룹 목록",
            "menuUrl": "",
            "menuIcon": null,
            "menuList": []
          }
        ]
      },
      {
        "menuId": 302,
        "menuName": "survey manage",
        "menuUrl": null,
        "menuIcon": "<CIcon icon={cilSpreadsheet} customClassName=\"nav-icon\" />",
        "menuList": [
          {
            "menuId": 30201,
            "menuName": "설문 카테고리 목록",
            "menuUrl": "/category/category_list",
            "menuIcon": null,
            "menuList": []
          }
        ]
      },
      {
        "menuId": 303,
        "menuName": "survey analysis",
        "menuUrl": null,
        "menuIcon": "<CIcon icon={cilSpreadsheet} customClassName=\"nav-icon\" />",
        "menuList": [
          {
            "menuId": 30301,
            "menuName": "설문 분석",
            "menuUrl": "/analysis/ad_survey_analysis",
            "menuIcon": null,
            "menuList": []
          }
        ]
      }
    ]
  }
]

let _nav = [
  data.map((large) => (
    {
      component: CNavTitle,
      name     : large.menuName,
    },
      large.menuList.map((middle) => (
        {
          component: CNavGroup,
          name     : middle.menuName,
          to       : middle.menuUrl,
          icon     : middle.menuIcon,
          items    : [
            middle.menuList.map((small) => (
              {
                component: CNavItem,
                name     : small.menuName,
                to       : small.menuUrl,
              }
            ))
          ]
        }
      ))
  ))
]

export default new_nav
