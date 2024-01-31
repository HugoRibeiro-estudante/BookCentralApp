
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import { RouterProvider, Routes, Route, createBrowserRouter } from 'react-router-dom';
import Login from './routes/acess/Login.jsx';
import Register from './routes/acess/Register.jsx';
import NewBook from './routes/book/NewBook.jsx';
import BookView from './routes/book/BookView.jsx';
import NewAnnotation from './routes/annotation/NewAnnotation.jsx';
import AnnotationView from './routes/annotation/AnnotationView.jsx';
import PrivateRoute from './routes/acess/PrivateRoute.jsx'; 
import Home from './routes/Home.jsx';
import { Profile } from './routes/user/Profile.jsx';

const router = createBrowserRouter([
 {
  element: <App />,
  children: [
   {
    path: '/',
    element: <Login />,
   },
   {
    path: '/login',
    element: <Login />,
   },
   {
    path: '/register',
    element: <Register />,
   },
   {
    path: '/home/*',
    element: <PrivateRoute element={<Home />} />
   },
   {
    path: '/profile/*',
    element: <PrivateRoute element={<Profile />} />
   },
   {
    path: '/newbook/*',
    element: <PrivateRoute element={<NewBook />} />
   },
   {
    path: '/bookview/*',
    element: <PrivateRoute element={<BookView />} />
   },
   {
    path: '/newannotation/*',
    element: <PrivateRoute element={<NewAnnotation />} />
   },
   {
    path: '/annotationview/*',
    element: <PrivateRoute element={<AnnotationView />} />
   },
  ],
 },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
 <React.StrictMode>
  <RouterProvider router={router} />
 </React.StrictMode>,
);
