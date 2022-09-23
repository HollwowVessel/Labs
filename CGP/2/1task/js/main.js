const r = document.getElementById('r');
const g = document.getElementById('g');
const b = document.getElementById('b');
const x = document.getElementById('x');
const y = document.getElementById('y');
const z = document.getElementById('z');

function convertRGB() {
  if (r.value > 255) r.value = 255;
  else r.value = +r.value;
  if (g.value > 255) g.value = 255;
  else g.value = +g.value;
  if (b.value > 255) b.value = 255;
  else b.value = +b.value;

  let R = r.value / 255.0;
  let G = g.value / 255.0;
  let B = b.value / 255.0;

  if (R > 0.4045) R = ((R + 0.055) / 1.055) ** 2.4;
  else R = R / 12.92;
  if (G > 0.4045) G = ((G + 0.055) / 1.055) ** 2.4;
  else G = G / 12.92;
  if (B > 0.4045) B = ((B + 0.055) / 1.055) ** 2.4;
  else B = B / 12.92;

  R *= 100;
  G *= 100;
  B *= 100;
  x.value = Math.round((R * 0.4124 + G * 0.3576 + B * 0.1805) * 100) / 100;
  y.value = Math.round((R * 0.2125 + G * 0.7152 + B * 0.0722) * 100) / 100;
  z.value = Math.round((R * 0.0193 + G * 0.1192 + B * 0.9505) * 100) / 100;
}

r.addEventListener('keyup', convertRGB);
g.addEventListener('keyup', convertRGB);
b.addEventListener('keyup', convertRGB);
