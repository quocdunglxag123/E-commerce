import { useForm } from "react-hook-form";
import Customselect from "../../../components/share/select";
import CustomInput from "../../../components/share/input";
import { Button } from "react-bootstrap";

const Settings = () => {
  const { register, handleSubmit } = useForm();
  return (
    <>
      <h2>Settings</h2>
      <div className="container-setting">
        <form action="">
          <div className="custom-input">
            <Customselect
              register={register}
              id="featured_product"
              label={"Featured product"}
            />
          </div>
          <div className="custom-input">
            <CustomInput
              id={"shipping"}
              register={register}
              label={"Shipping price (in usd)"}
            />
          </div>
          <Button variant="outline-secondary">Save settings</Button>{" "}
        </form>
      </div>
    </>
  );
};

export default Settings;
