package pl.kb.pos;

interface ProductDao {
	Product findProduct(Barcode barcode);
}
