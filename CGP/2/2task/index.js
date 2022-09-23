let bmp = require('bmp-js');
let fs = require('fs');
let bmpBuffer = fs.readFileSync('star.bmp');
let bmpData = bmp.decode(bmpBuffer);

let data = {
  data: bmpData.buffer,
  width: bmpData.width,
  height: bmpData.height,
};

fs.writeFileSync('./image.bmp', data.data);
