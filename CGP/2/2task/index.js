document.getElementById('fileInput').addEventListener('change', handleFileSelect, false);
const canvas = document.querySelector('canvas');
let ctx1 = canvas.getContext('2d');

function handleFileSelect(event) {
	const reader = new FileReader();
	reader.onload = handleFileLoad;
	reader.readAsArrayBuffer(event.target.files[0]);
}

function handleFileLoad(e) {
	console.log(e.target.result);
	let bitmap = getBMP(e.target.result);
	let imageData = convertToImageData(bitmap);
	ctx1.putImageData(imageData, 0, 0);
}

function getBMP(buffer) {
	let datav = new DataView(buffer);
	let bitmap = {};
	bitmap.fileheader = {};
	bitmap.fileheader.bfType = datav.getUint16(0, true);
	bitmap.fileheader.bfSize = datav.getUint32(2, true);
	bitmap.fileheader.bfReserved1 = datav.getUint16(6, true);
	bitmap.fileheader.bfReserved2 = datav.getUint16(8, true);
	bitmap.fileheader.bfOffBits = datav.getUint32(10, true);
	bitmap.infoheader = {};
	bitmap.infoheader.biSize = datav.getUint32(14, true);
	bitmap.infoheader.biWidth = datav.getUint32(18, true);
	bitmap.infoheader.biHeight = datav.getUint32(22, true);
	bitmap.infoheader.biPlanes = datav.getUint16(26, true);
	bitmap.infoheader.biBitCount = datav.getUint16(28, true);
	bitmap.infoheader.biCompression = datav.getUint32(30, true);
	bitmap.infoheader.biSizeImage = datav.getUint32(34, true);
	bitmap.infoheader.biXPelsPerMeter = datav.getUint32(38, true);
	bitmap.infoheader.biYPelsPerMeter = datav.getUint32(42, true);
	bitmap.infoheader.biClrUsed = datav.getUint32(46, true);
	bitmap.infoheader.biClrImportant = datav.getUint32(50, true);
	let start = bitmap.fileheader.bfOffBits;
	bitmap.stride =
		Math.floor((bitmap.infoheader.biBitCount * bitmap.infoheader.biWidth + 31) / 32) * 4;
	bitmap.pixels = new Uint8Array(buffer, start);
	return bitmap;
}

function convertToImageData(bitmap) {
	let ctx = canvas.getContext('2d');
	let Width = bitmap.infoheader.biWidth;
	let Height = bitmap.infoheader.biHeight;
	let imageData = ctx.createImageData(Width, Height);
	let data = imageData.data;
	let bmpdata = bitmap.pixels;
	let stride = bitmap.stride;

	for (let y = 0; y < Height; ++y) {
		for (let x = 0; x < Width; ++x) {
			let index1 = (x + Width * (Height - y)) * 4;
			let index2 = x * 3 + stride * y;
			data[index1] = bmpdata[index2 + 2];
			data[index1 + 1] = bmpdata[index2 + 1];
			data[index1 + 2] = bmpdata[index2];
			data[index1 + 3] = 255;
		}
	}
	return imageData;
}
