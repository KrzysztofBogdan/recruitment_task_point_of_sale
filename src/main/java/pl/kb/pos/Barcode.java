package pl.kb.pos;

class Barcode {
	final String barcode;

	Barcode(String barcode) {
		this.barcode = barcode;
	}

	boolean isEmpty() {
		return barcode.isEmpty();
	}
}
