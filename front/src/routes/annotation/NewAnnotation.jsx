import { useState } from 'react';
import Button from '../../components/Button';
import { useLocation, useNavigate } from 'react-router-dom';

export default function NewAnnotation() {
  const location = useLocation();
  const bookId = location?.state?.bookId || null;
  const bookTitle = location?.state?.title || null;
  const [title, setTitle] = useState('');
  const [page, setPage] = useState('');
  const [body, setBody] = useState('');

  const navigate = useNavigate();

  function createAnnotation() {

    const bookObject = { id: parseInt(bookId, 10) };

    fetch('http://localhost:8080/api/v1/annotation', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        book: bookObject,
        title: title,
        page: page,
        body: body,
      }),
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        // Faça o que for necessário após o POST (por exemplo, navegar para outra página)
        navigate('/annotationview', { state: { bookId: bookId,  title: bookTitle} });
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <>
      <h1>Nova anotação no livro {bookTitle}</h1>
      <form onSubmit={(e) => e.preventDefault()}>
        <input type="text" placeholder="título" value={title} onChange={e => setTitle(e.target.value)} />
        <input type="text" placeholder="página" value={page} onChange={e => setPage(e.target.value)} />
        <textarea placeholder="body" value={body} onChange={e => setBody(e.target.value)} maxLength={300} cols={10} rows={20} />
        <Button onclickFunction={createAnnotation} btnValue={'Criar anotação'} />
      </form>
    </>
  );
}
