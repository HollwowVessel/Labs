const configuration = require('./read/readConfiguration');
const commands = require('./read/readCommands');

let memory = new Array(255 - commands.length);

function checkNum(num) {
	if (num > 128 || num < -128) {
		throw `INCORRECT NUMBER ${num}`;
	}
}

function checkAddress(addr) {
	if (addr > 255 || addr < 0) {
		throw `INCORRECT ADDRESS ${addr}`;
	}
}

memory.unshift(...commands);
let [x, y] = [0, 0];
let res = [];
let controlUnit = 0;
let counter = 0;
let busy = false;
while (memory[0] !== 0) {
	let pointer = memory[0];
	let instructionCode = memory[pointer];
	if (controlUnit !== 0 && instructionCode !== 9) {
		throw 'REQUESTED VALUE WAS NOT RETRIEVED FROM MANIPULATOR';
	}
	switch (instructionCode) {
		case 1: {
			let size = 3;
			memory[0] += size;
			let ADDR = memory[pointer + 1];
			let NUM = memory[pointer + 2];
			checkAddress(ADDR);
			checkNum(NUM);
			memory[ADDR] = NUM;
			break;
		}
		case 2: {
			let size = 3;
			memory[0] += size;
			let ADDR1 = memory[pointer + 1];
			let ADDR2 = memory[pointer + 2];
			checkAddress(ADDR1);
			checkAddress(ADDR2);
			memory[ADDR1] = memory[ADDR2];
			break;
		}
		case 3: {
			let size = 4;
			memory[0] += size;
			let ADDR1 = memory[pointer + 1];
			let NUM = memory[pointer + 2];
			let ADDR2 = memory[pointer + 3];
			checkNum(NUM);
			checkAddress(ADDR1);
			checkAddress(ADDR2);
			memory[ADDR2] = memory[ADDR1] === 0 ? NUM : memory[ADDR2];
		}
		case 4: {
			let size = 4;
			memory[0] += size;
			let ADDR1 = memory[pointer + 1];
			let ADDR2 = memory[pointer + 2];
			let ADDR3 = memory[pointer + 3];
			checkAddress(ADDR1);
			checkAddress(ADDR2);
			checkAddress(ADDR3);
			memory[ADDR1] = memory[ADDR3] === 0 ? memory[ADDR2] : memory[ADDR1];
		}
		case 5: {
			let size = 4;
			memory[0] += size;
			let ADDR1 = memory[pointer + 1];
			let NUM = memory[pointer + 2];
			let ADDR2 = memory[pointer + 3];
			checkAddress(ADDR1);
			checkAddress(ADDR2);
			checkNum(NUM);
			memory[ADDR1] = memory[ADDR2] > 0 ? NUM : memory[ADDR1];
		}
		case 6: {
			let size = 4;
			memory[0] += size;
			let ADDR1 = memory[pointer + 1];
			let ADDR2 = memory[pointer + 2];
			let ADDR3 = memory[pointer + 3];
			checkAddress(ADDR1);
			checkAddress(ADDR2);
			checkAddress(ADDR3);
			memory[ADDR1] = memory[ADDR3] > 0 ? memory[ADDR2] : memory[ADDR1];
		}
		case 7: {
			let size = 3;
			memory[0] += size;
			let ADDR1 = memory[pointer + 1];
			let ADDR2 = memory[pointer + 2];
			checkAddress(ADDR1);
			checkAddress(ADDR2);
			memory[ADDR1] = memory[ADDR1] + memory[ADDR2] > 255 ? 255 : memory[ADDR1] + memory[ADDR2];
			break;
		}
		case 8: {
			let size = 3;
			memory[0] += size;
			let ADDR1 = memory[pointer + 1];
			let ADDR2 = memory[pointer + 2];
			checkAddress(ADDR1);
			checkAddress(ADDR2);
			memory[ADDR1] = memory[ADDR1] - memory[ADDR2] < -128 ? -128 : memory[ADDR1] - memory[ADDR2];
			break;
		}
		case 9: {
			let size = 2;
			memory[0] += size;
			let ADDR = memory[pointer + 1];
			let res = 0;
			checkAddress(ADDR);
			if (!(controlUnit === 1 || controlUnit === 2 || controlUnit === 3 || controlUnit === 10)) {
				throw 'THERE IS NO REQUESTED VALUE IN MANIPULATOR';
			} else {
				switch (controlUnit) {
					case 1: {
						res = x;
					}
					case 2: {
						res = y;
					}
					case 3: {
						res = memory[x][y] === 1 ? 1 : 0;
					}
					case 10: {
						res = busy ? 1 : 0;
					}
				}
			}
			memory[ADDR] = res;
			controlUnit = 0;
			break;
		}
		case 10: {
			let size = 2;
			memory[0] += size;
			let NUM = memory[pointer + 1];
			if (NUM > 10 || NUM < 0) {
				throw `INCORRECT OPERATION NUMBER ${NUM}`;
			}
			if (controlUnit !== 0) {
				throw 'REQUESTED VALUE WAS NOT RETRIEVED FROM MANIPULATOR';
			}
			if (!(NUM === 1 || NUM === 2 || NUM === 3 || NUM === 10)) {
				switch (NUM) {
					case 4: {
						if (x !== -10) {
							x -= 1;
						} else {
							throw 'INCORRECT GRAB POSITION';
						}
						break;
					}
					case 5: {
						if (x !== 10) {
							x += 1;
						} else {
							throw 'INCORRECT GRAB POSITION';
						}
						break;
					}
					case 6: {
						if (y !== -10) {
							y -= 1;
						} else {
							throw 'INCORRECT GRAB POSITION';
						}
						break;
					}
					case 7: {
						if (y !== 10) {
							y += 1;
						} else {
							throw 'INCORRECT GRAB POSITION';
						}
						break;
					}
					case 8: {
						if (configuration[11 - x][11 - y] !== 1) {
							throw 'THERE IS NO COMPONENT IN TRAY';
						}
						if (busy) {
							throw 'GRAB IS NOT FREE';
						}
						configuration[11 - x][11 - y] = 0;
						busy = true;
						break;
					}
					case 9: {
						if (configuration[11 - x][11 - y] === 1) {
							throw 'TRAY IS NOT FREE';
						}
						if (!busy) {
							throw 'THERE IS NO COMPONENT IN GRAB';
						}
						configuration[11 - x][11 - y] = 1;
						busy = false;
						break;
					}
				}
				break;
			}
			controlUnit = NUM;
			break;
		}
		case 11: {
			let size = 1;
			memory[0] += size;
			let counter = 0;
			for (let item of configuration) {
				for (let i of item) {
					if (i === 1) counter++;
				}
			}
			for (let i = 0; i < 21; i++) {
				for (let j = 0; j < 21; j++) {
					if (counter > 0) {
						configuration[i][j] = 1;
						counter--;
					} else {
						configuration[i][j] = 0;
					}
				}
			}
			break;
		}
		case 12: {
			// jump
			let size = 2;
			memory[0] += size;
			let ADDR = memory[pointer + 1];
			checkAddress(ADDR);
			memory[0] = ADDR;
		}
		case 13: {
			// jump if greater
			let size = 2;
			memory[0] += size;
			let ADDR = memory[pointer + 1];
			checkAddress(ADDR);
			memory[0] = counter ? ADDR : memory[0];
		}
		default: {
			throw `INCORRECT INSTRUCTION CODE ${memory[memory[0]]} ON ADDRESS ${memory[0]}`;
		}
	}
}

for (let item of configuration) {
	console.log(item.join(' '));
}