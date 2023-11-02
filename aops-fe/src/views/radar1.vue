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
      let animationFrameId = null;
      const rotationSpeed = 22;
      let angle = 1;
  
      const drawRadar = () => {
        const canvas = radarCanvas.value;
        if (!canvas) return;
        const ctx = canvas.getContext('2d');
        const size = canvas.width;
        const circleCount = 8;
  
        const animate = () => {
          ctx.clearRect(0, 0, size, size);
  
          ctx.fillStyle = 'black';
          ctx.fillRect(0, 0, size, size);
  
          for (let i = 1; i <= circleCount; i++) {
            ctx.beginPath();
            ctx.arc(size / 2, size / 2, (size / 2) * (i / circleCount), 0, 2 * Math.PI);
            ctx.strokeStyle = 'rgba(0, 255, 0, 0.5)';
            ctx.lineWidth = 0.9;
            ctx.stroke();
          }
  
          ctx.save();
          ctx.translate(size / 2, size / 2);
          ctx.rotate(angle);
          ctx.beginPath();
          ctx.moveTo(0, 0);
          ctx.lineTo(size / 2, 0);
          ctx.strokeStyle = 'rgba(0, 255, 0, 1)';
          ctx.lineWidth = 4;
          ctx.stroke();
          ctx.restore();
  
          // add scanned points
          for (let i = 0; i < 20; i += Math.random() * 10) {
            const r = size * Math.random() / 2;
            const x = (size / 2) + r * Math.cos(i);
            const y = (size / 2) + r * Math.sin(i);
  
            ctx.beginPath();
            ctx.arc(x, y, 2, 1, 2 * Math.PI);
            ctx.fillStyle = 'rgba(0, 255, 0, 1)';
            ctx.fill();
          }
  
          angle += rotationSpeed;
  
          animationFrameId = requestAnimationFrame(animate);
        };
  
        animate();
      };
  
      onMounted(() => {
        drawRadar();
      });
  
      onUnmounted(() => {
        cancelAnimationFrame(animationFrameId);
      });
  
      return {
        radarCanvas
      };
    }
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
  