import { Button } from "react-bootstrap";
import "./styles.scss";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
const Products = () => {
  const navigate = useNavigate();
  const edit = () => {
    navigate("./eidtproduct");
  };
  const selector = useSelector((state) => state.product);
  console.log(selector);
  return (
    <>
      <div className="product-container">
        <Button
          href="#"
          style={{ marginTop: "40px" }}
          onClick={() => navigate("./eidtproduct")}
        >
          Add new product
        </Button>
        <div
          className="produce-title"
          style={{
            width: "100",
            backgroundColor: "white",
            padding: "10px 10px",
            margin: "20px 0",
          }}
        >
          <h3>PRODUCT NAME</h3>
        </div>
        <div className="product-list d-flex">
          <div className="product-name">
            <strong>Iphone 14 pro Black</strong>
          </div>
          <div className="function-product">
            <div className="edit">
              <Button
                variant="outline-secondary"
                onClick={() => navigate("./eidtproduct")}
              >
                Edit
              </Button>{" "}
            </div>
            <div className="delete">
              <Button variant="outline-danger">Delete</Button>{" "}
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Products;
