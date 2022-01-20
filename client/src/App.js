import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import LoginPage from './components/LoginPage';
import SignPage from './components/SignPage';
import MyPage from './components/MyPage';


function App() {

  return (
    <Router>
      <div>
        <Routes>
          <Route exact path="/" element={<LoginPage/>} />
          <Route path="/sign" element={<SignPage />} />
          <Route path="/mypage" element={<MyPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;