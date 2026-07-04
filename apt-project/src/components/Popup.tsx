import React, { useState, useEffect } from 'react';

const Popup: React.FC = () => {
  const [isOpen, setIsOpen] = useState(false);

  useEffect(() => {
    setIsOpen(true);
  }, []);

  if (!isOpen) return null;

  return (
    // fixed inset-0와 bg-black/50으로 뒷배경을 흐리고 투명하게
    <div className="fixed inset-0 z-[9999] flex items-center justify-center pointer-events-none px-4">
      
      {/* 팝업 창 전체 컨테이너 */}
      <div className="relative max-w-[420px] w-full bg-white rounded-lg shadow-2xl overflow-hidden flex flex-col pointer-events-auto border border-gray-200">
        
        {/* X자 닫기 버튼 */}
        <button
          onClick={() => setIsOpen(false)}
          className="absolute top-3 right-3 z-50 w-8 h-8 flex items-center justify-center bg-black bg-opacity-40 text-white rounded-full hover:bg-opacity-70 transition-all font-bold text-base cursor-pointer"
          aria-label="닫기"
        >
          ✕
        </button>
        <div className="w-full bg-gray-100 flex items-center justify-center min-h-[300px]">
          <img
            src="/image/gift-popup.png" 
            alt="사은품 증정 이벤트"
            className="w-full h-auto object-contain block"
          />
        </div>

      </div>
    </div>
  );
};

export default Popup;