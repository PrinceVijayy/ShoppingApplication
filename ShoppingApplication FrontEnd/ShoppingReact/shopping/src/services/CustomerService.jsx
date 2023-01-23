import axios from "axios";

const baseUrl="http://localhost:8081/customer"

class CustomerService{

    registerCustomer(customer){
        return axios.post(`${baseUrl}/create`,customer)
    }

}export default new CustomerService();