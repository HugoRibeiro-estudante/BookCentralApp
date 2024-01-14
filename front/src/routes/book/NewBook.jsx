import React, { useState } from 'react';
import '../../assets/css/book.css';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';

function NewBook() {
    const navigate = useNavigate();
    const [data, setData] = useState(null);
    const [book, setBook] = useState('');

    function searchBook(){
        const apiKey = 'AIzaSyAruxhWnaiLkB0Z8nqvyTLLSMtYBkhO7sU';
        const query = book;

        //preciso restringir a quantidade de resultados
        fetch(`https://www.googleapis.com/books/v1/volumes?q=${query}&langRestrict=pt&key=${apiKey}&maxResults=16`)
            .then(response => response.json())
            //.then(data => console.log(data.items))
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
                        <h2>{item.volumeInfo.title}</h2>
                        <h3>{authors.join(', ')}</h3>
                        <h3>{item.volumeInfo.pageCount}</h3>
                        <Button onclickFunction={() => bookCreate(item.id, item.volumeInfo.title, authors, item.volumeInfo.pageCount, item.volumeInfo.categories)} btnValue={"Adicionar"} />
                    </div>
                );
            });
        }
    };
    

    const bookCreate = (id, title, authors, countPages, categories) => {
        const requestData = {
            googleId: id,
            title: title,
            authors: authors,
            numberPages: countPages,
            categories: categories,
        };
    
        fetch("http://localhost:8080/api/v1/book", {
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
            console.log('Dentro do segundo bloco .then');
            console.log(data);

            navigate('/newannotation', { state: { bookId: data.id, title: data.title } });

        })
        .catch((error) => {
            console.error('Erro:', error);
        });


          
    };
    

    return (
        <div>
            <div>
                <h1>Escolha o livro:</h1>
                <input type="text" value={book} onChange={handleChange} id='searchBook'/>
                {/* <input type="button" value="Pesquisar" onClick={searchBook} id='searchButton'/> */}
                <Button onclickFunction={searchBook} btnValue={"Pesquisar"}/>
            </div>
            <div className='bookContainer'>
                {displayData()}
            </div>
        </div>
    );

}
export default NewBook;
