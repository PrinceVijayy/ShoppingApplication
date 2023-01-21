import axios from "axios";
class ProductServices {
  createProduct(product){
    return axios.post('http://localhost:8081/api/create', product, {
      headers: {
          'Content-Type': 'multipart/form-data'
      }
  })
}
hello(){
    return axios.get("http://localhost:8081/api/hello")
}
}
export default new ProductServices();