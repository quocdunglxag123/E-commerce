import React from "react";
import { FaTruckMoving } from "react-icons/fa";
import { AiOutlineHeart } from "react-icons/ai";
import { BsBagCheck } from "react-icons/bs";
import { AiOutlineUser } from "react-icons/ai";
import { CiLogin } from "react-icons/ci";
import { CiLogout } from "react-icons/ci";
import { Link } from "react-router-dom";
import "./style.scss";
const Header = ({searchbtn}) => {
  const [search, setSearch] = React.useState()
  return (
    <>
      <div className="free">
        <div className="icon">
          <FaTruckMoving />
        </div>
        <p>FREE Shipping when shopping upto $1000</p>
      </div>
      <div className="main_header">
        <div className="container">
          <div className="logo">
            <img src="./img/logo.svg" alt="logo" />
          </div>
          <div className="search_box">
          <input type='text' value={search} placeholder='Search Your Product...' autoComplete='off' onChange={(e) => setSearch(e.target.value)}></input>
                <button onClick={() => searchbtn (search)}>Search</button>
          </div>
          <div className="icon">
            <div className="account">
              <div className="user_icon">
                <AiOutlineUser />
              </div>
              <p>Hello, user</p>
            </div>
            <div className='second_icon'>
                <Link to="/" className='link'><AiOutlineHeart /></Link>
                <Link to="/cart" className='link'><BsBagCheck /></Link>
                </div>
          </div>
        </div>
      </div>
      <div className="header" style={{ position: "inherit" }}>
        <div className="container">
          <div className="nav">
            <ul>
              <li>
                <Link to="/" className="link">
                  Home
                </Link>
              </li>
              <li>
                <Link to="/product" className="link">
                  Product
                </Link>
              </li>
              <li>
                <Link to="/about" className="link">
                  About
                </Link>
              </li>
              <li>
                <Link to="/contact" className="link">
                  Contact
                </Link>
              </li>
            </ul>
          </div>

          <div className="auth">
            <button>
              <CiLogin />
            </button>
            <button>
              <CiLogout />
            </button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Header;
