const exp = (function () {
	let readLine = require('readline-sync');

	let buyerSum = 0;
	let N = readLine.question('Input quantity of coins from buyer: ');
	checkNum(N);
	if (N < 0) {
		throw 'Количество не может быть меньше 0';
	}
	let coinsOfBuyer = [];

	for (let i = 0; i < N; i++) {
		coinsOfBuyer[i] = readLine.question(`A(${i + 1})= `);
		checkNum(coinsOfBuyer[i]);
		if (coinsOfBuyer <= 0) {
			throw 'Монета не может равняться или быть меньше 0';
		}
		buyerSum += +coinsOfBuyer[i];
	}

	let sellerSum = 0;
	let M = readLine.question(`Input quantity of coins from seller: `);
	checkNum(M);
	if (M < 0) {
		throw 'Количество не может быть меньше 0';
	}
	let coinsOfSeller = [];

	for (let i = 0; i < M; i++) {
		coinsOfSeller[i] = readLine.question(`B(${i + 1})= `);
		checkNum(coinsOfSeller[i]);
		if (coinsOfSeller[i] <= 0) {
			throw 'Монета не может равняться или быть меньше 0';
		}
		sellerSum += +coinsOfSeller[i];
	}

	let S = +readLine.question('Input the total sum: ');
	checkNum(S);
	if (S < 0 || S > buyerSum) {
		console.log('Покупка невозможна');
		return 0;
	}
	coinsOfBuyer.sort((a, b) => a - b);
	coinsOfSeller.sort((a, b) => a - b);

	let buyerRes = [];
	let tempS = S;

	for (let i = coinsOfBuyer.length - 1; i >= 0; i--) {
		if (tempS <= 0) {
			break;
		} else {
			buyerRes.push(+coinsOfBuyer[i]);
			tempS -= coinsOfBuyer[i];
		}
	}

	if (!buyerRes.length) {
		for (let i = 0; i < coinsOfBuyer.length; i++) {
			if (tempS <= 0) {
				break;
			} else {
				buyerRes.push(+coinsOfBuyer[i]);
				tempS -= coinsOfBuyer[i];
			}
		}
	}

	let totalBuyerSum = buyerRes.reduce((a, b) => a + b, 0);
	if (Math.abs(totalBuyerSum - S) > sellerSum) {
		console.log('Покупка невозможна');
		return 0;
	}
	let sellerRes = [];
	totalBuyerSum -= S;
	for (let i = coinsOfSeller.length - 1; i >= 0; i--) {
		if (coinsOfSeller[i] > totalBuyerSum) {
			continue;
		} else if (totalBuyerSum <= 0) {
			break;
		} else {
			sellerRes.push(+coinsOfSeller[i]);
			totalBuyerSum -= coinsOfSeller[i];
		}
	}

	if (!sellerRes.length) {
		for (let i = 0; i < coinsOfSeller.length; i++) {
			if (totalBuyerSum <= 0) {
				break;
			} else {
				sellerRes.push(+coinsOfSeller[i]);
				totalBuyerSum -= coinsOfSeller[i];
			}
		}
	}

	console.log(sellerRes, buyerRes);
	function checkNum(num) {
		if (isNaN(+num)) {
			throw 'Не число!';
		}
		return true;
	}
	//3 1 2 3 3 1 2 3 4
})();
