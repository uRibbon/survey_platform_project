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
import apiConfig from "../lib/apiConfig";


const AppSidebar = () => {
  const dispatch = useDispatch()
  const unfoldable = useSelector((state) => state.sidebarUnfoldable)
  const sidebarShow = useSelector((state) => state.sidebarShow)
  const [navigation, setNavigation] = useState([])
  const { user } = useSelector(({user})=> ({user:user.user}));

  var headers =null;
  if (user != null) {
    const accessToken = user.token.access_token;
    headers = {'Authorization': 'Bearer ' + accessToken };
  }

  useEffect(async () =>{
      let test = []
      const response = await axios.get(apiConfig.menuList, {headers: headers})
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
