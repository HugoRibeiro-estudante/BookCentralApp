import React, { useState, useEffect } from 'react';
import DOMPurify from 'dompurify';
import '../../assets/css/annotation.css';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { NavMenu } from '../../components/common/NavMenu';
import MyModal from '../../components/common/MyModal';

export default function AnnotationView() {
  const location = useLocation();
  const bookId = location?.state?.bookId || null;
  const bookTitle = location?.state?.title || null;
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();
  const [modalShow, setModalShow] = useState(false); // Changed from React.useState to useState
  const [selectedNote, setSelectedNote] = useState(null);

  useEffect(() => {
    fetch(`https://bookcentralapp-production.up.railway.app/api/v1/book/${bookId}`)
      .then(response => response.json())
      .then(data => {
        setData(data.annotations);
        setLoading(false);
      });
  }, [bookId]);

  function render() {
    return data.map(item => (
      <div className='note' key={item.id} onClick={() => {
        setSelectedNote(item);
        setModalShow(true);
      }}>
        <h3>{item.title}</h3>
        {/* Use DOMPurify.sanitize to sanitize the HTML */}
        <p dangerouslySetInnerHTML={{ __html: DOMPurify.sanitize(item.body.substring(0, 30) + (item.body.length > 20 ? '...' : '')) }} />
        <span className='page'>{item.page}</span>
      </div>
    ));
  }

  function redirect() {
    navigate('/newannotation', { state: { bookId: bookId, title: bookTitle } });
  }

  return (
    <div>
      <div className='container'>
        <NavMenu activeChild={1}/>
        <h1>Anotações do livro {bookTitle}: </h1>
        <p className='newAnnotation'>
          <a onClick={redirect}>Adicionar nova anotação</a>
        </p>

        <div className='noteContainer'>
          {loading ? 'Carregando...' : render()}
        </div>
      </div>

      {modalShow && (
        <MyModal
          show={modalShow}
          onHide={() => setModalShow(false)}
          note={selectedNote}
          fullscreen={true}
          title={selectedNote?.title}
          body={selectedNote?.body}
          page={selectedNote?.page}
          
        />
      )}
    </div>
  );
}
