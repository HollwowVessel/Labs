'use strict';
let A = [
  [3.14, -0.12, 1.17],
  [-0.12, 2.32, -1.45],
  [1.17, -1.45, 5.18],
];
let e = 0.001;
let E = 10 ** (String(e).length - 2);
let B = [1.27, 2.13, 3.14];
function cholesky(A, B) {
  let n = A.length;
  let L = [
    [0, 0, 0],
    [0, 0, 0],
    [0, 0, 0],
  ];
  for (let i = 0; i < n; i++) {
    for (let k = 0; k < i + 1; k++) {
      let tmpSum = 0;
      for (let j = 0; j < k; j++) {
        tmpSum += L[i][j] * L[k][j];
      }
      if (i === k) {
        L[i][k] = Math.sqrt(A[i][i] - tmpSum);
      } else {
        L[i][k] = (1 / L[k][k]) * (A[i][k] - tmpSum);
      }
    }
  }
  return L;
}
function tr(A) {
  let temp = [
    [0, 0, 0],
    [0, 0, 0],
    [0, 0, 0],
  ];
  for (let i = 0; i < A.length; i++) {
    for (let j = 0; j < A.length; j++) {
      temp[i][j] = A[j][i];
    }
  }
  return temp;
}
function findY(A) {
  let y = [B[0] / A[0][0]];
  for (let i = 1; i < A.length; i++) {
    let sum = 0;
    for (let k = 0; k < i; k++) {
      sum += A[i][k] * y[k];
    }
    y[i] = (B[i] - sum) / A[i][i];
  }
  return y;
}

function findX(y, t) {
  let x = [0, 0, y[A.length - 1] / t[t.length - 1][t.length - 1]];
  for (let i = 1; i < A.length; i++) {
    let sum = 0;
    for (let k = i + 1; k < A.length; k++) {
      sum += t[i][k] * x[k];
    }
    x[i] = Math.round(((y[i] - sum) / t[i][i]) * E) / E;
  }
  let x1 =
    Math.round(((y[0] - t[0][1] * x[1] - t[0][2] * x[2]) / t[0][0]) * E) / E;
  x.shift();
  x.unshift(x1);
  console.log(x);
}

let t = cholesky(A);
let y = findY(t);
let x = findX(y, tr(t));
