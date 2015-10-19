package pl.kb.pos;

class BarcodeScanner {
	private BarcodeScannerListener barcodeScannerListener;

	void setBarcodeScannerListener(BarcodeScannerListener barcodeScannerListener) {
		this.barcodeScannerListener = barcodeScannerListener;
	}

	void scanned(Barcode barcode) {
		barcodeScannerListener.onScan(barcode);
	}
}
