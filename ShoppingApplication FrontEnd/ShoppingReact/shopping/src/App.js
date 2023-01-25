import "./App.css";
import CreateProduct from "./pages/CreateProduct";
import GetProduct from "./pages/GetProduct";
import RegistorCustomer from "./pages/RegistorCustomer";

import 'bootstrap/dist/css/bootstrap.min.css';
import ProductList from "./pages/ProductList";
function App() {
  return (
    <div className="App">
      {/* <CreateProduct /> */}
      {/* <GetProduct /> */}
      {/* <RegistorCustomer /> */}
      <ProductList />
    </div>
  );
}

export default App;
