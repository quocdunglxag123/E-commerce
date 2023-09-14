import { Button, Card } from "react-bootstrap";
import avt from "../../../components/assets/img/avt.jpg";
const Dashboard = () => {
  return (
    <>
      <div className="container-dashboard">
        <div className="introduction d-flex justify-content-between mt-3">
          <div className="introduction1">
            <span>
              Hello, <strong> Tuyen</strong>
            </span>
          </div>
          <div className="avatar">
            <a href="" style={{ textDecoration: "none", color: "black" }}>
              <img
                src={avt}
                alt=""
                style={{ width: "40px", borderRadius: "50%" }}
              />{" "}
              Ngan Tuyen
            </a>
          </div>
        </div>
        <div className="body-dashboard mt-3">
          <h3>Orders</h3>
          <div className="statistic-over-time d-flex gap-3 mt-4 mb-4">
            <div className="card1">
              <Card style={{ width: "18rem" }}>
                <Card.Body>
                  <Card.Title>work</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="danger">ERROR</Button>
                </Card.Body>
              </Card>
            </div>
            <div className="card1">
              <Card style={{ width: "18rem" }}>
                <Card.Body>
                  <Card.Title>work</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="danger">ERROR</Button>
                </Card.Body>
              </Card>
            </div>
            <div className="card1">
              <Card style={{ width: "18rem" }}>
                <Card.Body>
                  <Card.Title>work</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="danger">ERROR</Button>
                </Card.Body>
              </Card>
            </div>
          </div>
          <h4>Revenue</h4>
          <div className="statistic-over-time d-flex gap-3 mt-4 ">
            <div className="card1">
              <Card style={{ width: "18rem" }}>
                <Card.Body>
                  <Card.Title>work</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="danger">ERROR</Button>
                </Card.Body>
              </Card>
            </div>
            <div className="card1">
              <Card style={{ width: "18rem" }}>
                <Card.Body>
                  <Card.Title>work</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="danger">ERROR</Button>
                </Card.Body>
              </Card>
            </div>
            <div className="card1">
              <Card style={{ width: "18rem" }}>
                <Card.Body>
                  <Card.Title>work</Card.Title>
                  <Card.Text>
                    Some quick example text to build on the card title and make
                    up the bulk of the card's content.
                  </Card.Text>
                  <Button variant="danger">ERROR</Button>
                </Card.Body>
              </Card>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Dashboard;
