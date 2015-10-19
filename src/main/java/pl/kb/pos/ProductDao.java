package pl.kb.pos;

interface ProductDao {
	Product findProductByBarcode(Barcode barcode);
}
