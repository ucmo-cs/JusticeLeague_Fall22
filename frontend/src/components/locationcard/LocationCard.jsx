/*
*
*Location card will be responsible for handling Branch name, Location, Operating hours, etc.
*Will need to be updated from a database and the amount of cards display will correspond
*to the Locations that can help with the particular appointment type
*
*/

/* Imports */
import React from "react";
import './locationcard.css';
import { BsMap } from "react-icons/bs";
import { Button } from "react-bootstrap";
import { NoLocation } from "../../components";
import { AppointmentContain } from "../../containers";
import { useState } from "react";

/** Created by Philipp Rojas-Zdjelar */

/* Card */
const LocationCard = () =>{
    const[show, setShow] = useState(false);
    const handleChange=()=>{
        setShow(!show);
    }
    return(
        <div className="card_content"> {/*Rect1*/}
            <div className="card_content-info">
                <p className="card_content-info-title">Commerce Bank</p>
                <p>1234 Fake St.</p>
                <p>Warrensburg,MO 64098</p>
                <p>Open | 7:00am - 6:00pm</p>
                
                
            </div>
            
            <div className="card_content-icon">
                <BsMap color="#89C143" size={40}/>
            </div>
            <div className="card_schedule" >
                <Button type="button" className="card_schedule-button" onClick={handleChange}>Schedule Appointment</Button>
            </div>
            
        </div>
    )
}





export default LocationCard
