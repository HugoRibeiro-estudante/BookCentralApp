import { useRef, useState } from 'react';
import Button from '../../components/Button';
import { useLocation, useNavigate } from 'react-router-dom';
import { NavMenu } from '../../components/common/NavMenu';
import JoditEditor from "jodit-react";

export default function NewAnnotation() {
  const location = useLocation();
  const bookId = location?.state?.bookId || null;
  const bookTitle = location?.state?.title || null;
  const [title, setTitle] = useState('');
  const [page, setPage] = useState('');
  const [body, setBody] = useState('');

  const editor = useRef(null);
  const config = {
    readonly: false,
    height: 500,
  };

  const navigate = useNavigate();

  function createAnnotation() {
    const bookObject = { id: parseInt(bookId, 10) };
    alert(`id:${bookObject.id} tit:${title} pag:${page} corpo:${body}`);
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
        navigate('/annotationview', { state: { bookId: bookId, title: bookTitle } });
      })
      .catch((error) => {
        console.error(error);
      });
  }

  return (
    <div>
      <NavMenu activeChild={1} />
      <div className='annotationTitle'>
        <h1>Nova anotação no livro {bookTitle}</h1>
        <img src="https://picsum.photos/200/300" alt="capa do livro" />
      </div>
      <form onSubmit={(e) => e.preventDefault()} className='newAnnotation'>
        <input type="number" placeholder="página" value={page} onChange={e => setPage(e.target.value)} />
        <input type="text" placeholder="título" value={title} onChange={e => setTitle(e.target.value)} />
        <JoditEditor ref={editor} value={body} config={config} onBlur={(newContent) => setBody(newContent)} />
        <Button onclickFunction={createAnnotation} btnValue={'Criar anotação'} />
      </form>
    </div>
  );
}
