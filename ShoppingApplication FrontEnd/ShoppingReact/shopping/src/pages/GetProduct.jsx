import React, { useState, useEffect } from 'react';
import ProductServices from '../services/ProductServices';

function GetProduct({ fileName }) {
  const [imageData, setImageData] = useState(null);
  fileName="spider.png";

  useEffect(() => {
    async function fetchImageData() {
      try {
        const response = await ProductServices.getProduct(fileName);
        setImageData(response.data);
      } catch (error) {
        console.error(error);
      }
    }
    fetchImageData();
  }, [fileName]);

  const handleDownload = () => {
    const link = document.createElement('a');
    link.href = 'data:image/png;base64,' + imageData;
    link.download = fileName;
    link.click();
  };

  return (
    <div>
      {imageData && (
        <img src={'data:image/png;base64,' + imageData} alt={fileName} />
      )}
      <button onClick={handleDownload}>Download</button>
    </div>
  );
}

export default GetProduct;
