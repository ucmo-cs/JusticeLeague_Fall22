import React from "react";
import './filter.css';
import { BsFilterRight } from "react-icons/bs";
import { Button } from "react-bootstrap";
import {useState} from 'react'
import { FilterContain } from "../../containers";

/** Created by Philipp Rojas-Zdjelar */

const Filters = (  ) => {
    const[show, setShow] = useState(false);
    const handleChange=()=>{
        setShow(!show);
    }
    return(
        <div className="filter_box">
            <Button onClick={handleChange} className="filter_box-icon">
                <BsFilterRight size={30}/>  
            </Button>
            <div>
                {show ? (<FilterContain toggle={handleChange}></FilterContain>) : null}
            </div>
        </div>
    )
}

export default Filters