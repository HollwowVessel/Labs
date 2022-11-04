/**Методом Зейделя решить с точностью 0.001 систему линейных уравнений, приведя ее к виду, удобному для итераций.
 * Багдя Павел, Вариант 1
 */

let A = [
  [2.7, 0.3, 1.3],
  [0.5, -3.7, 2.8],
  [1.1, 2.8, -5.8],
];
let B = [2.1, 1.7, 0.8];

function seidel(A, B) {
  let n = A.length;
  let x = [0, 0, 0];
  let converge = false;
  while (!converge) {
    let temp = [...x];
    for (let i = 0; i < n; i++) {
      let s1 = 0;
      let s2 = 0;
      for (let j = 0; j < i; j++) {
        s1 += A[i][j] * temp[j];
      }
      for (let j = i + 1; j < n; j++) {
        s2 += A[i][j] * x[j];
      }
      temp[i] = (B[i] - s1 - s2) / A[i][i];
    }
    let sum = 0;
    for (let i = 0; i < n; i++) {
      sum += (temp[i] - x[i]) ** 2;
    }
    converge = Math.sqrt(sum) <= 0.001;
    x = [...temp];
  }
  console.log(x);
}
seidel(A, B);
