import React, { useState } from "react";
import ProductServices from "../services/ProductServices";

function CreateProduct() {
  const [file, setFile] = useState(null);
  const [productModel, setProductModel] = useState({
    name: "",
    price: 0.0,
    quantity: 0,
    description: "",
    category:""
  });

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleProductModelChange = (e) => {
    setProductModel({
      ...productModel,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData();
    formData.append("file", file);
    formData.append("product", JSON.stringify(productModel));
    ProductServices.createProduct(formData).then((res) => {
        console.log(res);
        alert("Product created successfully!");
      })
      .catch((err) => {
        console.log(err);
        alert("An error occurred while creating the product.");
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="file" onChange={handleFileChange} />
      <input
        type="text"
        name="name"
        value={productModel.name}
        onChange={handleProductModelChange}
        placeholder="Product Name"
      />
      <input
        type="number"
        name="price"
        value={productModel.price}
        onChange={handleProductModelChange}
        placeholder="Product Price"
      />
      <input
        type="number"
        name="quantity"
        value={productModel.quantity}
        onChange={handleProductModelChange}
        placeholder="Product Quantity"
      />
      <input
        type="text"
        name="description"
        value={productModel.description}
        onChange={handleProductModelChange}
        placeholder="Product Description"
      />
       <input
        type="text"
        name="category"
        value={productModel.category}
        onChange={handleProductModelChange}
        placeholder="Product Category"
      />
      <button type="submit">Create Product</button>
    </form>
  );
}

export default CreateProduct;
