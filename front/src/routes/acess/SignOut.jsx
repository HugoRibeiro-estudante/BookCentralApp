import { auth } from "../../firebase";
import {signOut } from "firebase/auth";
import { useNavigate } from 'react-router-dom';

export default function SignOut() {
    const navigate = useNavigate();
    const handleSignOut = async () => {
        try {
        await signOut(auth);
        alert('Usuário deslogado com sucesso!');
        navigate("/login");
        } catch (error) {
        alert(error.message);
        }
    };
    return (
        <div>
        <h1>Deslogar</h1>
        <button onClick={handleSignOut}>Deslogar</button>
        </div>
    );
    }