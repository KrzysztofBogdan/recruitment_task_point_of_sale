package pl.kb.pos;

interface Display {
	void showProductNotFound();

	void showInvalidBarcode();

	void showPoductInfo(Product product);

	void showTotalPrice(Products products);
}
