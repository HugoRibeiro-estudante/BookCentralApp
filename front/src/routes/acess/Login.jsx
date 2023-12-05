import React, { useState } from 'react';
import '../../assets/css/acess.css'
import { getAuth, signInWithEmailAndPassword, createUserWithEmailAndPassword } from "firebase/auth";
import { initializeApp } from "firebase/app";
import { useNavigate } from 'react-router-dom';
import { createContext } from 'react';


const firebaseConfig = {
//
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
        
      <div className='container'>
        <div>
          <h1>Login</h1>
          <form>
            <input type="text" placeholder='user' onChange={e => setEmail(e.target.value)} />
            <input type="password" placeholder='senha' onChange={e => setPassword(e.target.value)} />
            <input type="button" value="Entrar" onClick={handleSignIn} />
            <input type="button" value="Cadastrar" onClick={handleSignUp} />
          </form>
        </div>
        <div className='google'>
          <p>Acesse com a conta Google</p>
          <button>Acesse</button>
        </div>
      </div>
    </AuthContext.Provider>
  )
}