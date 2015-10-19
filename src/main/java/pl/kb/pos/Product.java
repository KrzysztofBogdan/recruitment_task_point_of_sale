package pl.kb.pos;

class Product {
	static final Product EMPTY = new Product();

	private String name;
	private float price;
	private Barcode barcode;

	public Product() {
	}

	public Product(String name, float price, Barcode barcode) {
		this.name = name;
		this.price = price;
		this.barcode = barcode;
	}

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
