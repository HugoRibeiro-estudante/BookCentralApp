import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';
import { RouterProvider, Routes, Route, createBrowserRouter } from 'react-router-dom';
import Login from './routes/acess/Login.jsx';
import Home from './routes/Home.jsx';
import NewBook from './routes/book/NewBook.jsx';
import BookView from './routes/book/BookView.jsx';
import NewAnnotation from './routes/annotation/NewAnnotation.jsx';
import AnnotationView from './routes/annotation/AnnotationView.jsx';
import PrivateRoute from './routes/acess/PrivateRoute.jsx'; // Certifique-se de importar o PrivateRoute


const router = createBrowserRouter([
  {
    element: <App />,
    children: [
      {
        path: '/login',
        element: <Login />,
      },
      {
        path: '/home/*',
        element: <PrivateRoute><Home /></PrivateRoute>,
      },
      {
        path: '/newbook/*',
        element: <NewBook />,
      },
      {
        path: '/bookview/*',
        element: <PrivateRoute><BookView /></PrivateRoute>,
      },
      {
        path: '/newannotation/*',
        element: <PrivateRoute><NewAnnotation /></PrivateRoute>,
      },
      {
        path: '/annotationview/*',
        element: <PrivateRoute><AnnotationView /></PrivateRoute>,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
);
