import { useContext, useEffect} from 'react';
import { Route, Routes, Navigate, useNavigate } from 'react-router-dom';
import { AuthContext } from './Login'

function PrivateRoute({ path, element: Component }) {
    const { hasUser } = useContext(AuthContext);
    const navigate = useNavigate();
  
    useEffect(() => {
      if (!hasUser) {
        // Se o usuário não estiver autenticado, redirecionar para a página de login
        alert('hasUser false ' + hasUser);
        navigate('/login');
        
      }else{
        alert('hasUser true');
        return <Route path={path} element={<Component />} />;
      } 
    }, []);
  
  }
  
export default PrivateRoute;
  
