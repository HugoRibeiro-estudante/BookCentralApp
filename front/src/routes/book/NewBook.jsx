import React, { useState } from 'react';
import '../../assets/css/book.css';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';
import { NavMenu } from '../../components/common/NavMenu';
import Logo from '../../assets/img/LenouteLogo.png';

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
                        <Button onclickFunction={() => bookCreate(item.id, item.volumeInfo.title, authors, item.volumeInfo.pageCount, item.volumeInfo.imageLinks?.thumbnail, item.volumeInfo.categories)} btnValue={"Adicionar"}  bgColor={'#225A76'}/>
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
            InsertBookOnUser(data.id);
            navigate('/bookview', { state: { bookId: data.id, title: data.title, googleId: data.googleId } });

        })
        .catch((error) => {
            console.error('Erro:', error);
        });

          
    };

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
        <div>

            <NavMenu activeChild={1}/>

            <div>
                <img src={Logo} alt="" width={150}/>
                <h1>Escolha o livro:</h1>
                <input type="text" value={book} onChange={handleChange} id='searchBook'/>
                {/* <input type="button" value="Pesquisar" onClick={searchBook} id='searchButton'/> */}
                <Button onclickFunction={searchBook} btnValue={"Pesquisar"} bgColor={'#318EAD'}/>
            </div>
            <div className='bookContainer'>
                {displayData()}
            </div>
        </div>
    );

}
export default NewBook;
