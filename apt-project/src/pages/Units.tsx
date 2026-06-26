import React from 'react';

interface UnitSectionProps {
  title: string;
  images: string[];
}
const UnitSection: React.FC<UnitSectionProps> = ({ title, images }) => {
  return (
    <div className="w-full flex flex-col items-center mt-28 first:mt-4">
      <h3 className="text-xl font-extrabold text-[#3D3331] tracking-wider mb-6 border-l-4 border-[#5B3BB4] pl-3 align-middle self-start md:ml-4">
        {title}
      </h3>
      <div className="w-full flex flex-col items-center gap-0">
        {images.map((imageName, index) => (
          <img 
            key={index} 
            src={`/image/${imageName}`} 
            alt={`${title} - ${index + 1}`} 
            className="w-full h-auto block" 
          />
        ))}
      </div>
    </div>
  );
};

const Units: React.FC = () => {
  return (
    <div className="w-full flex flex-col items-center bg-white pb-20">
      <div className="py-20 text-center">
        <h2 className="text-3xl tracking-[0.2em] text-[#3D3331] uppercase relative pb-4 inline-block"
          style={{ fontFamily: "'Cinzel', 'Noto Serif KR', serif" }}>
          UNIT GUIDE
          <span className="absolute bottom-0 left-1/2 -translate-x-1/2 w-12 h-1 bg-[#5B3BB4] rounded-full"></span>
        </h2>
      </div>

      <div className="w-full max-w-4xl px-4">
        <UnitSection 
          title="Living Room" 
          images={['home-in1.jpg', 'home-in2.jpg', 'home-in3.jpg', 'home-in4.jpg', 'home-in6.jpg', 'home-in5.jpg']} 
        />
        
        <UnitSection 
          title="Kitchen" 
          images={['kitchen1.jpg', 'kitchen2.jpg', 'kitchen3.jpg']} 
        />
        
        <UnitSection 
          title="Room" 
          images={['room1.jpg', 'room2.jpg', 'room3.jpg', 'room4.jpg', 'room5.jpg']} 
        />
        
        <UnitSection 
          title="Floor Plan" 
          images={['total-type.png']} 
        />
      </div>

      {/* 하단 공통 유의사항 */}
      <div className="mt-10 px-6 max-w-4xl text-left text-xs text-gray-500 space-y-2 leading-relaxed border-t pt-8 border-gray-100">
        <p>※본 사이트 상의 문구 및 이미지, CG는 소비자의 이해를 돕기 위한 것으로 실제와 차이가 있을 수 있습니다.</p>
        <p>※본 사이트 상의 설계 및 조경, 휴계시설 등의 계획은 인·허가 과정이나 시공 시 현장 여건, 상품 개선 등에 따라 변경사항이 발생할 수 있습니다.</p>
      </div>
    </div>
  );
};

export default Units;