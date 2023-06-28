import { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [user, setUser] = useState('');

  useEffect(() => {
    fetch('http://localhost:8080/api/v1/user')
      .then(response => response.json())
      .then(data => {
        console.log(data); // Aqui você pode acessar a resposta (data) retornada pela API
        setUser(data);
      })
      .catch(error => {
        console.error('Erro na requisição:', error);
      });
  }, []);

  return (
    <div className="App">
      {user && <h1>oi {user[0].name}</h1>}
    </div>
  );
}

export default App;
