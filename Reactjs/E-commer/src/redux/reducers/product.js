import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  productName: "",
  category: "",
  color: [],
  storage: [],
  photo: "",
  decscription: "",
  price: "",
};

export const productSlice = createSlice({
  name: "counter",
  initialState,
  reducers: {
    updateProduct: (state = initialState, action) => {
      state.productName = action?.payload;
      state.category = action?.payload?.category;
      state.color = action.payload;
      state.storage = action.payload;
      state.photo = action.payload;
      state.decscription = action.payload;
      state.price = action.payload;
    },
  },
});

// Action creators are generated for each case reducer function
export const { updateProduct } = productSlice.actions;

export default productSlice.reducer;

export const addProduct = (data) => {
  return {
    type: "productList/addProduct",
    payload: data,
  };
};
