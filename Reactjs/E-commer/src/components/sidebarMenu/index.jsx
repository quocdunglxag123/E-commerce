import { Link } from "react-router-dom";
import "./styles.scss";
import { BarChartLineFill } from "react-bootstrap-icons";
import Icon from "../share/icon";

const SidebarMenu = () => {
  return (
    <div className="container-fuild">
      <div className="col-auto col-md-3 min-vh-100">
        <a
          href=""
          className="text decoretion-none d-flex align-itemcenter ms-3 mt-2"
          style={{ textDecoration: "none" }}
        >
          <i
            class="fa-solid fa-shop"
            style={{ color: "black", paddingTop: "5px", fontSize: "20px" }}
          ></i>
          <span className="ms-1 fs-4 " style={{ color: "black" }}>
            EcommerceAdmin
          </span>
        </a>
        <hr />
        <ul className="nav nav-pills flex-column">
          <li className="nav-item fs-4">
            <Link
              to="./dashboard"
              className="nav-link ms-2 fs-5 decoretion-none"
              style={{
                color: "black",
                textDecoration: "none",
                display: "flex",
                gap: "10px",
              }}
            >
              <Icon children="fa-solid fa-house" />
              Dashboard
            </Link>
          </li>
          <li className="nav-item fs-4">
            <Link
              to="./product"
              className="nav-link ms-2 fs-5 decoretion-none"
              style={{
                color: "black",
                textDecoration: "none",
                display: "flex",
                gap: "10px",
              }}
            >
              <Icon children="fa-solid fa-whiskey-glass" />
              Products
            </Link>
          </li>
          <li className="nav-item fs-4">
            <Link
              to="./categories"
              className="nav-link ms-2 fs-5 decoretion-none"
              style={{
                color: "black",
                textDecoration: "none",
                display: "flex",
                gap: "10px",
              }}
            >
              <Icon children="fa-solid fa-list" />
              Categories
            </Link>
          </li>
          <li className="nav-item fs-4">
            <Link
              to="./orders"
              className="nav-link ms-2 fs-5 decoretion-none"
              style={{
                color: "black",
                textDecoration: "none",
                display: "flex",
                gap: "10px",
              }}
            >
              <Icon children="fa-solid fa-bars-staggered" />
              Orders
            </Link>
          </li>
          <li className="nav-item fs-4">
            <Link
              to="./admin"
              className="nav-link ms-2 fs-5 decoretion-none"
              style={{
                color: "black",
                textDecoration: "none",
                display: "flex",
                gap: "10px",
              }}
            >
              <Icon children="fa-regular fa-user" />
              Admins
            </Link>
          </li>
          <li className="nav-item fs-4">
            <Link
              to="./setting"
              className="nav-link ms-2 fs-5 decoretion-none"
              style={{
                color: "black",
                textDecoration: "none",
                display: "flex",
                gap: "10px",
              }}
            >
              <Icon children="fa-solid fa-gear" />
              Settings
            </Link>
          </li>
          <li className="nav-item fs-4">
            <Link
              to="./dashboard"
              className="nav-link ms-2 fs-5 decoretion-none"
              style={{
                color: "black",
                textDecoration: "none",
                display: "flex",
                gap: "10px",
              }}
            >
              <Icon children="fa-solid fa-arrow-right-from-bracket" />
              Logout
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default SidebarMenu;
