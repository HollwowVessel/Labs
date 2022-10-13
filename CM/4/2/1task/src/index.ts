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
let E = 0.001;
let prec = 10 ** (String(E).length - 2);

function jordanoElimination() {
  let res = [];
  for (let i = 0; i < A.length; i++) {
    let temp = A[i][i];
    res.push(temp);
    for (let k = 0; k < A.length; k++) {
      A[i][k] = A[i][k] / temp;
    }
    for (let j = 0; j < A.length; j++) {
      if (i !== j) {
        let temp = A[j][i];
        for (let k = 0; k < A.length; k++) {
          A[j][k] -= temp * A[i][k];
        }
      }
    }
  }
  return res;
}

function getDet(det: number[]) {
  let res = 1;
  for (let i = 0; i < det.length; i++) {
    res = res * det[i];
  }
  return res;
}

function solve() {
  let det = jordanoElimination();
  let determinant = Math.round(getDet(det) * prec) / 1000;
  console.log(determinant);
  return [];
}
let res = solve();

// Result is: 0.286
