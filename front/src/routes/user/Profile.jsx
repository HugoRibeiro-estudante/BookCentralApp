import React, { useEffect, useState } from 'react'
import '../../assets/css/user.css'
import User from '../../assets/img/UserPhoto.png'
import { NavMenu } from '../../components/common/NavMenu';
import { Link } from 'react-router-dom';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';

export const Profile = () => {

    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true); // Adicione esta linha
    var userId = JSON.parse(localStorage.getItem("userData"));
    const navigate = useNavigate();

    useEffect(() => {

    fetch(`http://localhost:8080/api/v1/user/${userId.id}`)
    .then(response => response.json())
    .then(data => {
      console.log(data);
      setData(data);
      setLoading(false); // Agora esta linha não causará um erro
    });
    }, []);


  return (
    <div className='profileContainer'>
      <NavMenu activeChild={4}/>
      <div className='userInfo'>
        <img src={User} alt="" />
        <h1>{data.name}</h1>
        <p>{data.userName}</p>
      </div>
      <div className='profileBooks'>
        {data.books ? (data.books.map((book, index) => (
          <div className='book' key={index}>
            <img src={book.photo} alt="" />
              <h3>{book.title}</h3>
              <p>{book.authors}</p>
            <button onClick={() => navigate(`/annotationview`, { state: { bookId: book.id, title: book.title }})}>{'Ver anotações'+ book.id}</button>
          </div>
        ))) : null}
      </div>
    </div>
  )
}