import React, { useState } from 'react';
import '../../assets/css/book.css';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';
import { NavMenu } from '../../components/common/NavMenu';
import Logo from '../../assets/img/LenouteLogo.png';

function NewBook() {
    const navigate = useNavigate();
    const [data, setData] = useState(null);
    const [book, setBook] = useState('');

    function searchBook(){
        const apiKey = 'AIzaSyAyBhV6L_wwTd9ni-sBiQwriApsjvzVqnQ';
        const query = book;

        //preciso restringir a quantidade de resultados
        fetch(`https://www.googleapis.com/books/v1/volumes?q=${query}&langRestrict=pt&key=${apiKey}&maxResults=16`)
            .then(response => response.json())
            // .then(data => console.log(data))
            .then(data => setData(data.items))
            .catch(error => console.error('Error:', error));

    }

    const handleChange = (event) => {
        setBook(event.target.value);
    };

    const displayData = () => {
        if (data) {
            return data.map((item, index) => {
                const thumbnail = item.volumeInfo.imageLinks?.thumbnail;
                const authors = item.volumeInfo.authors || [];
                const categories = item.volumeInfo.categories || []; // Certifique-se de que categories não seja nulo
                return (
                    <div key={index} className='book'>
                        {thumbnail && <img src={thumbnail} alt="Descrição da imagem" />}
                        <h3>{item.volumeInfo.title}</h3>
                        <p>{authors.join(', ')}</p>
                        <Button variant="dark" onClick={() => navigate('/bookview', {state: {googleId: item.id}})}>Ver</Button>
                    </div>
                );
            });
        }
    };
    

    const bookCreate = (id, title, authors, countPages, photo,categories) => {
        const requestData = {
            googleId: id,
            title: title,
            authors: authors,
            numberPages: countPages,
            status: "LENDO",
            privacy: "PRIVADO",
            photo: photo,
            categories: categories,
        };
            

        fetch("https://bookcentralapp-production.up.railway.app/api/v1/book", {
            method: 'POST',
            credentials: 'include',
            headers: {
                'Content-Type': 'application/json',  
            },
            body: JSON.stringify(requestData),
        })
        .then(response => {
            console.log('Dentro do bloco .then');
            return response.json();
        })
        .then(data => {

            console.log(data);


        })
        .catch((error) => {
            console.error('Erro:', error);
        });

          
    };


    

    return (
        <div>

            <NavMenu activeChild={1}/>

            <div>
                <img src={Logo} alt="" width={150}/>
                <h1>Escolha o livro:</h1>
                <input type="text" value={book} onChange={handleChange} id='searchBook'/>
                {/* <input type="button" value="Pesquisar" onClick={searchBook} id='searchButton'/> */}
                <Button variant='dark' onClick={searchBook}>Pesquisar</Button>
            </div>
            <div className='bookContainer'>
                {displayData()}
            </div>
        </div>
    );

}
export default NewBook;
