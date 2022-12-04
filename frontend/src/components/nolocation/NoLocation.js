import {RiFlagLine} from "react-icons/ri";
import './nolocation.css';
 
<RiFlagLine color="#89C143" size={50}/>
/** Created by Philipp Rojas-Zdjelar */

const NoLocation = () => {
    return(
        <div className="Parent">
            
            <div className="Image" >
            <RiFlagLine className="icon" color="#89C143" size={50}/>
            </div>
            <div className="Title">
            <p>No Locations Have Been Found</p>
            </div>
        </div>
        
    )
}

export default NoLocation
