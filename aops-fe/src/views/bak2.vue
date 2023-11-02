<template>
    <div class="radar-container">
      <canvas ref="radarCanvas" class="radar-canvas" />
    </div>
  </template>
  
  <script>
  import { ref, onMounted, onUnmounted } from 'vue';
  
  export default {
    setup() {
      const radarCanvas = ref(null);
      const rotationSpeed = 22;
      let angle = 0;
      let animationFrameId = null;
  
      const drawRadar = () => {
        const canvas = radarCanvas.value;
        if (!canvas) return;
        const ctx = canvas.getContext('2d');
        const size = canvas.width;
        const circleCount = 8;
  
        const animate = () => {
          ctx.clearRect(0, 0, size, size);
          ctx.fillStyle = 'gary';
          ctx.fillRect(0, 0, size, size);
  
          // Draw circles
          ctx.strokeStyle = 'rgba(0, 255, 0, 0.3)';
          ctx.lineWidth = 0.8;
          for (let i = 1; i <= circleCount; i++) {
            ctx.beginPath();
            ctx.arc(size / 2, size / 2, (size / 2) * (i / circleCount), 0, 2 * Math.PI);
            ctx.stroke();
          }
  
          // Draw angle lines & labels
          const divisions = 12;
          ctx.strokeStyle = 'rgba(0, 255, 0, 0.3)';
          ctx.fillStyle = 'rgba(0, 255, 0, 0.3)';
          ctx.lineWidth = 1;
          for (let i = 0; i < divisions; i++) {
            const radian = (2 * Math.PI / divisions) * i;
            const cos = Math.cos(radian);
            const sin = Math.sin(radian);
  
            ctx.beginPath();
            ctx.moveTo(size / 2, size / 2);
            ctx.lineTo((size / 2) + (size / 2) * cos, (size / 2) + (size / 2) * sin);
            ctx.stroke();
  
            ctx.fillText(
              `${(360 / divisions) * i}°`,
              (size / 2) + (size / 2 + 10) * cos - 5,
              (size / 2) + (size / 2 + 10) * sin + 5
            );
          }
  
          // Draw scan area
          ctx.beginPath();
          ctx.moveTo(size / 2, size / 2);
          ctx.arc(size / 2, size / 2, size / 2, angle, angle + Math.PI / 4);
          ctx.lineTo(size / 2, size / 2);
          ctx.fillStyle = 'rgba(0, 255, 0, 0.1)';
          ctx.fill();
  
          // Draw scan line
          ctx.beginPath();
          ctx.moveTo(size / 2, size / 2);
          ctx.lineTo((size / 2) + (size / 2) * Math.cos(angle), (size / 2) + (size / 2) * Math.sin(angle));
          ctx.strokeStyle = 'rgba(0, 255, 0, 0.5)';
          ctx.lineWidth = 4;
          ctx.stroke();
  
          angle += rotationSpeed;
  
          animationFrameId = requestAnimationFrame(animate);
        };
  
        animate();
      };
  
      onMounted(drawRadar);
  
      onUnmounted(() => {
        cancelAnimationFrame(animationFrameId);
      });
  
      return { radarCanvas };
    },
  };
  </script>
  
  <style scoped>
  .radar-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: black;
  }
  
  .radar-canvas {
    width: 700px;
    height: 400px;
    
  }
  </style>
  