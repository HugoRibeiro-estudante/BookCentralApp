import React, { useState, useEffect } from 'react';
import '../../assets/css/annotation.css';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

export default function AnnotationView() {
  const location = useLocation();
  const bookId = location?.state?.bookId || null;
  const bookTitle = location?.state?.title || null;
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true); // Adicionado o estado 'loading'
  const navigate = useNavigate();

  useEffect(() => {
    if (!bookId) {
      // Se o bookId não foi recebido, redirecione para /newbook
      navigate('/newbook');
      return;
    }

    fetch(`http://localhost:8080/api/v1/book/${bookId}`)
      .then(response => response.json())
      .then(data => {
        console.log(data);
        setData(data.annotations);
        setLoading(false); // Indica que os dados foram carregados
      });
  }, [bookId, navigate]);

  function render() {
    return data.map(item => (
      <div className='note' key={item.id}>
        <h3>{item.title}</h3>
        <p>{item.body}</p>
        <span className='page'>{item.page}</span>
      </div>
    ));
  }

  function redirect() {
    navigate('/newannotation', { state: { bookId: bookId, title: bookTitle } });
  }

  return (
    <>
      <div className='container'>
        <h1>Anotações do livro {bookTitle}: </h1>
        <p className='newAnnotation'>
          <a onClick={redirect}>Adicionar nova anotação</a>
        </p>

        <div className='noteContainer'>
          {loading ? 'Carregando...' : render()}
        </div>
      </div>
    </>
  );
}
 