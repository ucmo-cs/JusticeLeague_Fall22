/*
*
*Location_Nav will be responsible for storing all of the location cards, and storing the search bar / filters
*
*/

/* Imports */

import React from "react";
import { useState } from 'react'
import { Button } from "react-bootstrap";
import { LocationCard, NoLocation } from "../../components";
import './appointmentcontain.css';


/* Card */



const AppointmentContain = () => {
    return(
        <div className="box_appointment">
            
            <Button className="toggler">V</Button>
            <div className="box_appointment-main">

            </div>
            <div className="box_appointment-back"></div>
        </div>
    )
}



export default AppointmentContain