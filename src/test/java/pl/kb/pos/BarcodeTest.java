package pl.kb.pos;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BarcodeTest {

	@Test
	public void shouldCheckThatBarcodeIsEmpty() {
		// given
		Barcode barcode = new Barcode("");
		// when
		boolean empty = barcode.isEmpty();
		// then
		assertThat(empty).isTrue();
	}

	@Test
	public void shouldCheckThatBarcodeIsNotEmpty() {
		// given
		Barcode barcode = new Barcode("1010");
		// when
		boolean empty = barcode.isEmpty();
		// then
		assertThat(empty).isFalse();
	}
}
