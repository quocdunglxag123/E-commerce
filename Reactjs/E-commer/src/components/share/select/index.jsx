const Customselect = ({
  className,
  label,
  register,
  id,
  backgroundColor,
  width,
  requirementField = true,
}) => {
  return (
    <>
      <div
        className={`custom-input ${className ? className : ""}     `}
        style={{ width: width ? width : "100%" }}
      >
        <label htmlFor={id} className="custom-input__label">
          {label ? label : ""}
        </label>
        <div>
          <select
            class="form-select"
            aria-describedby="basic-addon1"
            aria-label="Default select example"
            id={id}
            {...register(id)}
            style={{
              backgroundColor: backgroundColor ? backgroundColor : " ",
            }}
          >
            <option selected>No parent category</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
          </select>
        </div>
      </div>
    </>
  );
};

export default Customselect;
