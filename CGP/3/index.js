let text = 'tobeornottobe'.toLowerCase();
let n = 3;
let start = 0;
let input = '';
let buffer = text.slice(0, n);
let dict = {};
let d, l, c;
while (input.length < text.length) {
	let match = occurence(input, buffer);
	if (match && match.length > 1) {
		d = input.split('').reverse().indexOf(match[0]) + 1;
		l = match.length;
		c = match;
	} else {
		d = 0;
		l = 1;
		c = buffer[0];
	}
	dict[c] = [d, l, c];
	start += l;
	n += l;
	input += c;
	buffer = text.slice(start, n);
}
console.log(dict);
let res = '';
for (let item of Object.keys(dict)) {
	res += item;
}
console.log(res);
function occurence(input, text) {
	if (!dict[text[0]]) {
		return text[0];
	} else {
		let res = '';
		for (let i of text) {
			if (!dict[res + i]) {
				return res + i;
			} else {
				res += i;
			}
		}
	}
}
