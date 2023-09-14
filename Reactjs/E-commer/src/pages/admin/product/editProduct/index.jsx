import { useForm } from "react-hook-form";
import CustomInput from "../../../../components/share/input";
import { Button } from "react-bootstrap";
import logo from "../../../../components/assets/img/avt.jpg";
import "./styles.scss";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import UploadAndDisplayImage from "../../../../components/share/inputFile";
import { useDispatch } from "react-redux";
import { updateProduct } from "../../../../redux/reducers/product";
import { v4 as uuidv4 } from "uuid";
const EditProduct = () => {
  const { register, handleSubmit } = useForm();
  const dispatch = useDispatch();
  const [image, setImage] = useState(null);
  const onsubmit = (data) => {
    const dataSubmit = {
      id: uuidv4(),
      productName: data.namePD,
      category: data.category,
      color: data.color,
      storage: data.storage,
      descripton: data.descripton,
      pricePD: data.pricePD,
    };
    console.log(dataSubmit);
    dispatch(updateProduct(dataSubmit));
  };
  console.log(logo);
  const navigate = useNavigate();
  return (
    <>
      <div className="editproduct-container mt-3">
        <h2>Edit product</h2>
        <form action="">
          <div className="input-group mb-3">
            <CustomInput id="namePD" label="Product name" register={register} />
          </div>
          <div className="input-group mb-3 d-flex flex-column">
            <div className="label">
              <label htmlFor="">Category</label>
            </div>
            <select
              class="form-select"
              aria-label="Default select example"
              style={{ width: "100%" }}
              {...register("category")}
            >
              <option selected>Open this select menu</option>
              <option value="Iphones">Iphones</option>
              <option value="Androis">Androis</option>
            </select>
          </div>
          <div className="input-group mb-3 d-flex flex-column">
            <div className="label">
              <label htmlFor="">Color</label>
            </div>
            <select
              class="form-select"
              aria-label="Default select example"
              style={{ width: "100%" }}
              {...register("color")}
            >
              <option selected>Open this select menu</option>
              <option value="Black">Black</option>
              <option value="White">White</option>
            </select>
          </div>

          <div className="input-group mb-3 d-flex flex-column">
            <div className="label">
              <label htmlFor="">Storage (GB)</label>
            </div>
            <select
              class="form-select"
              aria-label="Default select example"
              style={{ width: "100%" }}
              {...register("storage")}
            >
              <option selected>Open this select menu</option>
              <option value="1">64GB</option>
              <option value="2">128Gb</option>
              <option value="3">256GB</option>
            </select>
          </div>
          <div className="input-group mb-3 d-flex flex-column">
            <UploadAndDisplayImage />
          </div>
          <div className="input-group mb-3 d-flex flex-column">
            <div className="label">
              <label htmlFor="">Description</label>
            </div>
            <textarea
              class="form-control"
              id="exampleFormControlTextarea1"
              rows="3"
              style={{ width: "100%" }}
              {...register("descripton")}
            ></textarea>
          </div>

          <div className="input-group mb-3">
            <CustomInput
              id="pricePD"
              label="Price (in USD)"
              register={register}
            />
          </div>
          <button
            type="button"
            class="btn btn-primary me-2"
            onClick={handleSubmit(onsubmit)}
          >
            Save
          </button>
          <button
            type="button"
            class="btn btn-primary"
            onClick={() => navigate("/admin/product")}
          >
            back
          </button>
        </form>
      </div>
    </>
  );
};

export default EditProduct;
