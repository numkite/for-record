// src/pages/RegisterPage.tsx
import React from 'react';
import RegisterForm from '../components/RegisterForm';

const RegisterPage: React.FC = () => {
  return (
    <div className="bg-white min-h-screen py-10">
      {/* 다른 사진 없이 폼만 중앙에 배치 */}
      <RegisterForm />
    </div>
  );
};

export default RegisterPage;