import axios from "axios";
import React, { useState, useEffect } from "react";

function ImageViewer() {
  const [products, setProducts] = useState();

  useEffect(() => {
    axios
      .get("http://localhost:8081/product/data/spiderman.png")
      .then((response) => {
        setProducts(response.data.baseUrl);
        console.log(response.data);
      });
  }, []);

  return (
    <div>{<img src={`data:image/png;base64,${products}`} alt="hidsaaj" />}</div>
  );
}

export default ImageViewer;
