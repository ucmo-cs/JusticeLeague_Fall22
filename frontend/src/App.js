import logo from './logo.svg';
import './App.css';
import { Button } from 'react-bootstrap';
import React from 'react';
import { LocationNav, AppointmentContain } from './containers';
import { Locationcard } from './components';
import FilterContain from './containers/filtercontain/FilterContain';

const App = () =>{
  return(
    <div className='App_Main'>
      {/**<header>Search</header>*/}
      
      {/** <AppointmentContain />*/}
      <div>
        <LocationNav />
      </div>
      
      
      
    </div>
  )
}



export default App;
