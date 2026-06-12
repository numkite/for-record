import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import Home from './pages/Home';
import SubPage from './pages/SubPage'; 
import RegisterPage from './pages/RegisterPage';

const App: React.FC = () => {
  return (
    <Router>
      <div className="flex flex-col min-h-screen">
        <Navbar />
        <main className="flex-grow pt-[104px]">
          <Routes>
            {/* 홈 화면 */}
            <Route path="/" element={<Home />} />

            <Route path="/business" element={<SubPage title="OVERVIEW" imageNames={['apt-count.jpeg', 'main-1.jpeg']} />} />
            <Route path="/location" element={<SubPage title="LOCATION" imageNames={['apt-locate.jpeg']} />} />
            <Route path="/complex" element={<SubPage title="LANDSCAPE" imageNames={['apt-shape.jpeg', 'main-2.jpeg']} />} />
            
            {/* 세대 안내는 A타입, B타입을 연달아 보여주기*/}
            <Route path="/units" element={<SubPage title="UNIT GUIDE" imageNames={['A-type.jpeg', 'B-type.jpeg']} />} />
            
            {/* 관심고객등록은 홈 화면의 폼으로 바로 이동하거나 별도 페이지로 지정 가능 */}
            <Route path="/register" element={<RegisterPage />} /> 
          </Routes>
        </main>
        <Footer />
      </div>
    </Router>
  );
};

export default App;