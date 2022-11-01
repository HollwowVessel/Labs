let A = [
  [3.14, -0.12, 1.17],
  [-0.12, 2.32, -1.45],
  [1.17, -1.45, 5.18],
];
let B = [1.27, 2.13, 3.14];

function cholesky(A: number[][], B: number[]) {
  let n = A.length - 1;
  let d: number[] = new Array(n + 1).fill(0);
  let s: number[][] = new Array(n + 1).fill(new Array(n + 1).fill(0));
  d[1] = Math.sign(A[1][1]);
  s[1][1] = Math.sqrt(Math.abs(A[1][1]));
  for (let j = 2; j <= n; j++) {
    s[1][j] = A[1][j] / (s[1][1] * d[1]);
  }
  for (let i = 2; i <= n; i++) {
    let sum = 0;
    for (let k = 1; k <= i - 1; k++) {
      sum += s[k][i] * s[k][i] * d[k];
    }
    d[i] = Math.sign(A[i][i] - sum);
    s[i][i] = Math.sqrt(Math.abs(A[i][i] - sum));

    let l = 1 / (s[i][i] * d[i]);
    for (let j = i + 1; j <= n; j++) {
      let SDSsum = 0;
      for (let k = 1; k <= i - 1; k++) {
        SDSsum += s[k][i] * d[k] * s[k][j];
      }
      s[i][j] = l * (A[i][j] - SDSsum);
    }
  }
  console.log(A);
  let y: number[] = new Array(n).fill(0);
  for (let i = 2; i <= n; i++) {
    let sum = 0;
    for (let j = 1; j <= i - 1; j++) {
      sum += s[j][j] * d[j] * y[j];
    }
    y[i] = (B[i] - sum) / (s[i][i] * d[i]);
  }
  let x: number[] = new Array(n).fill(0);
  x[n] = y[n] / s[n][n];
  for (let i = n - 1; i >= 1; i--) {
    let sum = 0;
    for (let k = i + 1; k <= n; k++) {
      sum += s[i][k] * x[k];
    }
    x[i] = (y[i] - sum) / s[i][i];
  }
  console.log(x);
}
console.log(cholesky(A, B));
