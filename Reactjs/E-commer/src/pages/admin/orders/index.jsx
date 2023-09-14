import "./styles.scss";
const Orders = () => {
  return (
    <>
      <h2>Order</h2>
      <div className="table-table pt-4">
        <table class="table ">
          <thead>
            <tr>
              <th scope="col">DATE</th>
              <th scope="col">PAID</th>
              <th scope="col">RECIPIENT</th>
              <th scope="col">PRODUCT</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">4/8/2023, 4:41:16 PM</th>
              <td className="text-danger">No</td>
              <td>
                Dawid Paszko <br /> dawid.paszko@gmail.com <br /> Stockholm
                12345 Sweden <br /> Test 123
              </td>
              <td>
                Xiaomi Redmi Note 11 x1 <br /> MSI Laptop LED x3 <br /> ASUS Rog
                Gaming <br /> Laptop x2
              </td>
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>Jacob</td>
              <td>Thornton</td>
              <td>@fat</td>
            </tr>
            <tr>
              <th scope="row">3</th>
              <td>Larry</td>
              <td>the Bird</td>
              <td>@twitter</td>
            </tr>
          </tbody>
        </table>
      </div>
    </>
  );
};

export default Orders;
