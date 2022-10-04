/*
Багдя Павел 1 вариант, 21 группа
Решите систему линейных алгебраических уравнений методом Жордана-Гаусса ( ) в соответствии с вариантом.
Result is: 1.331, 0.693, 1.802
*/

let A = [
  [0.34, 0.71, 0.63, 2.08],
  [0.71, -0.65, -0.18, 0.17],
  [1.17, -2.35, 0.75, 1.28],
];
let E = 0.0001;
let prec = 10 ** (String(E).length - 2);

function gaussianElimination() {
  for (let i = 0; i < A.length; i++) {
    for (let j = 0; j < A.length; j++) {
      if (i !== j) {
        let temp = A[j][i] / A[i][i];
        for (let k = 0; k < A.length + 1; k++) {
          A[j][k] -= temp * A[i][k];
        }
      }
    }
  }
}

function getResult() {
  let x = [];
  for (let i = 0; i < A.length; i++) {
    x.push(Math.round((A[i][3] / A[i][i]) * prec) / prec);
  }
  return x;
}

function solve() {
  gaussianElimination();
  x = getResult();
  return x;
}
res = solve();
console.log(...res);

// Result is: 1.3309, 0.6931, 1.8022
