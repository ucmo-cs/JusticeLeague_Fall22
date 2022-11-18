import React from 'react'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

import 'mdb-react-ui-kit/dist/css/mdb.min.css';
import "@fortawesome/fontawesome-free/css/all.min.css";
import { MDBInputGroup, MDBInput, MDBIcon, MDBBtn } from 'mdb-react-ui-kit';
import { Navigate } from 'react-router-dom';




export default function map() {

 const [goToDates, setToDates] =React.useState(false);
if(goToDates){
  return <Navigate to="/Dates" /> 
}







  return (
      <p>    
    
    <div>
      <iframe title='myFrame'width="2000" height="1000" id="gmap_canvas" src="https://maps.google.com/maps?q=kansas%20city&t=k&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe>
    
  <Card style={{ width: '18rem' }}>
     
      <Card.Body className='cc'>
        <Card.Title>About Time</Card.Title>
         <MDBInputGroup className='true' >
      <MDBInput label='Search location' />
      <MDBBtn rippleColor='dark'>
        <MDBIcon icon='search' />
      </MDBBtn>
    </MDBInputGroup>
        <Card.Text>

        </Card.Text>
        <Button className='j' onClick={() =>{setToDates(true);}}variant="primary">Schedule Appointment</Button>
      </Card.Body>
    </Card>



    </div>
    
    
    
    </p>
   
  )
}
