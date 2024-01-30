import React from 'react';
import Home from '../../assets/img/Home.png';
import User from '../../assets/img/User.png';
import Book from '../../assets/img/Book.png';
import Rank from '../../assets/img/Rank.png';
import { Link } from 'react-router-dom';

export const NavMenu = ({ activeChild }) => {
    const navMenuStyle = {
        container: {
            boxShadow: '0px 0px 10px 0px rgba(0,0,0,0.75)',
            color: 'white',
            padding: '0.5rem',
            display: 'flex',
            justifyContent: 'space-evenly',
            alignItems: 'center',
            position: 'fixed',
            bottom: '0',
            left: '0',
            width: '100%',
            zIndex: '1',
            backgroundColor: 'rgba(255, 255, 255, 0.8)' // White color with 50% transparency
        },

        nav : {
            width: '50%',
            display: 'flex',
            justifyContent: 'space-evenly',
            alignItems: 'center',
        },

        img: {
            borderRadius: '50%',
            padding: '0.5rem',
        },

        active: {
            borderRadius: '50%',
            padding: '0.5rem',
            backgroundImage: 'linear-gradient(to bottom right, #318EAD, #4A90E2)',
            border: '2px solid white',
            boxShadow: '0px 0px 5px 0px rgba(0,0,0,0.5)',
        }
    };

    return (
        <div style={navMenuStyle.container}>
            <div style={navMenuStyle.nav}>
                <Link to="/newbook"><img src={Book} alt="" style={activeChild === 1 ? navMenuStyle.active : navMenuStyle.img} /></Link>
                <a href="#"><img src={Rank} alt="" style={activeChild === 2 ? navMenuStyle.active : navMenuStyle.img} /></a>
                <Link to="/home"><img src={Home} alt="" style={activeChild === 3 ? navMenuStyle.active : navMenuStyle.img} /></Link>
                <Link to="/profile"><img src={User} alt="" style={activeChild === 4 ? navMenuStyle.active : navMenuStyle.img} /></Link>
            </div>
        </div>
    );
};
