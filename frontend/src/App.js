import './App.css';
//import { Button } from 'react-bootstrap';
import React from 'react'

import Appt from './Pages/Appt';
import Dates from "./Pages/Dates"
import{ Route,Routes} from 'react-router-dom';
import Map from "./Pages/Map";


 //const testBackend = () => {
  //fetch("http://localhost:8080/Test", 
 // {
 //   method: "POST", 
  //  body: JSON.stringify("here is a test string")
 // })
 //.then(res => () => {
 //   console.log(res);
 // })
//}
//
function App() {
 
  



  return (
   
    <div className="App">


<Routes>
<Route path="/" element={<Appt />} />
<Route path="/Map" element={< Map />} />
<Route path="/Dates" element={<Dates />} />
</Routes> 

     
    
   
    
  
    </div>
  );
}

export default App;