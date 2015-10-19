package pl.kb.pos;

import java.util.ArrayList;
import java.util.List;

class Products {
	private final List<Product> collection;

	Products() {
		this(new ArrayList<>());
	}

	Products(List<Product> collection) {
		this.collection = collection;
	}

	// To be used by printer
	Iterable<Product> getCollection() {
		return collection;
	}

	boolean add(Product product) {
		return collection.add(product);
	}

	float getTotalPrice() {
		return collection.stream().
				map(p -> p.getPrice()).
				reduce(0.0f, (fst, snd) -> fst + snd);
	}

	// @VisibleForTesting
	boolean contains(Product o) {
		return collection.contains(o);
	}
}
