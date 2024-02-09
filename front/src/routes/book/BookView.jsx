import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import { NavMenu } from '../../components/common/NavMenu';
import DOMPurify from 'dompurify';
import { useNavigate } from 'react-router-dom';

export default function BookView() {
    const location = useLocation();
    const googleId = location?.state?.googleId || null;
    const [data, setData] = useState(null);
    const [annotations, setAnnotations] = useState(null);
    const apiKey = 'AIzaSyAyBhV6L_wwTd9ni-sBiQwriApsjvzVqnQ';
    const navigate = useNavigate(); 

    useEffect(() => {
        if (googleId) {
            fetch(`https://www.googleapis.com/books/v1/volumes/${googleId}?langRestrict=pt&key=${apiKey}`)
                .then(response => response.json())
                .then(data => {
                    console.log(data);
                    setData(data);
                })
                .catch(error => {
                    console.error(error);
                    setData([]);
                });
        }
    }, [googleId, apiKey]);

    function getAnnotations() {
        fetch(`https://bookcentralapp-production.up.railway.app/api/v1/book/filterByPublic/${googleId}`)
            .then(response => response.json())
            .then(data => {
                console.log(data)
                setAnnotations(data);
                console.log(annotations)
            })
            .catch(error => console.error('Error:', error));
    }

    function bookCreate() {
        const requestData = {
            googleId: data.id,
            title: data.volumeInfo.title,
            authors: data.volumeInfo.authors || [],
            numberPages: data.volumeInfo.pageCount,
            status: "LENDO",
            privacy: "PRIVADO",
            photo: /*data.volumeInfo.imageLinks?.thumbnail*/ null,
            categories: data.volumeInfo.categories || [],
        };

        alert(data.id + " - " + data.volumeInfo.title + " - " + data.volumeInfo.authors + " - " + data.volumeInfo.pageCount + " - " + data.volumeInfo.imageLinks?.thumbnail + " - " + data.volumeInfo.categories)
        console.log (JSON.stringify(requestData));
        fetch("https://bookcentralapp-production.up.railway.app/api/v1/book", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(requestData),
        })
            .then(response => response.json())
            .then(response => {
                InsertBookOnUser(response.id);
                navigate('/bookview', { state: { bookId: data.id, title: data.title, googleId: data.googleId } });
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }

    function InsertBookOnUser(bookId){

        var userId = JSON.parse(localStorage.getItem("userData"));
        userId = userId.id;

        alert(userId + " - " + bookId);
        fetch(`https://bookcentralapp-production.up.railway.app/api/v1/user/${userId}/book/${bookId}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            
        })
            .then(response => response.ok ? response.json() : Promise.reject(`Erro na solicitação: ${response.status}`))
            .then(data => console.log('Solicitação PUT bem-sucedida:', data))
            .catch(error => console.error('Erro na solicitação PUT:', error.message));

    }

    return (
        <div className="container">
            <NavMenu activeChild={1}/>
            <h1>Meus livros</h1>
            {data && (
                <div>
                    <h1>{data.volumeInfo.title}</h1>
                    <img src={data.volumeInfo.imageLinks?.thumbnail} alt="Descrição da imagem" />
                </div>
            )}
            <div>
                <Button variant="dark" onClick={bookCreate}>Adicionar livro</Button>
                {/* <Button btnValue={"Ler Anotações publicas"} onClick={getAnnotations} /> */}
                <button onClick={getAnnotations}>Ler Anotações publicas</button>
            </div>
            <div>
                <h2>Resumo</h2>
                <div dangerouslySetInnerHTML={{ __html: DOMPurify.sanitize(data?.volumeInfo.description) }} className='description'></div>
            </div>
            <div>
                <h2>Anotações</h2>
                {annotations && (
                    <div className='publics'>
                        {annotations.map(annotation => (
                            <div key={annotation.id}>
                                <h1>{annotation.users[0].name}</h1>
                                <p>{annotation.description}</p>
                                <a style={{'display': 'flex', 'justifyContent': 'center', 'color': '#621579'}} onClick={()=> navigate('/annotationview', { state: { bookId: annotation.id, title: annotation.title, googleId: data.googleId } })}>ver</a>
                            </div>
                        ))}
                    </div>
                )}
            </div>
        </div>
    );
}
