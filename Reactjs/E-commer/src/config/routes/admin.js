import Home from "../../components/home/Home";
import Admin from "../../pages/admin/admins";
import Categories from "../../pages/admin/categories";
import Dashboard from "../../pages/admin/dashboard";
import HomeAdmin from "../../pages/admin/home";
import Orders from "../../pages/admin/orders";
import Products from "../../pages/admin/product";
import EditProduct from "../../pages/admin/product/editProduct";
import Settings from "../../pages/admin/settings";

const adminRouter = [
  {
    role: "Role_Admin",
    path: "/admin",
    element: <HomeAdmin />,
    index: <Dashboard />,
    children: [
      {
        path: "",
        Component: Dashboard,
      },
      {
        path: "admin",
        Component: Admin,
      },
      {
        path: "categories",
        Component: Categories,
      },
      {
        path: "orders",
        Component: Orders,
      },
      {
        path: "product",
        Component: Products,
      },
      {
        path: "setting",
        Component: Settings,
      },
      {
        path: "product/eidtproduct",
        Component: EditProduct,
      },
      {
        path: "*",
        Component: Dashboard,
      },
    ],
  },
];
export default adminRouter;
