let A = [
  [0.34, 0.71, 0.63, 2.08],
  [0.71, -0.65, -0.18, 0.17],
  [1.17, -2.35, 0.75, 1.28],
];

function gaussianElimination() {
  for (let i = 0; i < 3; i++) {
    for (let j = i + 1; j < 3; j++) {
      let c = A[j][i] / A[i][i];
      for (let k = i + 1; k < 4; k++) {
        A[j][k] = A[j][k] - A[i][k] * c;
      }
      A[j][i] = 0;
    }
  }
}

function createDiagonalMatrix() {
  for (let i = 2; i >= 0; i--) {
    let x = A[i][3] / A[i][i];
    for (let j = i - 1; j >= 0; j--) {
      A[j][3] -= x * A[j][i];
      A[j][i] = 0;
    }
    A[i][3] = x;
    A[i][i] = 1;
  }
}

function getResult() {
  let x = [];
  for (let i = 0; i < 3; i++) {
    x.push(Math.round(A[i][3] * 1000) / 1000);
  }
  return x;
}

function solve() {
  gaussianElimination();
  createDiagonalMatrix();
  let x = getResult();
  return x;
}

let x = solve(A);

console.log(...x);

// Result is: 1.331, 0.693, 1.802
