import { API_DOMAIN } from "../constant/httpConstant";
import httpHandler from "./axios";

function get(domain, url, config = {}) {
  return httpHandler(domain).get(`${url}`, config);
}

function post(domain, url, data, config = {}) {
  return httpHandler(domain).post(`${url}`, data, config);
}

function put(domain, url, data, config = {}) {
  return httpHandler(domain).put(`${url}`, data, config);
}

function del(domain, url, config = {}) {
  return httpHandler(domain).delete(`${url}`, config);
}

export const internshipTransport = {
  get: (url, config = {}) => {
    return get(API_DOMAIN.INTERNSHIP, url, config);
  },
  post: (url, data, config = {}) => {
    return post(API_DOMAIN.INTERNSHIP, url, data, config);
  },
  put: (url, data, config = {}) => {
    return put(API_DOMAIN.INTERNSHIP, url, data, config);
  },
  delete: (url, config = {}) => {
    return del(API_DOMAIN.INTERNSHIP, url, config);
  },
};
