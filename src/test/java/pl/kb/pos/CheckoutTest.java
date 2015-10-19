package pl.kb.pos;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void shouldDisplayInvalidBarcode() {
		// given
		Barcode barcode = new Barcode("");
		Display display = mock(Display.class);

		Checkout checkout = new Checkout(display, null, null);
		BarcodeScanner barcodeScanner = new BarcodeScanner();
		barcodeScanner.setBarcodeScannerListener(checkout);
		// when
		barcodeScanner.scanned(barcode);
		// then
		verify(display).displayInvalidBarcode();
	}

	@Test
	public void shouldDisplayProductNotFound() {
		// given
		Barcode barcode = new Barcode("1010");
		Display display = mock(Display.class);
		ProductDao productDao = given(mock(ProductDao.class).findProductByBarcode(barcode)).willReturn(null).getMock();

		Checkout checkout = new Checkout(display, productDao, null);
		BarcodeScanner barcodeScanner = new BarcodeScanner();
		barcodeScanner.setBarcodeScannerListener(checkout);
		// when
		barcodeScanner.scanned(barcode);
		// then
		verify(display).displayProductNotFound();
	}

	@Test
	public void shouldDisplayProductData() {
		// given
		Barcode barcode = new Barcode("1010");
		Display display = mock(Display.class);
		Product product = new Product();
		ProductDao productDao = given(mock(ProductDao.class).findProductByBarcode(barcode)).willReturn(product)
				.getMock();

		Checkout checkout = new Checkout(display, productDao, null);
		BarcodeScanner barcodeScanner = new BarcodeScanner();
		barcodeScanner.setBarcodeScannerListener(checkout);
		// when
		barcodeScanner.scanned(barcode);
		// then
		verify(display).displayPoductInfo(product);
	}

	@Test
	public void shouldShowTotalPriceOnExit() {
		// given
		Printer printer = mock(Printer.class);
		Display display = mock(Display.class);
		Checkout checkout = new Checkout(display, null, printer);
		// when
		checkout.onExit();
		// then
		verify(display).displayTotalPrice(new Products());
	}

	@Test
	public void shouldPrintProducts() {
		// given
		Printer printer = mock(Printer.class);
		ProductDao productDao = mock(ProductDao.class);
		Checkout checkout = new Checkout(mock(Display.class), productDao, printer);
		// when
		checkout.onScan(new Barcode("01010"));
		checkout.onExit();
		// then
		verify(printer).print(new Products());
	}

	@Test
	public void shouldCollectProductsOnScan() {
		// given
		Barcode barcode = new Barcode("1010");
		Product product = new Product();
		ProductDao productDao = given(mock(ProductDao.class).findProductByBarcode(barcode)).willReturn(product)
				.getMock();

		Checkout checkout = new Checkout(mock(Display.class), productDao, null);
		BarcodeScanner barcodeScanner = new BarcodeScanner();
		barcodeScanner.setBarcodeScannerListener(checkout);
		// when
		barcodeScanner.scanned(barcode);
		// then
		assertThat(checkout.contains(product)).isTrue();
	}

}
