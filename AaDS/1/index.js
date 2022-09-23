function fact(n) {
	if (n < 0) return 0;
	let res = 1;
	for (let i = 1; i <= n; i++) {
		res *= i;
	}
	return res;
}

function factTree(n) {
	if (n < 0) return 0;
	if (n === 0) return 1;
	if (n === 1 || n === 2) return n;
	function prodTree(l, r) {
		if (l > r) return 1;
		if (l === r) return l;
		if (r - l === 1) return l * r;
		let m = Math.round((l + r) / 2);
		return prodTree(l, m) * prodTree(m + 1, r);
	}
	return prodTree(2, n);
}

console.log(fact(50));
console.log(factTree(50));
