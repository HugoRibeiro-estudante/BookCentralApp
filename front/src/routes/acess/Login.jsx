import React, { useState } from 'react';
import Button from '../../components/Button';
import { getAuth, signInWithEmailAndPassword, createUserWithEmailAndPassword } from "firebase/auth";
import { initializeApp } from "firebase/app";
import { useNavigate } from 'react-router-dom';
import { createContext } from 'react';
import '../../assets/css/acess.css'

const firebaseConfig = {

};

// Contexto controla o estado da autenticação
export const AuthContext = createContext({
  hasUser: false,
  setUser: estado => {
  setHasUser = estado;
  },
});

const app = initializeApp(firebaseConfig);
const auth = getAuth();


export default function Login(){
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [hasUser, setHasUser] = useState(true);
  const navigate = useNavigate();

  const handleSignUp = async () => {
    try {
      await createUserWithEmailAndPassword(auth, email, password);
      alert('Usuário criado com sucesso!');
      setUser(true);
      navigate("/home");
    } catch (error) {
      alert(error.message);
    }
  };

  const handleSignIn = async () => {
    try {
      await signInWithEmailAndPassword(auth, email, password);
      alert('Usuário autenticado com sucesso!');
      setUser(true);
      alert('teste com'+ hasUser);
      navigate("/home");
    } catch (error) {
      alert(error.message);
    }
  };

  return(
    <AuthContext.Provider value={{ hasUser, setUser: setHasUser }}>
        
      <div className='containerLogin'>
        <div>
          <h1>Login</h1>
          <form>
            <input type="text" placeholder='user' onChange={e => setEmail(e.target.value)} />
            <input type="password" placeholder='senha' onChange={e => setPassword(e.target.value)} />
            {/* <input type="button" value="Entrar" onClick={handleSignIn} />
            <input type="button" value="Cadastrar" onClick={handleSignUp} /> */}
            <div className='buttons'>
              <Button onclickFunction={handleSignIn} btnValue={"Entrar"}/>
              <Button onclickFunction={handleSignUp} btnValue={"Cadastrar"} bgColor={"gray"}/>
            </div>
          </form>
        </div>
        <div className='google'>
          <p>Acesse com a conta Google</p>
          <a href='#'>
            <img src="data:image/png;base64,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" alt="" />
          </a>
        </div>
      </div>
    </AuthContext.Provider>
  )
}