import { useForm } from "react-hook-form";
import CustomInput from "../../../components/share/input";
import Customselect from "../../../components/share/select";

import "./styles.scss";
import { Button } from "react-bootstrap";
const Categories = () => {
  const { register, handleSubmit } = useForm();
  return (
    <>
      <h2>Category</h2>
      <form action="">
        <div className="form-category d-flex gap-4">
          <CustomInput
            id="category_name"
            label={"create new category"}
            placeholder={"category name"}
            register={register}
            width={"40%"}
          />
          <Customselect
            id="parent_category"
            register={register}
            width={"40%"}
            backgroundColor={"white"}
            label={"aa"}
          />
        </div>

        <div className="properties">
          <Button
            type="button"
            style={{ backgroundColor: "white", color: "black" }}
          >
            Add new property
          </Button>
          <Button variant="primary">Save</Button>
        </div>
      </form>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">CATEGORY NAME</th>
            <th scope="col">PARENT CATEGORY</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">Mobiles</th>
            <td></td>
            <td>
              <div className="function-product">
                <div className="edit">
                  <Button variant="outline-secondary">Edit</Button>{" "}
                </div>
                <div className="delete">
                  <Button variant="outline-danger">Delete</Button>{" "}
                </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </>
  );
};

export default Categories;
