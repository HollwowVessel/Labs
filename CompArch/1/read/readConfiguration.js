const fs = require('fs');
const path = require('path');

const args = process.argv;
const filePath = path.join(args.at(-2), 'лоток.txt');

function getData() {
  let data = fs.readFileSync(filePath, 'utf-8', (err, data) => {
    if (err) {
      throw err;
    }
  });
  const res = [];
  let temp = [];
  data = data.replace('\n', ' ').split(' ');
  for (let i = 1; i < 442; i++) {
    temp.push(+data[i - 1].replace('\r', '').replace('\n', ''));
    if (i % 21 === 0) {
      res.push(temp);
      temp = [];
    }
  }
  return res;
}
const res = getData();

module.exports = res;
