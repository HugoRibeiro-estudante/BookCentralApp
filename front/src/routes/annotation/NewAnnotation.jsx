import { useState, useEffect } from 'react'
import Button from '../../components/Button';


export default function NewAnnotation() {

    const [bookId, setBookId] = useState('');
    const [title, setTitle] = useState('');
    const [page, setPage] = useState('');
    const [body, setBody] = useState('');
    const [createDate, setCreateDate] = useState('');
    const [data, setData] = useState('');

    useEffect(() => {
        fetch("https://8080-debug-hugoribeiro-bookcentral-7abjfe7y8f1.ws-us106.gitpod.io/api/v1/annotation")
        .then(response => response.json())
        .then(data => console.log(data))
        .then(data => setData(data))
      },[])

    function createAnnotation() {
        event.preventDefault();
        fetch('https://8080-debug-hugoribeiro-bookcentral-7abjfe7y8f1.ws-us106.gitpod.io/api/v1/annotation', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                idBook: bookId,
                title: title,
                page: page,
                body: body,
                createDate: '2023-11-17'
                
            }),
        })
            .then(response => response.json())
            .then(data => console.log(data))
            .catch((error) => {
                console.error(error);
            });

    }



    return (

        <>
            <h1>Nova anotação</h1><form>
                <input type="text" placeholder="bookId" value={bookId} onChange={e => setBookId(e.target.value)} />
                <input type="text" placeholder="título" value={title} onChange={e => setTitle(e.target.value)} />
                <input type="text" placeholder="página" value={page} onChange={e => setPage(e.target.value)} />
                <textarea placeholder="body" value={body} onChange={e => setBody(e.target.value)} maxLength={300} cols={10} rows={20} />
                <input type="text" placeholder="data" value={createDate} onChange={e => setCreateDate(e.target.value)} />
                {/* <button onClick={createAnnotation}>Criar</button> */}
                <Button onclickFunction={createAnnotation} btnValue={'Criar anotação'} />
            </form>


        </>

    )
}