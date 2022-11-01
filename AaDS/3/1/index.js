function selectionSort(arr) {
  for (let i = 0, l = arr.length, k = l - 1; i < k; i++) {
    let indexMin = i;
    for (let j = i + 1; j < l; j++) {
      if (arr[indexMin] > arr[j]) {
        indexMin = j;
      }
    }
    if (indexMin !== i) {
      [arr[i], arr[indexMin]] = [arr[indexMin], arr[i]];
    }
  }
  return arr;
}

function insertionSort(arr) {
  let key, j;
  let quantityOfSwaps = 0;
  for (let i = 1; i < arr.length; i++) {
    key = arr[i];
    j = i - 1;
    while (j >= 0 && arr[j] > key) {
      arr[j + 1] = arr[j];
      j -= 1;
      quantityOfSwaps++;
    }
    arr[j + 1] = key;
    quantityOfSwaps++;
  }
  console.log(quantityOfSwaps);
  return arr;
}

function bubleSort(arr) {
  let quantityOfSwaps = 0;
  let quantityOfCompare = 0;
  for (let i = 0; i < arr.length; i++) {
    for (let j = i + 1; j < arr.length; j++) {
      quantityOfCompare++;
      if (arr[i] > arr[j]) {
        [arr[i], arr[j]] = [arr[j], arr[i]];
        quantityOfSwaps++;
      }
    }
  }
  console.log('Compare: ', quantityOfCompare);
  console.log('Swap: ', quantityOfSwaps);
  return arr;
}
let swap = 0;
function quickSort(array, swaps) {
  if (array.length <= 1) {
    return array;
  }
  let pivot = array[0];
  let left = [];
  let right = [];
  for (let i = 1; i < array.length; i++) {
    array[i] < pivot ? left.push(array[i]) : right.push(array[i]);
  }
  swap += 1;
  return quickSort(left).concat(pivot, quickSort(right));
}

let temp = [3, 1, 4, 5, 2, 3, 5, 8, 9, 10, 1];
console.log(merge(temp, temp.length));
