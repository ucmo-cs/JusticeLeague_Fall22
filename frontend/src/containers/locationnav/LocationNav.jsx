/*
*
*Location_Nav will be responsible for storing all of the location cards, and storing the search bar / filters
*
*/

/* Imports */
import React from "react";
import { LocationCard, NoLocation, Filter } from "../../components";
import { BsArrowReturnLeft } from "react-icons/bs";
import './locationnav.css';


/* Card */


const LocationNav = () => {
    return (
        <div className="box_locationnav-main">
            <div className="box_locationnav-header">
                <div className="box_locationnav-search"><BsArrowReturnLeft color="#89C143" size={20}/></div>
                <div className="box_locationnav-logo"></div>
                <div className="box_locationnav-filter"><Filter/></div>
                
            </div>
            <div className="box_locationnav-body">
                <NavBody/>
                
            </div>
        </div>
    )
}

const NavBody = () => {
    
    return(
        <div>
            <LocationCard/>
            <LocationCard/>
            <LocationCard/>
            
        </div>
         
      )
    
}

export default LocationNav
