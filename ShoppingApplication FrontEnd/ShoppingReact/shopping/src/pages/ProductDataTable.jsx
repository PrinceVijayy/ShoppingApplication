import React, { useEffect, useState } from "react";
import MUIDataTable from "mui-datatables";

import ProductServices from "../services/ProductServices";

const ProductDataTable = () => {
  const [products, setProducts] = useState([]);

  const columns = [
    {
      name: "Name",
      selector: "name",
      sortable: true,
    },
    {
      name: "Price",
      selector: "price",
      sortable: true,
    },
    {
      name: "Quantity",
      selector: "quantity",
      sortable: true,
    },
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
  return (
    <MUIDataTable
      columns={columns}
      data={products}
      pagination
      subHeader
      persistTableHead
    />
  );
};

export default ProductDataTable;
