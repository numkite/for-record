import React from 'react';

const Header: React.FC = () => {
  return (
    <header className="fixed top-0 left-0 w-full z-50 shadow-md flex flex-col">
      {/* (1) 상단 레이어: 로고와 전화번호 */}
      <div className="bg-white flex justify-between items-center px-4 py-3 border-b border-gray-100">
        <div className="flex items-center gap-1">
          <span className="bg-[#5B3BB4] text-white text-[10px] px-1.5 py-0.5 rounded font-bold">북전주</span>
          <span className="font-black text-[#3D3331] text-xl tracking-tighter">광신프로그레스</span>
        </div>

        <a href="tel:1866-2181" className="flex items-center gap-1 text-[#5B3BB4] font-bold">
          <span className="text-lg" style={{ fontFamily: "'Cinzel', sans-serif" }}>1866-2181</span>
        </a>
      </div>

      {/* (2) 하단 레이어: 메뉴바 */}
      <nav className="bg-[#1d2432] overflow-x-auto whitespace-nowrap scrollbar-hide">
        <ul className="flex">
          {['분양개요', '입지환경', '단지안내', '세대안내', '관심고객등록'].map((menu) => (
            <li 
              key={menu} 
              className="px-5 py-3 text-white text-sm font-medium border-r border-white/10 hover:bg-[#5B3BB4] cursor-pointer transition-colors"
            >
              {menu}
            </li>
          ))}
        </ul>
      </nav>
    </header>
  );
};

export default Header;