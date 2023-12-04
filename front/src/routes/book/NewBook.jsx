import React, { useState, useEffect } from 'react';

function App() {
    const [data, setData] = useState(null);
    const [bookSearch, setBookSearch] = useState('');

    useEffect(() => {
        const apiKey = 'AIzaSyAruxhWnaiLkB0Z8nqvyTLLSMtYBkhO7sU';
        const query = 'flowers for algernon';

        fetch(`https://www.googleapis.com/books/v1/volumes?q=${query}&key=${apiKey}`)
            .then(response => response.json())
            .then(data => setData(data.items))
            .catch(error => console.error('Error:', error));
    }, []);

    const handleChange = (event) => {
        setValor(event.target.value);
    };

    const displayData = () => {
        if (data) {
            return data.map((item, index) => (
                <div key={index}>
                    <h2>{item.volumeInfo.title}</h2>
                    <p>{item.volumeInfo.title}</p>
                    <img src={item.volumeInfo.imageLinks.thumbnail} alt="Descrição da imagem"/>

                </div>
            ));
        } else {
            return <div>Loading...</div>;
        }
    };

    return (
        <div>
            <div>
                <h2>Escolha o livro:</h2>
                <input type="text" value={bookSearch} onChange={handleChange}/>
                <input type="button" value="Pesquisar" />
            </div>
            <div>
                {displayData()}
            </div>
        </div>
    );
}

export default App;
