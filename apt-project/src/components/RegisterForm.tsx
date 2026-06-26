import React, { useState } from 'react';
import emailjs from '@emailjs/browser'; 

const RegisterForm: React.FC = () => {
  const [name, setName] = useState('');
  const [phone2, setPhone2] = useState('');
  const [phone3, setPhone3] = useState('');
  const [agreed, setAgreed] = useState(false);

  const isFormValid = 
    name.trim().length >= 2 && 
    phone2.length >= 4 && 
    phone3.length >= 4 && 
    agreed;

  // 2. ★ 전송 함수 ★
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault(); // 페이지 새로고침 방지

    const templateParams = {
      name: name,
      phone: `010-${phone2}-${phone3}`,
      date: new Date().toLocaleString()
    };

    emailjs.send(
      import.meta.env.VITE_EMAILJS_SERVICE_ID,
      import.meta.env.VITE_EMAILJS_TEMPLATE_ID,
      templateParams,
      import.meta.env.VITE_EMAILJS_PUBLIC_KEY
    )
    .then(() => {
      alert('관심고객 등록이 완료되었습니다. 메일로 전송되었습니다!');
      // 성공 시 입력창 초기화
      setName('');
      setPhone2('');
      setPhone3('');
      setAgreed(false);
    })
    .catch((err) => {
      alert('전송 중 오류가 발생했습니다. ID를 확인해 주세요.');
      console.error('EmailJS Error:', err);
    });
  };

  return (
    <section className="py-16 px-6 bg-white">
      <form onSubmit={handleSubmit} className="max-w-md mx-auto border border-gray-200 p-8 shadow-sm">
        <h3 className="text-center text-3xl tracking-widest text-[#3D3331] mb-2 underline decoration-[#5B3BB4] underline-offset-8"
          style={{ fontFamily: "'Cinzel', 'Noto Serif KR', serif" }}>
          1866-2181
        </h3>
        <h4 className="text-center text-xl font-bold text-gray-800 mb-10">관심고객 등록</h4>
        
        <div className="space-y-6">
          {/* 이름 입력 */}
          <div className="flex flex-col gap-2">
            <label className="text-sm font-semibold text-gray-600 flex items-center gap-1">
              이름 <span className="text-[#5B3BB4] text-[10px]">●</span>
            </label>
            <input 
              type="text" 
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="성함을 입력해주세요"
              className="w-full border-b border-gray-300 py-2 focus:border-[#5B3BB4] outline-none transition-colors text-[#3D3331]"
            />
          </div>

          {/* 연락처 입력 */}
          <div className="flex flex-col gap-2">
            <label className="text-sm font-semibold text-gray-600 flex items-center gap-1">
              연락처 <span className="text-[#5B3BB4] text-[10px]">●</span>
            </label>
            <div className="flex items-center gap-2">
              <input type="text" className="w-full border border-gray-300 p-2 rounded text-center bg-gray-50" value="010" readOnly />
              <span className="text-gray-400">-</span>
              <input 
                type="text" 
                maxLength={4}
                value={phone2}
                onChange={(e) => setPhone2(e.target.value.replace(/[^0-9]/g, ''))}
                className="w-full border border-gray-300 p-2 rounded text-center focus:border-[#5B3BB4] outline-none text-[#3D3331]" 
              />
              <span className="text-gray-400">-</span>
              <input 
                type="text" 
                maxLength={4}
                value={phone3}
                onChange={(e) => setPhone3(e.target.value.replace(/[^0-9]/g, ''))}
                className="w-full border border-gray-300 p-2 rounded text-center focus:border-[#5B3BB4] outline-none text-[#3D3331]"
              />
            </div>
          </div>

          {/* 개인정보 수집 동의란 */}
          <div className="pt-4 border-t border-gray-100">
            <div className="flex items-center gap-2 mb-3">
              <input 
                type="checkbox" 
                id="agree" 
                checked={agreed}
                onChange={(e) => setAgreed(e.target.checked)}
                className="w-4 h-4 accent-[#5B3BB4] cursor-pointer" 
              />
              <label htmlFor="agree" className="text-sm font-bold text-gray-700 cursor-pointer">
                개인정보 수집 및 이용에 동의합니다.
              </label>
            </div>
            
            <div className="h-32 overflow-y-auto bg-gray-50 p-3 text-[11px] text-gray-500 leading-relaxed border border-gray-200 rounded scrollbar-hide">
              <p className="font-bold mb-1 text-gray-600 text-xs">※ 개인정보 수집 및 이용에 관한 안내</p>
              <p>“북전주 광신프로그레스”는 고객님들에게 분양에 필요한 정보 이용을 위해 필요한 최소한의 범위로 개인정보를 수집합니다...</p>
              <p className="mt-2 font-bold text-gray-600 underline">개인정보의 수집 및 이용목적</p>
              <p>이름, 전화번호 : 분양정보 및 분양상담 등 안내를 위해 제공받고 이용목적이 달성된 후에는 해당정보를 지체없이 파기합니다.</p>
              <p className="mt-2 text-red-500">개인정보 수집 동의 거부권 : 모든 고객은 동의를 거부할 수 있으며, 동의를 거부할 경우 관심고객 등록이 불가합니다.</p>
            </div>
          </div>

          {/* 등록 버튼: type="submit"으로 변경 */}
          <button 
            type="submit"
            disabled={!isFormValid}
            className={`w-full py-4 mt-2 font-bold transition-all duration-300 ${
              isFormValid 
              ? "bg-gray-800 text-white hover:bg-[#5B3BB4] cursor-pointer shadow-lg" 
              : "bg-gray-200 text-gray-400 cursor-not-allowed"
            }`}
          >
            {isFormValid ? "관심고객 등록하기" : "정보를 모두 입력해주세요"}
          </button>
        </div>
      </form>
    </section>
  );
};

export default RegisterForm;