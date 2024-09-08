import React from "react";
import { Link } from "react-router-dom";
import './Home.css'; // Make sure to create or adjust this CSS file for styling

const Home = () => {
  return (
    <div className="home-container">
      <h1>Welcome to the Justice Chatbot</h1>
      <div className="home-buttons">
        <Link to="/login" className="button">Login</Link>
        <Link to="/register" className="button">Register</Link>
      </div>
    </div>
  );
};

export default Home;
