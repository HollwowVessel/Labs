let readLine = require("readline-sync");

const days = readLine.question("Input the quantity of days: ");

checkNum(days);

let values = [];
for (let i = 0; i < days; i++) {
  let temp = readLine.question(`Input cost for ${i + 1} day: `);
  checkNum(temp);
  if (temp > 0) {
    values = [...values, temp];
  } else {
    throw "Heck";
  }
}

let n = days - 1;

let difArray = [];
for (i = 1; i < days; i++) {
  difArray[i - 1] = values[i] - values[i - 1];
}

console.log(...values);

console.log(...difArray);
const res = maxSubarraySum(difArray, 0, n - 1);
console.log(res);
findBoundaries(difArray, n);

function checkNum(num) {
  if (isNaN(+num)) {
    throw "Heck it isn't a number!";
  } else {
    return true;
  }
}

function maxSubarraySum(arr, low, length) {
  let mid = 0;
  if (Math.floor(low) === Math.floor(length)) {
    return arr[Math.floor(low)];
  }
  mid = (low + length) / 2;
  return Math.max(
    Math.max(
      maxSubarraySum(arr, low, mid),
      maxSubarraySum(arr, mid + 1, length)
    ),
    maxCrossingSum(arr, low, mid, length)
  );
}

function maxCrossingSum(arr, low, mid, length) {
  let sum = 0;
  let leftPartSum = -1;
  for (let i = mid; i >= low; i--) {
    sum += arr[i];
    if (sum > leftPartSum) leftPartSum = sum;
  }
  sum = 0;
  let rightPartSum = -1;
  for (let i = mid + 1; i <= length; i++) {
    sum += arr[i];
    if (sum > rightPartSum) rightPartSum = sum;
  }
  return leftPartSum + rightPartSum;
}

function findBoundaries(arr, length) {
  let start = 0,
    end = 0,
    currMax = 0,
    prevMax = 0,
    startO = 0;
  for (let i = 0; i < length; i++) {
    currMax += arr[i];
    if (currMax < 0) {
      start = i + 1;
      currMax = 0;
    } else if (currMax > prevMax) {
      end = i;
      startO = start;
      prevMax = currMax;
    }
  }
  console.log(`Buy in day: ${startO + 1}`);
  console.log(`Sell in day: ${end + 2}`);
}
