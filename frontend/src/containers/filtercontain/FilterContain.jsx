import React from "react";
import { useState } from 'react'
import { Button } from "react-bootstrap";
import { LocationCard, NoLocation, Filter } from "../../components";
import './filtercontain.css';
import {LocationNav} from "../../containers"


/** Created by Philipp Rojas-Zdjelar */
const FilterContain = () => {
    const[show, setShow] = useState(false);
    const handleChange=()=>{
        setShow(!show);
    }
    return(
        <div className="FilterContain_Box">
            <div className="FilterContain_Box-Title">Appointment Types:</div>
            <div className="FilterContain_Box-Options">
                <Button class="Appointment_Button" type="Button" name="Test">Checking Account</Button>
                <Button class="Appointment_Button" type="Button" name="Test">Savings Account</Button>
                <Button class="Appointment_Button" type="Button">CD/Money Account</Button>
                <Button class="Appointment_Button" type="Button">Student Banking</Button>
                <Button class="Appointment_Button" type="Button">Auto Loans</Button>
                <Button class="Appointment_Button" type="Button">Home Equity</Button>
                <Button class="Appointment_Button" type="Button">Mortgage</Button>
                <Button class="Appointment_Button" type="Button">Savings Account</Button>
                <Button class="Appointment_Button" type="Button">Student Loans</Button>
                <Button class="Appointment_Button" type="Button">Savings Account</Button>
                <Button class="Appointment_Button" type="Button">Retirement</Button>
                <Button class="Appointment_Button" type="Button">Investment Account</Button>
                <Button class="Appointment_Button" type="Button">Credit Card</Button>




            </div>
            
        </div>
    )
}

export default FilterContain