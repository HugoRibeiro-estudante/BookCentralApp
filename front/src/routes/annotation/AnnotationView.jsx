import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import '../../assets/css/annotation.css'

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
            <div className='note'>
                <h3 key={index}>
                    {item.title}
                </h3>
                <p>
                    {item.body}
                </p>
              
                <span className='page'>
                    {item.page}
                </span>
            </div>
            
        ));
        // return(
        //     <div className='note'>
        //         <h3>
        //             título da anotação
        //         </h3>
        //         <p>
        //             Aqui é a anotação em si ............
        //         </p>
        //    </div>
        // )
    }

    return(
        <>
            <div className="container">
                <h1>Anotações do livro : </h1>
                <p className='newAnnotation'>
                    <Link to="/newannotation">Adicionar nova anotação</Link>
                </p>

                <div className='noteContainer'>
                    {render()}
                    {render()}
                    {render()}
                    {render()}
                    {render()}
                    {render()}
              
                </div>
            </div>
        </>
    )
}
