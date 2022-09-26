import logo from './logo.svg';
import './App.css';
import { Button } from 'react-bootstrap';

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

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Hello Gilgamesh Team
        </p>
        <Button variant="warning" onClick={testBackend}>Test Backend Connection</Button>
      </header>
    </div>
  );
}

export default App;
