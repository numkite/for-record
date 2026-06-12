import React from 'react';

interface SubPageProps {
  title: string;       // 페이지 상단 제목 (ex. LANDSCAPE)
  imageNames: string[]; 
}

const SubPage: React.FC<SubPageProps> = ({ title, imageNames }) => {
  return (
    <div className="w-full flex flex-col items-center bg-white pb-20">
      {/* 1. 페이지 제목 영역  */}
      <div className="py-16 text-center">
        <h2 className="text-2xl font-light tracking-[0.3em] text-gray-800 uppercase border-b border-gray-300 pb-2 inline-block">
          {title}
        </h2>
      </div>

      {/* 2. 이미지 리스트 영역: 배열을 반복문(map)으로 돌려서 출력 */}
      <div className="w-full max-w-4xl px-4 flex flex-col items-center gap-0"> {/* gap-0으로 사진 사이 여백 제거 */}
        {imageNames.map((imageName, index) => (
          <img 
            key={index} // 반복문 사용 시 필수 (고유값)
            src={`/image/${imageName}`} 
            alt={`${title} - image ${index + 1}`} 
            className="w-full h-auto block" // 블록 요소로 설정
          />
        ))}
      </div>

      {/* 3. 유의사항 안내 문구 */}
      <div className="mt-10 px-6 max-w-4xl text-left text-xs text-gray-500 space-y-2 leading-relaxed border-t pt-8 border-gray-100">
        <p>※본 사이트 상의 문구 및 이미지, CG는 소비자의 이해를 돕기 위한 것으로 실제와 차이가 있을 수 있습니다.</p>
        <p>※본 사이트 상의 설계 및 조경, 휴계시설 등의 계획은 인·허가 과정이나 시공 시 현장 여건, 상품 개선 등에 따라 변경사항이 발생할 수 있습니다.</p>
      </div>
    </div>
  );
};

export default SubPage;