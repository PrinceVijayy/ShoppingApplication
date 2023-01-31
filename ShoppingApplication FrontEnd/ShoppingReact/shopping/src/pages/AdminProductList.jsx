import React, { useEffect, useState } from "react";
import MUIDataTable from "mui-datatables";
import ProductServices from "../services/ProductServices";

const AdminProductList = () => {
  const [products, setProducts] = useState([]);
  const columns = [
    "Name",
    "Price",
    "Quantity",
    "Description",
    "Category",
    "Image",
    "Action",
  ];

  useEffect(() => {
    getAllProductsData();
  }, []);
  const getAllProductsData = () => {
    ProductServices.getAllProducts().then((res) => {
      setProducts(res.data);
      console.log(res);
    });
  };
  const data = products.map((product) => {
    return [
      product.name,
      product.price,
      product.quantity,
      product.description,
      product.category,
      <img
        style={{ width: "150px" , height :"130px"}}
        src={`data:image/png;base64,${product.image.imageInBase64}`}
        className="card-img-top image-style"
        alt={product.image.filename}
        id="imagecard"
      />,
      [
        <button
          className="btn btn-secondary"
          style={{ "margin-right": "10px" }}
        >
          Edit
        </button>,
        <button className="btn btn-primary" style={{ "margin-right": "10px" }}>
          View
        </button>,
        <button className="btn btn-danger">Delete</button>,
      ],
    ];
  });

  const options = {
    filterType: "checkbox",
    // rowsPerPage:[3],
    // rowsPerPageOptions:[1,3,5,6],
    // jumpToPage: true,
    // textLabels:{
    //   pagination: {
    //     next: "Next >",
    //     previous: "< Previous",
    //     rowsPerPage: "Total items Per Page",
    //     displayRows: "OF"
    //   }
    // }
  };

  return (
    <div className="App wrapper">
      <h4 style={{ textAlign: "center" }} className="mt-3">
        React MUI Datatable{" "}
      </h4>
      <div className="container mt-5">
        <MUIDataTable
          title={"Product List"}
          data={data}
          columns={columns}
          options={options}
        />
      </div>
    </div>
  );
};

export default AdminProductList;
