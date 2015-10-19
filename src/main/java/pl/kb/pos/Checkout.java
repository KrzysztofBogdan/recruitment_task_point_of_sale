package pl.kb.pos;

class Checkout implements BarcodeScannerListener {
	private final Products products = new Products();
	private final Display display;
	private final Printer printer;
	private final ProductDao productDao;

	Checkout(Display display, Printer printer, ProductDao productDao) {
		this.display = display;
		this.printer = printer;
		this.productDao = productDao;
	}

	@Override
	public void onScan(Barcode barcode) {
		if (barcode.isEmpty()) {
			display.showInvalidBarcode();
		} else {
			showProduct(barcode);
		}
	}

	void showProduct(Barcode barcode) {
		Product product = productDao.findProduct(barcode);
		if (product == null) {
			display.showProductNotFound();
		} else {
			display.showPoductInfo(product);
			products.add(product);
		}
	}

	void onExit() {
		display.showTotalPrice(products);
		printer.print(products);
	}

}