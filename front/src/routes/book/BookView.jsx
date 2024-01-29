import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import Button from '../../components/Button';
import { NavMenu } from '../../components/common/NavMenu';
import DOMPurify from 'dompurify';
import { useNavigate } from 'react-router-dom';

export default function BookView() {
    const location = useLocation();
    const googleId = location?.state?.googleId || null;
    const [data, setData] = useState(null);
    const [annotations, setAnnotations] = useState(null);
    const apiKey = 'AIzaSyAruxhWnaiLkB0Z8nqvyTLLSMtYBkhO7sU';
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
                <Button btnValue={"Anotar"} bgColor={'#225A76'} onClick={() => {navigate('/bookview', { state: { bookId: data.id, title: data.title, googleId: data.googleId } });}}/>
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
