import { Col, Container, ListGroup, Row } from "react-bootstrap";
import "./styles.scss";
import { Link, Outlet } from "react-router-dom";
import SidebarMenu from "../../../components/sidebarMenu";
import Dashboard from "../dashboard";

const HomeAdmin = () => {
  return (
    <>
      <div className="container">
        <Container>
          <Row>
            <Col sm={4}>
              {" "}
              <SidebarMenu />
            </Col>
            <Col sm={8}>
              <Outlet />
            </Col>
          </Row>
        </Container>
      </div>
    </>
  );
};

export default HomeAdmin;
