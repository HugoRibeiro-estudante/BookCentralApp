import { useState, useEffect } from 'react';
import { Navigate } from 'react-router-dom';
import { onAuthStateChanged } from 'firebase/auth';
import { auth } from '../../firebase';

function PrivateRoute({ element: Component }) {
  const [authUser, setAuthUser] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const unsubscribe = onAuthStateChanged(auth, (user) => {
      setAuthUser(user);
      setIsLoading(false);
    });

    return () => unsubscribe(); // Cleanup function to unsubscribe
  }, []);

  if (isLoading) {
    // Renderize um componente de carregamento enquanto a verificação de autenticação está em andamento
    return <div>Carregando...</div>;
  }

  return authUser ? Component : <Navigate to="/login" />;
}

export default PrivateRoute;