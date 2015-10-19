package pl.kb.pos;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class BarcodeScannerTest {
	@Test
	public void shouldInvokeListenerOnBarcodeScanning() {
		// given
		Barcode barcode = new Barcode("1010");
		BarcodeScanner barcodeScanner = new BarcodeScanner();
		BarcodeScannerListener barcodeScannerListener = mock(BarcodeScannerListener.class);
		barcodeScanner.setBarcodeScannerListener(barcodeScannerListener);
		// when
		barcodeScanner.scanned(barcode);
		// then
		verify(barcodeScannerListener).onScan(barcode);
	}
}
