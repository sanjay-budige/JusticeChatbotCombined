import React from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Login from "./Login";
import Register from "./Register";
import QuestionAnswer from "./QuestionAnswer";
import Header from "./Header";
import Home from "./Home"; // Import the Home component
import './App.css';

function App() {
  const isAuthenticated = !!localStorage.getItem("logincheck"); // Check if user is logged in

  return (
    <Router>
      <div className="App">
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          {isAuthenticated ? (
            <Route path="/chatbot" element={<QuestionAnswer />} />
          ) : (
            <Route path="*" element={<Navigate to="/" />} />
          )}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
