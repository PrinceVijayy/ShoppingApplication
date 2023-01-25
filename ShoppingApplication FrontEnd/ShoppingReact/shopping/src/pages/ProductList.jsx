import React from 'react'
import { useEffect } from 'react';
import { useState } from 'react'
import ProductServices from '../services/ProductServices'

const ProductList = () => {
    const[products,setProducts]=useState([]);
    useEffect(()=>{
        getAllProductsData();
    },[])
    const getAllProductsData=()=>{
        ProductServices.getAllProducts().then(res=>{
            setProducts(res.data)
            console.log(res);
        })
    }
    const handleAddToCart=()=>{
        alert("not yet implemented");
    }
  return (
    <div>
      <h1>Product List</h1>
      <div className="container-fluid">
        <div className="row">
          <div className="card-group">
            {products.map((product) => {
              return (
                <div className="col-3 mb-2" key={product.id}>
                  <div
                    className="card"
                    style={{ height: "32rem", width: "22rem" }}
                  >
                    <div className="card-header">
                      <p className="card-text">
                        <b>name :{product.name}</b>
                      </p>
                    </div>
                    <center>
                      <img
                        src={`data:image/png;base64,${product.image.imageInBase64}`}
                        className="card-img-top image-style"
                        alt={product.image.filename}
                        id="imagecard"
                      />
                    </center>
                    <div className="card-body">
                      <p className="card-title">
                        {" "}
                        <b>Price :</b>
                        {product.price}
                      </p>
                      {/* <p className="card-text"><b> Description :</b>{res.description}</p> */}
                    </div>
                    <div className="card-footer text-muted d-flex justify-content-between">
                      <p>
                        <b>Quantity :{product.quantity}</b>
                      </p>
                      <p className="card-text">
                        <b>Description :{product.description}</b>
                      </p>
                      <p>
                        <b>Category :{product.category}</b>
                      </p>
                    </div>
                    <button
                      onClick={() => handleAddToCart(product.id)}
                      className="btn btn-primary"
                      style={{ margin: "5px" }}
                    >
                      ADD TO CART
                    </button>
                  </div>
                </div>
              );
            })}
          </div>
        </div>
      </div>
    </div>
  )
}

export default ProductList
