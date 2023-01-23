import React, { useState } from "react";
import CustomerService from "../services/CustomerService";

const RegistorCustomer = () => {
  const [status, setStatus] = useState();
  const[firstName,setFirstName]=useState();
  const[lastName,setLastName]=useState();
  const [dateOfBirth,setDateOfBirth]=useState();
  const [email,setEmail]=useState();
  const [phoneNumber,setPhoneNumber]=useState();
  const [address,setAddress]=useState();
  const[password,setPassword]=useState();
 
  const handleSubmit=(e)=>{
    e.preventDefault();
    let customer ={
        firstName: firstName,
        lastName: lastName,
        dateOfBirth: dateOfBirth,
        email: email,
        phoneNumber: phoneNumber,
        address: address,
        password: password
    }
    console.log(customer);
    CustomerService.registerCustomer(customer).then((res) => {
        setStatus(res.data.status);
      });
  }
  return (
    <div>
      <div class="container mt-3">
        <h1>{status}</h1>
        <form>
          <div class="row jumbotron box8">
            <div class="col-sm-12 mx-t3 mb-4">
              <h2 class="text-center text-info">Register</h2>
            </div>
            <div class="col-sm-6 form-group">
              <label for="name-f">First Name</label>
              <input
                type="text"
                class="form-control"
                onChange={e=>{setFirstName(e.target.value)}}
                name="firstName"
                id="name-f"
                placeholder="Enter your first name."
                required
              />
            </div>
            <div class="col-sm-6 form-group">
              <label for="name-l">Last name</label>
              <input
                type="text"
                class="form-control"
                onChange={e=>{setLastName(e.target.value)}}
                name="lastName"
                id="name-l"
                placeholder="Enter your last name."
                required
              />
            </div>
            <div class="col-sm-6 form-group">
              <label for="email">Email</label>
              <input
                type="email"
                class="form-control"
                onChange={e=>{setEmail(e.target.value)}}
                name="email"
                id="email"
                placeholder="Enter your email."
                required
              />
            </div>
            <div class="col-sm-6 form-group">
              <label for="address-1">Address</label>
              <input
                type="address"
                class="form-control"
                onChange={e=>{setAddress(e.target.value)}}
                name="address"
                id="address"
                placeholder="Locality/House/Street no."
                required
              />
            </div>
            <div class="col-sm-6 form-group">
              <label for="Date">Date Of Birth</label>
              <input
                type="Date"
                name="dateOfBirth"
                class="form-control"
                onChange={e=>{setDateOfBirth(e.target.value)}}
                id="Date"
                placeholder=""
                required
              />
            </div>
            <div class="col-sm-4 form-group">
              <label for="tel">Phone</label>
              <input
                type="text"
                name="phoneNumber"
                class="form-control"
                onChange={e=>{setPhoneNumber(e.target.value)}}
                id="tel"
                placeholder="Enter Your Contact Number."
                required
              />
            </div>
            <div class="col-sm-6 form-group">
              <label for="pass">Password</label>
              <input
                type="Password"
                name="password"
                class="form-control"
                onChange={e=>{setPassword(e.target.value)}}
                id="pass"
                placeholder="Enter your password."
                required
              />
            </div>
            {/* <div class="col-sm-6 form-group">
              <label for="pass2">Confirm Password</label>
              <input
                type="Password"
                name="cnf-password"
                class="form-control"
                id="pass2"
                placeholder="Re-enter your password."
                required
              />
            </div> */}

            <div
              class="col-sm-12 form-group mt-3 mb-0"
              style={{ textAlign: "center" }}
            >
              <button
                onClick={handleSubmit}
                class="btn btn-primary float-right"
              >
                Submit
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
};

export default RegistorCustomer;
