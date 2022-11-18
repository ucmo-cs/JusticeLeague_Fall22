import React from 'react'
import {BsFillCalculatorFill,BsPencilSquare,BsCreditCard2Back, BsGraphUp,BsFillSuitHeartFill, BsCash,BsBank,BsFillInboxesFill,BsFillHouseFill} from "react-icons/bs";
import Button from 'react-bootstrap/Button';
import { AiFillCar } from "react-icons/ai";
import { GiGraduateCap } from "react-icons/gi";
import { TiGroupOutline } from "react-icons/ti";
import { VscGlobe} from "react-icons/vsc";
import {Navigate} from 'react-router-dom'
import Card from 'react-bootstrap/Card';

function Appt() {

const [goToMap, setToMap] =React.useState(false);
if(goToMap){
  return <Navigate to="/Map" /> 
}

  return (
    <div className='Ap'>
 

<p className="fs-1"  >About Time</p>      
<p  className="fs-5"><VscGlobe/> Presented by Commerce Bank member of FDIC </p>




<Card className='hello'style={{ width: '500px', height:'400px' }}>
 <Card.Body  >
             <>
    

      <Button width='30px' className='r'     onClick={() =>{setToMap(true);}} variant="flat" size="small">
    
      <BsCash />
        checking
      </Button>
       <Button    className='a'  onClick={() =>{setToMap(true);}} variant="flat" size="small">
       <BsFillInboxesFill /> saving account
      </Button>
       <Button  className='b'  onClick={() =>{setToMap(true);}}variant="flat" size="small">
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

      <Button  className='c' onClick={() =>{setToMap(true);}} variant="flat" size="small">
        <BsBank />  student banking
      </Button>
       <Button className='d' onClick={() =>{setToMap(true);}} variant="flat" size="small">
        <AiFillCar />auto loans 
      </Button>
       <Button className='e'  onClick={() =>{setToMap(true);}} variant="flat" size="small">
       <BsFillSuitHeartFill /> home equity
      </Button>
      <Button className='f'  onClick={() =>{setToMap(true);}}variant="flat" size="small">
           <BsFillHouseFill />  Mortgage </Button>
       <Button className='g'  onClick={() =>{setToMap(true);}} variant="flat" size="small">
       <GiGraduateCap/> student loans
      </Button>
       <Button  className='h'   onClick={() =>{setToMap(true);}} variant="flat" size="small">
       <TiGroupOutline />Saving for retirement
      </Button> 
       <Button  className='i'  onClick={() =>{setToMap(true);}}variant="flat" size="small">
       <BsGraphUp/> investment Account
      </Button>
       <Button  className='k'  onClick={() =>{setToMap(true);}} variant="flat" size="small">
        <BsCreditCard2Back /> credit cards
      </Button>
       <Button  className='l'  variant="flat" size="small">
       <BsPencilSquare/>  other
      </Button>
    </>
    </> 
   </Card.Body> 
     </Card>
 

    
    
        
       
      
      
    </div>
  )
}

export default Appt
