import React from 'react';

const LocationPage: React.FC = () => {
  const imageNames = ['locate.png', 'apt-locate.jpg'];

  return (
    <div className="w-full flex flex-col items-center bg-white pb-20">
      <div className="py-20 text-center">
        <h2 className="text-3xl tracking-[0.2em] text-[#3D3331] uppercase relative pb-4 inline-block"
          style={{ fontFamily: "'Cinzel', 'Noto Serif KR', serif" }}>
          LOCATION
          <span className="absolute bottom-0 left-1/2 -translate-x-1/2 w-12 h-1 bg-[#5B3BB4] rounded-full"></span>
        </h2>
      </div>

      <div className="w-full max-w-4xl px-4 flex flex-col items-center gap-12">
        {imageNames.map((imageName, index) => (
          <img 
            key={index} 
            src={`/image/${imageName}`} 
            alt={`입지환경 - 이미지 ${index + 1}`} 
            className="w-full h-auto block" 
          />
        ))}
      </div>

      <div className="mt-10 px-6 max-w-4xl text-left text-xs text-gray-500 space-y-2 leading-relaxed border-t pt-8 border-gray-100">
        <p>※본 사이트 상의 문구 및 이미지, CG는 소비자의 이해를 돕기 위한 것으로 실제와 차이가 있을 수 있습니다.</p>
        <p>※본 사이트 상의 설계 및 조경, 휴계시설 등의 계획은 인·허가 과정이나 시공 시 현장 여건, 상품 개선 등에 따라 변경사항이 발생할 수 있습니다.</p>
      </div>
    </div>
  );
};

export default LocationPage;