import { Button } from "react-bootstrap";
import "./styles.scss";
const Admin = () => {
  return (
    <>
      <h2>Admin</h2>
      <div className="container-admin">
        <div className="addAmin">
          <h5>Add new admin</h5>
          <div className="input-group mb-3">
            <input
              type="text"
              className="form-control"
              aria-label="Recipient's username"
              aria-describedby="button-addon2"
              placeholder="google email"
            />
            <button
              className="btn btn-outline-secondary"
              type="button"
              id="button-addon2"
            >
              Add admin
            </button>
          </div>
          <div className="exitting">
            <table class="table ">
              <thead>
                <tr>
                  <th scope="col">ADMIN GOOGLE EMAIL</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">test@example.com</th>
                  <td>2023-04-06 15:55:51</td>
                  <td>
                    <div className="delete">
                      <Button variant="outline-danger">Delete</Button>{" "}
                    </div>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </>
  );
};

export default Admin;
