let fs = require('fs');
const fileNames = process.argv.slice(2);
console.log('Wait a few seconds...');
let bmpBuffer = fs.readFileSync(fileNames[0] + '.bmp');

fs.writeFileSync(fileNames[1] + '.bmp', bmpBuffer);
console.log('Finished');
