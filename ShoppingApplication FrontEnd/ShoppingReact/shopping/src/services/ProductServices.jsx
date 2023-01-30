import axios from "axios";
const baseUrl="http://localhost:8081/shopping/product"
class ProductServices {
  getAllProducts(){
    return axios.get(baseUrl+"/list");
  }
  createProduct(product) {
    return axios.post(baseUrl+"/create", product);
  }
  getProduct(fileName) {
    return axios.get(`${baseUrl}/view/${fileName}`);
  }
}
export default new ProductServices();
