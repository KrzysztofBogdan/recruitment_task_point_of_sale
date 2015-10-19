package pl.kb.pos;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


public class ProductsTest {

	@Test
	public void shouldCountTotalPrice() throws Exception {
		// given
		Products products = new Products(productsWithPrice(1.0f, 2.0f, 4.0f));

		// when
		float totalPrice = products.getTotalPrice();

		// then
		assertThat(totalPrice).isEqualTo(7.0f);
	}

	List<Product> productsWithPrice(float... prices) {
		List<Product> products = new ArrayList<>();
		for (float price : prices) {
			products.add(new Product("", price, new Barcode("")));
		}
		return products;
	}
}