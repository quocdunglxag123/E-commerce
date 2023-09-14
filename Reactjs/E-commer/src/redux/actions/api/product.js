import { internshipTransport } from "../../../config/http/transport";

const authenticate = {
  getAllproduct: () => {
    const url = `/product`;

    return internshipTransport.post(url);
  },
  getByIdProduct: (data) => {
    const url = `/product`;

    return internshipTransport.post(url, {
      serviceCall: "getById",
      id: data.id,
    });
  },
};

export default authenticate;
