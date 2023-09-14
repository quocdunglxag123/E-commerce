import React from "react";
import { Formik } from "formik";
import "bootstrap/dist/css/bootstrap.css";

const Register = () => {
  const [form, setForm] = React.useState({});

  const handleValidate = (values) => {
    let errors = {};
    if (!values.email) {
      errors.email = "Required";
    }
    if (!values.password) {
      errors.password = "Required";
    }
    return errors;
  };

  const handleSubmit = () => {
    const isValid =
      form.username && form.email && form.password && form.confirmPassword;
    alert(
      isValid ? "Register success!!!" : "Please fill out all the fields!!!"
    );
  };
  return (
    <>
      <Formik
        initialValues={{
          email: "",
          password: "",
        }}
        validate={handleValidate}
        onSubmit={handleSubmit}
      >
        {({ values, errors, handleChange, handleSubmit }) => (
          <form onSubmit={handleSubmit}>
            <div className="container d-flex justify-content-center align-items-center min-vh-100">
              <div className="row border rounded-5 p-3 bg-white shadow box-area">
                <div
                  className="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" 
                  style={{backgroundColor: "#25A0D5"}}
                >
                  <div className="featured-image mb-3">
                    <img src="/img/logo.svg" alt="Loginuser" />;
                  </div>
                  <p className="text-white fs-2">Shofy E-commerce</p>
                  <small className="text-white text-wrap text-center">
                    The most popular e-commerce platform in Vietnam
                  </small>
                </div>

                <div className="col-md-6 right-box">
                  <div className="row align-items-center">
                    <div className="header-text mb-4">
                      <h2>Register</h2>
                      <p>Thanks for your registry</p>
                    </div>
                    <div className="input-group mb-3">
                            <input type="text" className="form-control form-control-lg bg-light fs-6" placeholder="Email address" />
                            {errors.email && <span className="error">{errors.email}</span>}
                        </div>
                        <div className="input-group mb-1">
                            <input type="password" className="form-control form-control-lg bg-light fs-6" placeholder="Password" />
                            {errors.password && <span className="error">{errors.password}</span>}
                        </div>
                    {/* <div className="input-group mb-5 d-flex justify-content-between">
                      <div className="forgot">
                        <small>
                          <a href="#">
                            Do you already have an account? <span>Login</span>
                          </a>
                        </small>
                      </div>
                    </div> */}
                    <div className="input-group mb-3">
                      <button className="btn btn-lg btn-primary w-100 fs-6">
                        Register
                      </button>
                    </div>
                    <div className="input-group mb-3">
                      <button className="btn btn-lg btn-light w-100 fs-6">
                        <small>Sign In with Google</small>
                      </button>
                    </div>
                    <div className="row">
                      <small>
                      Do you already have an account? <a href="/">Login</a>
                      </small>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </form>
        )}
      </Formik>
    </>
  );
};

export default Register;
