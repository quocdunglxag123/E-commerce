import Home from "../../components/home/Home";
import Login from "../../pages/home/login";
import Register from "../../pages/home/register";
import About from "../../pages/user/about";
import Cart from "../../pages/user/cart";
import Contact from "../../pages/user/contact";
import Homepage from "../../pages/user/home";
import Main from "../../pages/user/main";
import Product from "../../pages/user/product";

const userRouter = [
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/register",
    element: <Register />,
  },
  {
    role: "Role_user",
    path: "/*",
    element: <Main />,
    index: <Homepage />,
    children: [
      {
        path: "home",
        Component: Homepage,
      },
      {
        path: "product",
        Component: Product,
      },
      {
        path: "about",
        Component: About,
      },
      {
        path: "contact",
        Component: Contact,
      }
    ],
  },
];
export default userRouter;
