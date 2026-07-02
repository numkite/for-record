import React from 'react';
import { Link } from 'react-router-dom';

const Navbar: React.FC = () => {
  return (
    <nav className="fixed top-0 left-0 w-full z-[100] flex flex-col bg-white shadow-md">
      
      {/* 1층: 로고와 전화기 */}
      <div className="flex justify-between items-center px-5 h-[60px] w-full">
        <Link to="/" className="flex items-center gap-1 no-underline">
          <span className="bg-[#5B3BB4] text-white text-[10px] px-1.5 py-0.5 rounded font-bold">북전주</span>
          <span className="font-bold text-[#3D3331] text-lg tracking-tighter">광신프로그레스</span>
        </Link>

        <div className = "flex items-center gap-3">
          <span 
            className="text-2xl font-black text-[#5B3BB4] tracking-wider hidden sm:inline-block"
            style={{ fontFamily: "'Gmarket Sans', 'Noto Sans KR', sans-serif" }}
          >
            010-5941-4589
          </span>
          <a 
            href="tel:010-5941-4589" 
            className="flex items-center justify-center w-9 h-9 bg-purple-50 text-[#5B3BB4] rounded-full hover:bg-[#5B3BB4] hover:text-white transition-all shadow-sm cursor-pointer"
          >
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-5 h-5">
              <path fillRule="evenodd" d="M1.5 4.5a3 3 0 0 1 3-3h1.372c.86 0 1.61.586 1.819 1.42l1.105 4.423a1.875 1.875 0 0 1-.694 1.955l-1.293.97c-.135.101-.164.249-.126.352a11.285 11.285 0 0 0 6.697 6.697c.103.038.25.009.352-.126l.97-1.293a1.875 1.875 0 0 1 1.955-.694l4.423 1.105c.834.209 1.42.959 1.42 1.82V19.5a3 3 0 0 1-3 3h-2.25C8.552 22.5 1.5 15.448 1.5 6.75V4.5Z" clipRule="evenodd" />
            </svg>
          </a>
        </div>
      </div>

      {/* 2층: 검은색 메뉴 바 */}
      <div className="bg-[#1d2432] w-full overflow-x-auto whitespace-nowrap scrollbar-hide">
        <ul className="flex list-none m-0 p-0 w-full">
          {[
            { name: '분양개요', path: '/business' },
            { name: '입지환경', path: '/location' },
            { name: '단지안내', path: '/complex' },
            { name: '세대안내', path: '/units' },
            { name: '관심고객등록', path: '/register' },
          ].map((menu) => (
            <li key={menu.name} className="flex-1 border-r border-white/10 last:border-r-0">
              <Link 
                to={menu.path} // 이 부분이 App.tsx의 path와 일치해야 함
                className="block w-full py-3 text-[14px] text-white no-underline hover:bg-[#5B3BB4] text-center transition-colors font-medium"
              >
                {menu.name}
              </Link>
            </li>
          ))}
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;