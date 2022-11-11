import logo from './logo.svg';
import './App.css';
import { Button } from 'react-bootstrap';
import React from 'react';
import { LocationNav, AppointmentContain } from './containers';
import { Locationcard } from './components';

const testBackend = () => {
  fetch("http://localhost:8080/Test", 
  {
    method: "POST", 
    body: JSON.stringify("here is a test string")
  })
  .then(res => () => {
    console.log(res);
  })
}

const App = () =>{
  return(
    <div>
      <header>Search</header>
      
      {/** <AppointmentContain />*/}
      
      <LocationNav />
      
    </div>
  )
}

/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Hello Gilgamesh Team
        </p>
        <Button variant="warning" onClick={testBackend}>Test Backend Connection</Button>
        <LocationNav />
      </header>
      
    </div>
  );
}
*/
export default App;
