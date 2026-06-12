import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite' // 이 줄이 핵심!

export default defineConfig({
  plugins: [
    react(),
    tailwindcss(), // 여기에 엔진을 장착합니다
  ],
})