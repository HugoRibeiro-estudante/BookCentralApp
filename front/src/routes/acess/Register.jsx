import React, { useState } from 'react';
import Logo from '../../assets/img/LenouteLogo.png';
import { Link } from 'react-router-dom';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';
import { auth } from "../../firebase";
import { createUserWithEmailAndPassword } from "firebase/auth";

export default function Register(){

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [name, setName] = useState('');
    const [birthDate, setBirthDate] = useState('');
    const [userName, setUserName] = useState('');
    const navigate = useNavigate();

    const handleSignUp = async () => {
      try {
        const userCredential = await createUserWithEmailAndPassword(auth, email, password);

        try {
          const response = await fetch('https://bookcentralapp-production.up.railway.app/api/v1/user', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify({
              name: name,
              userName: userName,
              email: email,
              birthDate: birthDate
            }),
          });

          if (!response.ok) {
            throw new Error(`Erro na solicitação: ${response.status}`);
          }


          const data = await response.json();
          console.log('Solicitação bem-sucedida:', data);
          // Save user data in local storage
          localStorage.setItem('userData', JSON.stringify({
            id: data.id,
            name: name,
            userName: userName,
            email: email,
            birthDate: birthDate
          }));

          alert('Usuário criado com sucesso!');
          navigate("/home");


        } catch (error) {
          console.error('Erro na solicitação:', error.message);
          // Faça algo com o erro, se necessário
        }

      } catch (error) {
        alert(error.message);
      }
    };

    return (
        <div className='containerLogin'>
  
          <img src={Logo} alt="Logo" />
          <h1>Cadastre-se</h1>
          <div className='form'>
            <label>Nome completo: </label>
            <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
            <label>Email: </label>
            <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} />
            <label>Nome de usuário: </label>
            <input type="text" value={userName} onChange={(e) => setUserName(e.target.value)} />
            <label>Idade: </label>
            <input type="date" value={birthDate} onChange={(e) => setBirthDate(e.target.value)} />
            <label>Password: </label>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <Button onclickFunction={handleSignUp} btnValue={"Cadastrar"} bgColor={"#225A76"}/>
          </div>
          <p>Já tem uma conta? </p>
          <Link to="/login">Clique aqui</Link>
        </div>
    );
}