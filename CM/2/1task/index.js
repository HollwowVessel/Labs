/*
  Багдя Павел. Группа 21, вариант 1
  Задание: 1. Используя схему Гаусса, решить систему уравнений с точностью до 0,001.  
  Result is: 1.312 0.869 0.066 0.443
*/

let A = [
	[4.4, -2.5, 19.2, -10.8, 4.3],
	[5.5, -9.3, -14.2, 13.2, 6.8],
	[7.1, -11.5, 5.3, -6.7, -1.8],
	[14.2, 23.4, -8.8, 5.3, 7.2],
];
let E = 0.0001;
let e = 10 ** (String(E).length - 2);

for (let i = 0; i < 4; i++) {
	for (let j = i + 1; j < 4; j++) {
		let c = Math.round((A[j][i] / A[i][i]) * e) / e;
		for (let k = i + 1; k < 5; k++) {
			A[j][k] = Math.round((A[j][k] - A[i][k] * c) * e) / e;
		}
		A[j][i] = 0;
	}
}
let x1 = Math.round((A[3][4] / A[3][3]) * e) / e;
let x2 = Math.round(((A[2][4] - A[2][3] * x1) / A[2][2]) * e) / e;
let x3 = Math.round(((A[1][4] - A[1][3] * x1 - A[1][2] * x2) / A[1][1]) * e) / e;
let x4 = Math.round(((A[0][4] - A[0][3] * x1 - A[0][2] * x2 - A[0][1] * x3) / A[0][0]) * e) / e;

console.log(x1, x2, x3, x4);
