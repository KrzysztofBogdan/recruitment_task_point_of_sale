package pl.kb.pos;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutTest {

	final Barcode correctBarcode = new Barcode("1010");

	@Test
	public void shouldDisplayInvalidBarcodeWhenBarcodeIsEmpty() {
		// given
		Barcode emptyBarcode = new Barcode("");
		Display display = mock(Display.class);

		Checkout checkout = new Checkout(display, null, null);
		// when
		checkout.onScan(emptyBarcode);
		// then
		verify(display).showInvalidBarcode();
	}

	@Test
	public void shouldDisplayProductNotFoundWhenBarcodeIsNotInDatabase() {
		// given
		Barcode barcodeNotInDatabase = correctBarcode;
		Display display = mock(Display.class);
		ProductDao productDao = new SingleProductDao(null);

		Checkout checkout = new Checkout(display, null, productDao);
		// when
		checkout.onScan(barcodeNotInDatabase);
		// then
		verify(display).showProductNotFound();
	}

	@Test
	public void shouldDisplayProductInfoByBarcode() {
		// given
		Barcode barcode = correctBarcode;
		Display display = mock(Display.class);
		ProductDao productDao = new SingleProductDao(Product.EMPTY);

		Checkout checkout = new Checkout(display, null, productDao);
		// when
		checkout.onScan(barcode);
		// then
		verify(display).showPoductInfo(Product.EMPTY);
	}

	@Test
	public void shouldShowTotalPriceOnExit() {
		// given
		Printer printer = mock(Printer.class);
		Display display = mock(Display.class);
		Checkout checkout = new Checkout(display, printer, null);
		// when
		checkout.onExit();
		// then
		verify(display).showTotalPrice(any(Products.class));
	}

	@Test
	public void shouldPrintProductsOnExit() {
		// given
		InMemoryPrinter printer = new InMemoryPrinter();
		ProductDao productDao = new SingleProductDao(Product.EMPTY);
		Checkout checkout = new Checkout(mock(Display.class), printer, productDao);
		// when
		checkout.onScan(correctBarcode);
		checkout.onExit();
		// then
		assertThat(printer).contains(Product.EMPTY);
	}

}
