import React from 'react';

const Footer: React.FC = () => {
  return (
    <footer className="bg-gray-100 border-t border-gray-200 py-10 px-6">
      <div className="max-w-4xl mx-auto text-center">
        <h2 className="text-gray-800 font-bold text-xl mb-4">북전주 광신프로그레스</h2>
        
        <div className="text-gray-500 text-sm space-y-2 leading-relaxed">
          <p>현장주소: 전라북도 전주시 덕진구 여산로 256</p>
          <p>분양홍보관: 전주시 덕진구 호성동 2가 631-103</p>
          <p>문의전화: <span className="text-[#5B3BB4] font-bold text-lg">1866-2181</span></p>
        </div>

        <div className="mt-8 pt-6 border-t border-gray-200">
          <p className="text-[10px] text-gray-400 uppercase tracking-widest">
            © 2026 북전주 광신프로그레스. All Rights Reserved.
          </p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;