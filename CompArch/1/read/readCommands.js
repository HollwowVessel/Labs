const fs = require('fs');
const path = require('path');

const args = process.argv;
const filePath = path.join(args.at(-1), 'команды.txt');

function getData() {
  let data = fs.readFileSync(filePath, 'utf-8', (err, data) => {
    if (err) {
      throw err;
    }
  });
  data = data.replace('\n', ' ').split(' ');
  const res = [];
  for (let i = 1; i <= data.length; i++) {
    res.push(+data[i - 1]);
  }
  return res;
}
const res = getData();
module.exports = res;
