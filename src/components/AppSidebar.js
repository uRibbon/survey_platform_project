import React, { useState, useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux'
import { CSidebar, CSidebarBrand, CSidebarNav, CSidebarToggler } from '@coreui/react'
import CIcon from '@coreui/icons-react'
import { AppSidebarNav } from './AppSidebarNav'
import SimpleBar from 'simplebar-react'
import 'simplebar/dist/simplebar.min.css'
import {
  cilSpreadsheet,
} from '@coreui/icons'
import { CNavGroup, CNavItem, CNavTitle } from '@coreui/react'
import axios from 'axios';


const AppSidebar = () => {
  const dispatch = useDispatch()
  const unfoldable = useSelector((state) => state.sidebarUnfoldable)
  const sidebarShow = useSelector((state) => state.sidebarShow)
  const [navigation, setNavigation] = useState([])

  // let DUMMY_DATA = [
  //   {
  //     component: CNavTitle,
  //     name: 'Survey',
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'Search',
  //     to: '/',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '설문검색',
  //         to: '/survey/search',
  //       },
  //     ],
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'Create',
  //     to: '/survey',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '설문생성',
  //         to: '/survey',
  //       },
  //       {
  //         component: CNavItem,
  //         name: '설문참여',
  //         to: '/survey/ParticipateSurvey',
  //       },
  //       {
  //         component: CNavItem,
  //         name: '설문수정',
  //         to: '/survey/ModifySurvey',
  //       },
  //     ],
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'List',
  //     to: '/',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '참여목록',
  //         to: '/survey/prtcpList',
  //       },
  //       {
  //         component: CNavItem,
  //         name: '작성목록',
  //         to: '/survey/makeList',
  //       },
  //     ],
  //   },
  //   {
  //     component: CNavTitle,
  //     name: 'Group',
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'List',
  //     to: '/group',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '그룹 목록',
  //         to: '/group/list',
  //       },
  //     ],
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'Manage',
  //     to: '/group',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '그룹 생성',
  //         to: '/group/create',
  //       },
  //     ],
  //   },
  //   {
  //     component: CNavTitle,
  //     name: 'Analysis',
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'Survey Analysis',
  //     to: '/',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '설문 분석',
  //         to: '/analysis/user_survey_analysis',
  //       },
  //     ],
  //   },
  //   {
  //     component: CNavTitle,
  //     name: 'Admin',
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'Group Manage',
  //     to: '/',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '그룹 리스트',
  //         to: '/',
  //       },
  //     ],
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'Survey Manage',
  //     to: '/',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '설문 카테고리 리스트',
  //         to: '/category/category_list',
  //       },
  //     ],
  //   },
  //   {
  //     component: CNavGroup,
  //     name: 'Survey Analysis',
  //     to: '/',
  //     icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
  //     items: [
  //       {
  //         component: CNavItem,
  //         name: '설문 분석',
  //         to: '/analysis/ad_survey_analysis',
  //       },
  //     ],
  //   },
  // ]

  useEffect(async () =>{
      let test = []
      const response = await axios.get('/common-service/v1/common/menu')
      test = response.data
      test.map((large) => {
          setNavigation(
            (navigation)=>[...navigation,{
              component: CNavTitle,
              name: large.menuName,
            }])
          large.menuList.map((middle) =>{
            let new_items = []
            for (let i = 0; i < middle.menuList.length; i++) {
              new_items.push(
                {
                  component: CNavItem,
                  name: middle.menuList[i].menuName,
                  to: middle.menuList[i].menuUrl,
                }
              )
            }
            setNavigation((navigation)=>[...navigation,{
              component: CNavGroup,
              name: middle.menuName,
              to: '/',
              icon: <CIcon icon={cilSpreadsheet} customClassName="nav-icon" />,
              items: new_items
            }])
          }
          )
      }
    )
  }, []);

  return (
    <CSidebar
      position="fixed"
      unfoldable={unfoldable}
      visible={sidebarShow}
      onVisibleChange={(visible) => {
        dispatch({ type: 'set', sidebarShow: visible })
      }}
    >
      <CSidebarBrand className="d-none d-md-flex" to="/">
        {/* <CIcon className="sidebar-brand-full" icon={logoNegative} height={35} /> */}
        {/* <CIcon className="sidebar-brand-narrow" icon={sygnet} height={35} /> */}
        <a className='main_logo' href='/#'> ☁️ SURVEY PLATFORM ☁️ </a>
      </CSidebarBrand>
      <CSidebarNav>
        <SimpleBar>
          <AppSidebarNav items={navigation} />
        </SimpleBar>
      </CSidebarNav>
      <CSidebarToggler
        className="d-none d-lg-flex"
        onClick={() => dispatch({ type: 'set', sidebarUnfoldable: !unfoldable })}
      />
    </CSidebar>
  )
}

export default React.memo(AppSidebar)
