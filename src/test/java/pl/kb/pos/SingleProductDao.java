package pl.kb.pos;

public class SingleProductDao implements ProductDao {
	private final Product product;

	public SingleProductDao(Product product) {
		this.product = product;
	}

	@Override
	public Product findProduct(Barcode barcode) {
		return product;
	}
}
