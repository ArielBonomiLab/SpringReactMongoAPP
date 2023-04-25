import './App.css';
import api from './api/axiosConfig';
import {userState, useEffect} from 'react';

function App() {

  const[movies, setMovies] = userState();

  const getMovies = async () => {

    try{
      
      console.log('prueba');

      const response = await api.get("/api/v1/movies");
  
      console.log(response.data);

      setMovies(response.data);

    } catch (err) {
      console.log(err);
    }

  }

  useEffect (() => {
    getMovies();
  }, [])

  return (
    <div className="App">

    </div>
  );
}

export default App;
