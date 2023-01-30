import "./App.css";
import CreateProduct from "./pages/CreateProduct";
import GetProduct from "./pages/GetProduct";
import RegistorCustomer from "./pages/RegistorCustomer";

import 'bootstrap/dist/css/bootstrap.min.css';
import ProductList from "./pages/ProductList";
import AdminProductList from "./pages/AdminProductList";
function App() {
  return (
    <div className="App">
      {/* <CreateProduct /> */}
      {/* <GetProduct /> */}
      {/* <RegistorCustomer /> */}
      {/* <ProductList /> */}
      <AdminProductList />
    </div>
  );
}

export default App;
