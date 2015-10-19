package pl.kb.pos;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class BarcodeTest {

	@Test
	public void shouldReturnThatBarcodeIsEmpty() {
		// given
		Barcode barcode = new Barcode("");
		// when
		boolean empty = barcode.isEmpty();
		// then
		assertThat(empty).isTrue();
	}

	@Test
	public void shouldReturnThatBarcodeIsNotEmpty() {
		// given
		Barcode barcode = new Barcode("1010");
		// when
		boolean empty = barcode.isEmpty();
		// then
		assertThat(empty).isFalse();
	}
}
