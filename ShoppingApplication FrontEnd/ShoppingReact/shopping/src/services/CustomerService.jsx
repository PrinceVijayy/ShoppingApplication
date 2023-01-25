import axios from "axios";

const baseUrl="http://192.168.2.145:8081/shopping/customer"

class CustomerService{

    registerCustomer(customer){
        return axios.post(`${baseUrl}/create`,customer)
    }

}export default new CustomerService();