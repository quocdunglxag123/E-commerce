import { applyMiddleware, combineReducers, compose, createStore } from "redux";
import authreducer from "./reducers/AuthReducer";
import thunk from "redux-thunk";
import authErrorReducer from "./reducers/AuthErrorReducer";
import { configureStore } from "@reduxjs/toolkit";
import { productSlice } from "./reducers/product";

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

// const rootReducer = combineReducers({
//   authState: authreducer,
//   authError: authErrorReducer,
// });

// const store = createStore(
//   rootReducer,
//   composeEnhancers(applyMiddleware(thunk))
// );
const store = configureStore({
  reducer: { product: productSlice.reducer },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: false,
    }),
});
export default store;
