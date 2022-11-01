"use strict";
/*
Багдя Павел. Группа 21, вариант 1
Задание: 1. Используя схему Гаусса, решить систему уравнений с точностью до 0,001.
Result is: 1.312 0.869 0.066 0.443
*/
const fs = require('fs');
const path = require('path');
let n = 10;
let E = 0.0001;
let e = 10 ** (String(E).length - 2);
function array_fill(n) {
    let a = [];
    for (let i = 1; i <= n; i++) {
        let temp = [];
        for (let j = 1; j <= n; j++) {
            temp.push(1 + (1 - 1 / i) ** j);
        }
        temp.push(1 / i);
        console.log(temp);
        a.push(temp);
    }
    console.log(a);
    return a;
}
function gauss(A) {
    let n = A.length;
    for (let i = 0; i < n; i++) {
        // Search for maximum in this column
        let maxEl = Math.abs(A[i][i]), maxRow = i;
        for (let k = i + 1; k < n; k++) {
            if (Math.abs(A[k][i]) > maxEl) {
                maxEl = Math.abs(A[k][i]);
                maxRow = k;
            }
        }
        // Swap maximum row with current row (column by column)
        for (let k = i; k < n + 1; k++) {
            let tmp = A[maxRow][k];
            A[maxRow][k] = A[i][k];
            A[i][k] = tmp;
        }
        // Make all rows below this one 0 in current column
        for (let k = i + 1; k < n; k++) {
            let c = A[k][i] / A[i][i];
            for (let j = i; j < n + 1; j++) {
                if (i === j) {
                    A[k][j] = 0;
                }
                else {
                    A[k][j] -= c * A[i][j];
                }
            }
        }
    }
    console.log(A);
    // Solve equation Ax=b for an upper triangular matrix A
    let x = new Array(n).fill(0);
    x[n - 1] = A[n - 1][n] / A[n - 1][n - 1];
    for (let i = n - 2; i > -1; i--) {
        x[i] = A[i][n];
        for (let j = i + 1; j < n; j++) {
            x[i] = x[i] - A[i][j] * x[j];
        }
        x[i] = x[i] / A[i][i];
    }
    return x;
}
function getResult(n, text) {
    let A = [];
    A = array_fill(n);
    let res = gauss(A);
    console.log(res);
}
getResult(7, 1);
