import axios from "axios";
class ProductServices {
  createProduct(product) {
    return axios.post("http://localhost:8081/api/product/create", product);
  }
  getProduct(fileName) {
    return axios.get(`http://localhost:8081/api/product/view/${fileName}`);
  }
}
export default new ProductServices();
