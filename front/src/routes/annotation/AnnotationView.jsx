import { useState, useEffect } from 'react'

export default function AnnotationView(){

    const [data, setData] = useState([]);

    useEffect(() => {
        fetch("https://8080-debug-hugoribeiro-bookcentral-7abjfe7y8f1.ws-us106.gitpod.io/api/v1/annotation")
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
                    {item.body}
                </p>
            </div>
            
        ));
    }

    return(
        <>
            <div className="container">
                <h1>Anotações do livro : </h1>
                <div>
                    {render()}
                </div>
            </div>
        </>
    )
}
