import React from 'react';
import RegisterForm from '../components/RegisterForm';

const Home: React.FC = () => {
  return (
    <div className="w-full">
      {/* 메인 비주얼 */}
      <img src="/image/banner.png" alt="배너" className="w-full h-auto object-cover block" />
      <img src="/image/home0.jpeg" alt="메인1" className="w-full h-auto object-cover block" />
      <img src="/image/home2.jpg" alt="메인2" className="w-full h-auto object-cover block" />
      
      {/* 예약 폼 */}
      <RegisterForm />
      
    </div>
  );
};

export default Home;