import './App.css';
//import { Button } from 'react-bootstrap';
import React from 'react'
import {BsFillCalculatorFill,BsPencilSquare,BsCreditCard2Back, BsGraphUp,BsFillSuitHeartFill, BsCash,BsBank,BsFillInboxesFill,BsFillHouseFill} from "react-icons/bs";
import Button from 'react-bootstrap/Button';

import { AiFillCar } from "react-icons/ai";
import { GiGraduateCap } from "react-icons/gi";
import { TiGroupOutline } from "react-icons/ti";
import Card from 'react-bootstrap/Card';
import { VscGlobe} from "react-icons/vsc";




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
      <header  className="App-header">
     
    
     
       <p  className="fs-1" >About Time</p>      
      <p  className="fs-5"><VscGlobe/> Presented by Commerce Bank member of FDIC </p>
   
    <div
    
    className='cursor'
    
    />
       <div className='yes'> 
    
    
    <Card className='w-50' alignment='mid'>
      <Card.Header >Select an option below to set up an appointment </Card.Header>
     
      <Card.Body>
     

             <>
      <style type="text/css">
        {`
    .btn-flat {
      background-color: purple;
      color: white;
    }
    .btn-small {
      padding: 1rem 1.5rem;
      font-size: 1.5rem;
    }
   
    `}
      </style>

      <Button variant="flat" size="small">
      <BsCash />
        checking
      </Button>
       <Button variant="flat" size="small">
       <BsFillInboxesFill /> saving account
      </Button>
       <Button variant="flat" size="small">
       <BsFillCalculatorFill/>cds/money accounts
      </Button>
        <>
      <style type="text/css">
        {`
    .btn-flat {
      background-color: #FFFFFF;
      color: grey;
      
      
    }
    .btn-xxl {
      padding: 1rem 1.5rem;
      font-size: 1.5rem;
       
    }
    `}
      </style>

      <Button variant="flat" size="small">
        <BsBank />  student banking
      </Button>
       <Button variant="flat" size="small">
        <AiFillCar />auto loans 
      </Button>
       <Button variant="flat" size="small">
       <BsFillSuitHeartFill /> home equity
      </Button>
      <Button variant="flat" size="small">
           <BsFillHouseFill />  Mortgage </Button>
       <Button variant="flat" size="small">
       <GiGraduateCap/> student loans
      </Button>
       <Button variant="flat" size="small">
       <TiGroupOutline />Saving for retirement
      </Button> 
       <Button variant="flat" size="small">
       <BsGraphUp/> investment Account
      </Button>
       <Button variant="flat" size="small">
        <BsCreditCard2Back /> credit cards
      </Button>
       <Button variant="flat" size="small">
       <BsPencilSquare/>  other
      </Button>
    </>
    </> 
      </Card.Body>
    </Card>
       
     
 

    
    
        
       
      
  </div>
        


  




    </header>
    </div>
  );
}

export default App;