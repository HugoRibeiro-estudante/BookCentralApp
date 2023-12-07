import React, { useState, useEffect } from 'react';
import '../../assets/css/book.css'
import Button from '../../components/Button';

function NewBook() {
    const [data, setData] = useState(null);
    const [book, setBook] = useState('');

    function searchBook(){
        const apiKey = '';
        const query = book;

        //preciso restringir a quantidade de resultados
        fetch(`https://www.googleapis.com/books/v1/volumes?q=${query}&langRestrict=pt&key=${apiKey}&maxResults=30`)
            .then(response => response.json())
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
                return (
                    <div key={index} className='book'>
                        {thumbnail && <img src={thumbnail} alt="Descrição da imagem"/>}
                        <h2>{item.volumeInfo.title}</h2>
                    </div>
                );
            });
        }
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
