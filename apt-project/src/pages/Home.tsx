import React from 'react';
import RegisterForm from '../components/RegisterForm';

const Home: React.FC = () => {
  return (
    <div className="w-full">
      {/* 메인 비주얼 */}
      <img src="/image/home1.jpeg" alt="메인" className="w-full h-auto block" />
      <img src="/image/home2.jpeg" alt="메인2" className="w-full h-auto block" />
      
      {/* 단지 정보 */}
      <div className="py-12 bg-white text-center">
        <p className="text-sm text-gray-500">SHOW ROOM</p>
        <h2 className="text-xl font-medium mt-4">전 세대 84㎡ 단일평형, 4Bay 혁신평면</h2>
      </div>
      
      {/* 평면도 사진들 */}
      <img src="/image/A-type.jpeg" alt="A타입" className="w-full h-auto block" />
      <img src="/image/B-type.jpeg" alt="B타입" className="w-full h-auto block" />
      
      {/* 예약 폼 */}
      <RegisterForm />
      
      {/* 하단 정보 (스크린샷 내용 반영) */}
      <footer className="bg-stone-100 p-8 text-[11px] text-gray-500 leading-relaxed border-t">
        <div className="mt-8 flex flex-col items-center">
          <div className="font-bold text-gray-700 text-sm mb-4">RAON PRIVATE</div>
          <p>© 2026 전주 라온프라이빗 홈페이지 All rights reserved.</p>
        </div>
      </footer>
    </div>
  );
};

export default Home;