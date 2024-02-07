import React from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import DOMPurify from 'dompurify';


export default function MyModal(props) {
  const handleClose = () => {
    props.onHide();
  };

  const deleteAnnotation = () => {
    fetch(`https://bookcentralapp-production.up.railway.app/api/v1/annotation/${props.id}`, {
      method: 'DELETE',
    })
      .then(response => {
        if (response.ok) {
          // A requisição foi bem-sucedida
          console.log('Anotação deletada com sucesso');
        } else {
          // A requisição falhou
          console.log('Falha ao deletar anotação');
        }
      })
      .catch(error => {
        console.log('Erro ao fazer a requisição DELETE:', error);
      });
  };

  return (
    <Modal {...props} size="lg" centered>
      <Modal.Header closeButton>
        <Modal.Title id="contained-modal-title-vcenter">
          Anotação
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <h4>{props.title}</h4>
        <div dangerouslySetInnerHTML={{ __html: DOMPurify.sanitize(props.body) }}></div>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="outline-dark" onClick={handleClose}>
          Editar
        </Button>
        <Button variant="outline-danger" onClick={deleteAnnotation}>Deletar</Button>
      </Modal.Footer>
    </Modal>
  );
}
