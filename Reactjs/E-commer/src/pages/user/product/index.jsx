import { AiOutlineHeart, AiOutlineShoppingCart, AiOutlineCloseCircle} from "react-icons/ai";
import Productdetail from "./productDetail";
import { BsEye } from "react-icons/bs";
import "./styles.scss";
import { useDispatch } from "react-redux";
import {
  getAllproductThunk,
  getByIdProductThunk,
} from "../../../redux/actions/user/product";
const Product = ({product, setProduct, detail, view, close, setClose, addtocart}) => {
  const dispatch = useDispatch();
  dispatch(getAllproductThunk()).then((res) => {
    if (res.status === 200) {
      console.log("thanhcong");
    } else {
      console.log("that bai");
    }
  });
  const data = { id: "1" };
  dispatch(getByIdProductThunk(data.id)).then((res) => console.log(res));

  const filtterproduct = (product) => {
    const update = Productdetail.filter((x) =>
    {
      return x.Cat === product;
    })
    setProduct(update);
  }
  const AllProducts = () =>{ setProduct(Productdetail)  }
  return (
    <>
    {
      close ?
      <div className='product_detail'>
        <div className='container'>
            <button onClick={() => setClose(false)} className='closebtn'><AiOutlineCloseCircle /></button>
            {
                detail.map((curElm) => 
                {
                    return(
                        <div className='productbox'>
                            <div className='img-box'>
                                <img src={curElm.Img} alt={curElm.Title}></img>
                            </div>
                            <div className='detail'>
                                <h4>{curElm.Cat}</h4>
                                <h2>{curElm.Title}</h2>
                                <p>A Screen Everyone Will Love: Whether your family is streaming or video chatting with friends tablet A8... </p>
                                <h3>{curElm.Price}</h3>
                                <button>Add To Cart</button>
                            </div>
                        </div>
                    )
                })
            }
            <div className='productbox'></div>
        </div>
      </div> : null
    }
      <div className="products">
        <h3># Product</h3>
        <p>Home . product</p>
        <div className="container">
          <div className="filter">
            <div className="categories">
              <h3>categories</h3>
              <ul>
                <li onClick={() => AllProducts ()}>All Products</li>
                <li onClick={() => filtterproduct ("Tablet")}>Tablet</li>
                <li onClick={() => filtterproduct ("Smart Watch")}>Smart Watch</li>
                <li onClick={() => filtterproduct ("Headphone")}>Headphone</li>
                <li onClick={() => filtterproduct ("Camera")}>Camera</li>
                <li onClick={() => filtterproduct ("Gaming")}>Gaming</li>
              </ul>
            </div>
          </div>
          <div className="productbox">
            <div className="contant">
              {Productdetail.map((curElm) => {
                return (
                  <>
                    <div className="box" key={curElm.id}>
                      <div className="img_box">
                        <img src={curElm.Img} alt={curElm.Title} />
                        <div className="icon">
                          <li onClick={() => addtocart (curElm)}>
                            <AiOutlineShoppingCart />
                          </li>
                          <li onClick={() => view (curElm)}>
                            <BsEye />
                          </li>
                          <li >
                            <AiOutlineHeart />
                          </li>
                        </div>
                      </div>
                      <div className="detail">
                        <p>{curElm.Cat}</p>
                        <h3>{curElm.Title}</h3>
                        <h4>${curElm.Price}</h4>
                      </div>
                    </div>
                  </>
                );
              })}
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Product;
