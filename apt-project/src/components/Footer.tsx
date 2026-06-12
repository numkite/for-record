import React from 'react';

const Footer: React.FC = () => {
  return (
    <footer className="bg-gray-100 border-t border-gray-200 py-10 px-6">
      <div className="max-w-4xl mx-auto text-center">
        <h2 className="text-gray-800 font-bold text-lg mb-4">전주 라온프라이빗 퍼스티브</h2>
        
        <div className="text-gray-500 text-xs space-y-2 leading-relaxed">
          <p>현장주소: 전라북도 전주시 완산구 평화동2가 409-10외 51필지</p>
          <p>분양홍보관: 전주시 완산구 (예약제 운영 중)</p>
          <p>문의전화: <span className="text-orange-600 font-bold text-sm">1555-xxxx</span></p>
        </div>

        <div className="mt-8 pt-6 border-t border-gray-200">
          <p className="text-[10px] text-gray-400 uppercase tracking-widest">
            © 2026 Raon Private Firstive. All Rights Reserved.
          </p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;