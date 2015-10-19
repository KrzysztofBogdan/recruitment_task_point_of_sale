package pl.kb.pos;

class Checkout implements BarcodeScannerListener {
	private final Products products = new Products();
	private final Display display;
	private final ProductDao productDao;
	private final Printer printer;

	Checkout(Display display, ProductDao productDao, Printer printer) {
		this.display = display;
		this.productDao = productDao;
		this.printer = printer;
	}

	@Override
	public void onScan(Barcode barcode) {
		if (barcode.isEmpty()) {
			display.displayInvalidBarcode();
		} else {
			Product product = productDao.findProductByBarcode(barcode);
			if (product == null) {
				display.displayProductNotFound();
			} else {
				display.displayPoductInfo(product);
				products.add(product);
			}
		}
	}

	void onExit() {
		display.displayTotalPrice(products);
		printer.print(products);
	}

	// VisibleForTesting
	boolean contains(Product product) {
		return products.contains(product);
	}

}