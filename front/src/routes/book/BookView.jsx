import { useState, useEffect } from 'react'

export default function BookView(){

    const [data, setData] = useState([]);

    useEffect(() => {
        fetch("https://8080-debug-hugoribeiro-bookcentral-7abjfe7y8f1.ws-us106.gitpod.io/api/v1/book",{
            method: 'GET',
            credentials: 'include'
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            setData(data);
        })
    },[])

    function render(){
        return data.map((item, index) =>(
            <div>
                <h3 key={index}>
                    {item.title}
                </h3>
                <p>
                    {item.autor}
                </p>
            </div>
            
        ));
    }

    return(
        <>
            <div className="container">
                <h1>Meus livros</h1>
                <div>
                    {render()}
                </div>
            </div>
        </>
    )
}
