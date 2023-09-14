import "./App.css";
import Home from "./components/home/Home";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Routes,
} from "react-router-dom";
import Login from "./components/auth/Login";
import Register from "./components/auth/Register";
import HomeAdmin from "./pages/admin/home";
import { privateRouter, publicRouter } from "./config/routes";

function App() {
  const role = "Role_Admin";
  return (
    <div>
      {/* <HomeAdmin /> */}

      <Routes>
        {publicRouter.map((routers) => {
          return routers.map((route, index) => {
            return (
              <Route path={route.path} element={route.element} key={index}>
                {route.index ? <Route index element={route.index} /> : null}
                {route.children
                  ? route.children.map(({ path, Component }, index) => {
                      return (
                        <Route
                          path={path}
                          element={<Component />}
                          key={index}
                        />
                      );
                    })
                  : null}
              </Route>
            );
          });
        })}
        {privateRouter.map((routers) => {
          return routers.map((route, index) => {
            return route.role === role || route.role === "Role_Admin" ? (
              <Route path={route.path} element={route.element} key={index}>
                {route.index ? <Route index element={route.index} /> : null}
                {route.children
                  ? route.children.map(({ path, Component }, index) => {
                      return (
                        <Route
                          path={path}
                          element={<Component />}
                          key={index}
                        />
                      );
                    })
                  : null}
              </Route>
            ) : null;
          });
        })}
      </Routes>
    </div>
  );
}

export default App;
