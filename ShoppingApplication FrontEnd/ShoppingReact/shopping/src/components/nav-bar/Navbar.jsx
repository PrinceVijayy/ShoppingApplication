import React from 'react'
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom'
import AdminProductList from '../../pages/AdminProductList'
import Login from '../../pages/Login'

const Navbar = () => {
  return (
    <div>
      <BrowserRouter>
      <ul>
        <li>
            <Link to="/login" > login</Link>
        </li>
      </ul>
      <Routes>
        <Route path='/' element={<AdminProductList />} />
        <Route path='/login' element={<Login />} />
      </Routes>
      </BrowserRouter>
    </div>
  )
}

export default Navbar
