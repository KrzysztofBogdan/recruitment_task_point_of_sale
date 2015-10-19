package pl.kb.pos;

class Product {
	private String name;
	private float price;
	private Barcode barcode;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Barcode getBarcode() {
		return barcode;
	}
	public void setBarcode(Barcode barcode) {
		this.barcode = barcode;
	}
}
