let A = [
  [4.4, -2.5, 19.2, -10.8, 4.3],
  [5.5, -9.3, -14.2, 13.2, 6.8],
  [7.1, -11.5, 5.3, -6.7, -1.8],
  [14.2, 23.4, -8.8, 5.3, 7.2],
];

function gaussianElimination() {
  for (let i = 0; i < 4; i++) {
    for (let j = i + 1; j < 4; j++) {
      let c = A[j][i] / A[i][i];
      for (let k = i + 1; k < 5; k++) {
        A[j][k] = A[j][k] - A[i][k] * c;
      }
      A[j][i] = 0;
    }
  }
}

function createDiagonalMatrix() {
  for (let i = 3; i >= 0; i--) {
    let x = A[i][4] / A[i][i];
    for (let j = i - 1; j >= 0; j--) {
      A[j][4] -= x * A[j][i];
      A[j][i] = 0;
    }
    A[i][4] = x;
    A[i][i] = 1;
  }
}

function getResult() {
  let x = [];
  for (let i = 0; i < 4; i++) {
    x.push(Math.round(A[i][4] * 1000) / 1000);
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

// Result is: 0.445 0.067 0.869 1.312
