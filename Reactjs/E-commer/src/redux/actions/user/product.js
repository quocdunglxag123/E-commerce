import { createAsyncThunk } from "@reduxjs/toolkit";
import authenticate from "../api/product";

const { getAllproduct, getByIdProduct } = authenticate;

export const getAllproductThunk = createAsyncThunk(
  "authenticate/getAllproduct",
  async () => {
    try {
      const res = await getAllproduct();
      return res;
    } catch (error) {
      return error;
    }
  }
);
export const getByIdProductThunk = createAsyncThunk(
  "authenticate/getAllproduct",
  async (data) => {
    try {
      const res = await getByIdProduct(data);
      return res;
    } catch (error) {
      return error;
    }
  }
);
