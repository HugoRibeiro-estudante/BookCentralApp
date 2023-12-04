import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import { RouterProvider, Route, createBrowserRouter} from "react-router-dom"
import Login from './routes/acess/Login.jsx'
import Home from './routes/Home.jsx'
import NewBook from './routes/book/NewBook.jsx'
import BookView from './routes/book/BookView.jsx'
import NewAnnotation from './routes/annotation/NewAnnotation.jsx'
import AnnotationView from './routes/annotation/AnnotationView.jsx'

const router = createBrowserRouter([
  {
    element: <App />,
    children: [
      {
        path: "/home",
        element: <Home/>
      },
      {
        path: "/login",
        element: <Login/>
      },
      {
        path: "/newbook",
        element: <NewBook/>
      },
      {
        path: "/bookview",
        element: <BookView/>
      },
      {
        path: "/newannotation",
        element: <NewAnnotation/>
      },
      {
        path: "/annotationview",
        element: <AnnotationView/>
      },

    ]
  }
])

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)