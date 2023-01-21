import React from 'react'
import { useState } from 'react';
import ProductServices from '../services/ProductServices';

const Hello = () => {
    const [hello,setHello]=useState();
    const handleButton=()=>{
        ProductServices.hello().then(res=>{
                setHello(res.data)
        });
    }
  return (
    <div>
      <button onClick={handleButton}>submit</button>
      {hello}
    </div>
  )
}

export default Hello
