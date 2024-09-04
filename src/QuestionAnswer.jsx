// src/QuestionAnswer.js
import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

const QuestionAnswer = () => {
  const [question, setQuestion] = useState('');
  const [chat, setChat] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleInputChange = (e) => {
    setQuestion(e.target.value);
  };

  const fetchAnswer = async () => {
    if (!question) return;
    setLoading(true);
    setError(null);
    try {
      // Add user's question to the chat
      setChat((prevChat) => [...prevChat, { type: 'user', text: question }]);

      const response = await axios.post('http://localhost:8080/justice-chatbot', {
        question: question,
      });

      // Add the API's answer to the chat
      setChat((prevChat) => [
        ...prevChat,
        { type: 'bot', text: response.data.answer },
      ]);
    } catch (err) {
      setError('Failed to get the answer. Please try again.');
    } finally {
      setLoading(false);
      setQuestion('');
    }
  };

  const handleKeyPress = (e) => {
    if (e.key === 'Enter') {
      fetchAnswer();
    }
  };

  return (
    <div className="chatbot-container">
      <div className="chat-window">
        {chat.map((message, index) => (
          <div
            key={index}
            className={`chat-bubble ${message.type === 'user' ? 'user' : 'bot'}`}
          >
            {message.text}
          </div>
        ))}
      </div>
      <div className="input-container">
        <input
          type="text"
          value={question}
          onChange={handleInputChange}
          onKeyPress={handleKeyPress}
          placeholder="Type your question..."
          disabled={loading}
        />
        <button onClick={fetchAnswer} disabled={loading || !question}>
          {loading ? '...' : 'Send'}
        </button>
      </div>
      {error && <p className="error">{error}</p>}
    </div>
  );
};

export default QuestionAnswer;
