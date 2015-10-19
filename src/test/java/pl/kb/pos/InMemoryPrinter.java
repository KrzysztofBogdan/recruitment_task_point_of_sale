package pl.kb.pos;

public class InMemoryPrinter implements Printer {

	Products printed = null;

	@Override
	public void print(Products products) {
		printed = products;
	}

}
