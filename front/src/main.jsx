import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Login from './routes/acess/Login.jsx';
import Register from './routes/acess/Register.jsx';
import NewBook from './routes/book/NewBook.jsx';
import BookView from './routes/book/BookView.jsx';
import NewAnnotation from './routes/annotation/NewAnnotation.jsx';
import AnnotationView from './routes/annotation/AnnotationView.jsx';
import PrivateRoute from './routes/acess/PrivateRoute.jsx';

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route path="/home" exact element={<Home />} />
      <Route path="/newbook/*" element={<PrivateRoute element={<NewBook />} />} />
      <Route path="/bookview/*" element={<PrivateRoute element={<BookView />} />} />
      <Route path="/newannotation/*" element={<PrivateRoute element={<NewAnnotation />} />} />
      <Route path="/annotationview/*" element={<PrivateRoute element={<AnnotationView />} />} />
    </Routes>
  </BrowserRouter>
);
