import React, { useState, useCallback } from 'react';
import '../../assets/css/acess.css'
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';
import { auth } from "../../firebase";
import { signInWithEmailAndPassword } from "firebase/auth";
import Logo from '../../assets/img/LenouteLogo.png';
import { Link } from 'react-router-dom';
import { Verify } from '../user/Verify';



const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [response, setResponse] = useState('');
  const navigate = useNavigate();

  const handleLogin = useCallback(async () => {
    try {
      const userCredential = await signInWithEmailAndPassword(auth, email, password);
      console.log(userCredential);
      if(Verify(email)){
        alert('Login bem-sucedido!');
        navigate("/home");
      }else{
        alert('Email não cadastrado!');
        setResponse('Email não cadastrado!');
      }
    } catch (error) {
      alert(error.message);
    }
  }, [auth, email, password, navigate]);

  

  return (
      <div className='containerLogin'>

        <img src={Logo} alt="Logo"/>
        <p>Bem-vindo de volta !</p>
        <h1>Entre em sua conta</h1>
        <div className='form'>
          <label>Email: </label>
          <input type="text" value={email} onChange={(e) => setEmail(e.target.value)} />
          <br />
          <label>Password: </label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
          <br />
          <Button onclickFunction={handleLogin} btnValue={"Entrar"} bgColor={"#225A76"}/>
          {/* <Button onclickFunction={handleSignUp} btnValue={"Cadastrar"} bgColor={"gray"}/> */}
        </div>
        <i>{response}</i>
        <p>Ainda não se cadastrou ? </p>
        <Link to="/register">Clique aqui</Link>
      </div>
  );
};

export default Login;
