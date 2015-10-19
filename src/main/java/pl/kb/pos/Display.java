package pl.kb.pos;

interface Display {
	void displayProductNotFound();

	void displayInvalidBarcode();

	void displayPoductInfo(Product product);

	void displayTotalPrice(Products products);
}
