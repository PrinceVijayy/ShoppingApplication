import "./App.css";
import CreateProduct from "./pages/CreateProduct";
import GetProduct from "./pages/GetProduct";
import RegistorCustomer from "./pages/RegistorCustomer";
import "bootstrap/dist/css/bootstrap.min.css";
import ProductList from "./pages/ProductList";

import AdminProductList from "./pages/AdminProductList";
import Login from "./pages/Login";
import Navbar from "./components/nav-bar/Navbar";

function App() {
  return (
    <div className="App">
      {/* <CreateProduct /> */}
      {/* <GetProduct /> */}
      {/* <RegistorCustomer /> */}
      {/* <ProductList /> */}
      {/* <Login /> */}
      {/* <AdminProductList /> */}
      <Navbar />
    </div>
  );
}

export default App;
