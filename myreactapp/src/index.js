import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Home from './Home';
import './index.css';

ReactDOM.render(
  <App />,
  document.getElementById('root')
);

ReactDOM.render(
  <Home />,
  document.getElementById('bodycontent')
);
