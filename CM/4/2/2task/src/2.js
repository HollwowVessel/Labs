'use strict';
/*
Багдя Павел 1 вариант, 21 группа
Решите систему линейных алгебраических уравнений методом Жордана-Гаусса ( ) в соответствии с вариантом.
Result is: 1.331, 0.693, 1.802
*/
let A = [
  [1.0, 0.42, 0.54, 0.66],
  [0.42, 1, 0.32, 0.44],
  [0.54, 0.32, 1, 0.22],
  [0.66, 0.44, 0.22, 1],
];
let obr = [
  [1, 0, 0, 0],
  [0, 1, 0, 0],
  [0, 0, 1, 0],
  [0, 0, 0, 1],
];
let E = 0.001;
let prec = 10 ** (String(E).length - 2);
function jordanoElimination() {
  for (let i = 0; i < A.length; i++) {
    let temp = A[i][i];
    for (let k = 0; k < A.length; k++) {
      A[i][k] = A[i][k] / temp;
      obr[i][k] = obr[i][k] / temp;
    }
    for (let j = 0; j < A.length; j++) {
      if (i !== j) {
        let temp = A[j][i];
        for (let k = 0; k < A.length; k++) {
          A[j][k] -= temp * A[i][k];
          obr[j][k] = Math.round((obr[j][k] - temp * obr[i][k]) * prec) / prec;
        }
      }
    }
  }
}
function getResult() {
  let res = [];
  for (let i = 0; i < A.length; i++) {
    let temp = [];
    for (let j = 4; j < A[0].length; j++) {
      temp.push(A[i][j]);
    }
    res.push(temp);
  }
  return res;
}
function solve() {
  jordanoElimination();
  let res = getResult();
  return res;
}
let res = solve();
console.log(A);
for (let i = 0; i < 4; i++) {
  console.log(obr[i]);
}
// Result is: 0.286
