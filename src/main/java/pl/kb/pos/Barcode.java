package pl.kb.pos;

class Barcode {
	final String value;

	Barcode(String value) {
		this.value = value;
	}

	boolean isEmpty() {
		return value.isEmpty();
	}
}
