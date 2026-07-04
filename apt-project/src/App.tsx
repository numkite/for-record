import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import ScrollToTop from './components/ScrollToTop';
import Home from './pages/Home';
import BusinessPage from './pages/BusinessPage';
import LocationPage from './pages/LocationPage';
import ComplexPage from './pages/ComplexPage';
import Units from './pages/Units';
import RegisterPage from './pages/RegisterPage';
import Popup from './components/Popup';

const App: React.FC = () => {
  return (
    <Router>
      <ScrollToTop />
      <Popup />
      <div className="flex flex-col min-h-screen">
        <Navbar />
        <main className="flex-grow pt-[104px]">
          <Routes>
            {/* 홈 화면 */}
            <Route path="/" element={<Home />} />
            <Route path="/business" element={<BusinessPage />} />
            <Route path="/location" element={<LocationPage />} />
            <Route path="/complex" element={<ComplexPage />} />
            <Route path="/units" element={<Units />} />
            <Route path="/register" element={<RegisterPage />} />
                       
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