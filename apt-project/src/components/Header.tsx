import React from 'react';

const Header: React.FC = () => {
  return (
    <header className="fixed top-0 left-0 w-full z-50 shadow-md flex flex-col">
      {/* (1) 상단 레이어: 로고와 전화번호 */}
      <div className="bg-white flex justify-between items-center px-4 py-3 border-b border-gray-100">
        <div className="flex items-center gap-1">
          <span className="bg-orange-600 text-white text-[10px] px-1.5 py-0.5 rounded font-bold">전주</span>
          <span className="font-black text-gray-900 text-xl tracking-tighter">라온프라이빗</span>
        </div>

        <a href="tel:1555-6615" className="flex items-center gap-1 text-orange-600 font-bold">
          <span className="text-lg">1555-xxxx</span>
        </a>
      </div>

      {/* (2) 하단 레이어: 메뉴바 */}
      <nav className="bg-[#222] overflow-x-auto whitespace-nowrap scrollbar-hide">
        <ul className="flex">
          {['사업안내', '입지환경', '단지안내', '세대안내', '관심고객등록'].map((menu) => (
            <li 
              key={menu} 
              className="px-5 py-3 text-white text-sm font-medium border-r border-white/10 hover:bg-orange-600 cursor-pointer transition-colors"
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