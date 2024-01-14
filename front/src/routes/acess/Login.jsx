import React, { useState, useCallback } from 'react';
import { initializeApp } from 'firebase/app';
import { getAuth, signInWithEmailAndPassword, createUserWithEmailAndPassword} from 'firebase/auth';
import '../../assets/css/acess.css'
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
import { auth } from "../../firebase";
import Logo from '../../assets/img/LenouteLogo.png';



const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = useCallback(async () => {
    try {
      const userCredential = await signInWithEmailAndPassword(auth, email, password);
      console.log(userCredential);
      alert('Login bem-sucedido!');
      navigate("/home");
    } catch (error) {
      alert(error.message);
    }
  }, [auth, email, password, navigate]);
  

  const handleSignUp = async () => {
    try {
      await createUserWithEmailAndPassword(auth, email, password);
      alert('Usuário criado com sucesso!');
      navigate("/home");
    } catch (error) {
      alert(error.message);
    }
  };

  return (
      <div className='containerLogin'>

        <img src={Logo} alt="Logo" />
        <h1>Entre em sua conta</h1>
        <div className='form'>
          <label>Email: </label>
          <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} />
          <br />
          <label>Password: </label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
          <br />
          <Button onclickFunction={handleLogin} btnValue={"Logar"} bgColor={"#225A76"}/>
          {/* <Button onclickFunction={handleSignUp} btnValue={"Cadastrar"} bgColor={"gray"}/> */}

        </div>
      </div>
  );
};

export default Login;
