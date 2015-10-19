package pl.kb.pos;

import java.util.ArrayList;
import java.util.List;

class Products {
	private final List<Product> products = new ArrayList<Product>();

	Iterable<Product> getProducts() {
		return products;
	}

	boolean add(Product product) {
		return products.add(product);
	}

	float getTotalPrice() {
		float totalPrice = 0.0f;
		for (Product product : products) {
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}

	// VisibleForTesting
	boolean contains(Object o) {
		return products.contains(o);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		return true;
	}

}
