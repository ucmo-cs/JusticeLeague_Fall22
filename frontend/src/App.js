import logo from './logo.svg';
import './App.css';
import { Button } from 'react-bootstrap';
import React from 'react';
import { LocationNav, AppointmentContain } from './containers';
import { Locationcard } from './components';

const App = () =>{
  return(
    <div>
      {/**<header>Search</header>*/}
      
      {/** <AppointmentContain />*/}
      
      <LocationNav />
      
    </div>
  )
}

export default App;
