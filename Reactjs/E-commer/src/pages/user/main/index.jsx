import { Outlet } from "react-router-dom";
import Header from "../../../components/header";
import Footer from "../../../components/footer";

const Main = () => {
  return (
    <>
      <Header />
      <div className="body-container">
        <Outlet />
      </div>
      <Footer />
    </>
  );
};

export default Main;
