import React, { useState, useEffect } from 'react';
import '../../assets/css/book.css'

function NewBook() {
    const [data, setData] = useState(null);
    const [book, setBook] = useState('');

    function searchBook(){
        const apiKey = 'AIzaSyAruxhWnaiLkB0Z8nqvyTLLSMtYBkhO7sU';
        const query = book;

        //preciso restringir a quantidade de resultados
        fetch(`https://www.googleapis.com/books/v1/volumes?q=${query}&langRestrict=pt&key=${apiKey}`)
            .then(response => response.json())
            .then(data => setData(data.items))
            .catch(error => console.error('Error:', error));
    }

    const handleChange = (event) => {
        setBook(event.target.value);
    };

    const displayData = () => {
        if (data) {
            return data.map((item, index) => (
                <div key={index} className='book'>
                    <img src={item.volumeInfo.imageLinks.thumbnail} alt="Descrição da imagem"/>
                    <h2>{item.volumeInfo.title}</h2>
                </div>
            ));
        }

    };

    return (
        <div>
            <div>
                <h1>Escolha o livro:</h1>
                <input type="text" value={book} onChange={handleChange}/>
                <input type="button" value="Pesquisar" onClick={searchBook} />
            </div>
            <div className='bookContainer'>
                {displayData()}
            </div>
        </div>
    );

}
export default NewBook;
