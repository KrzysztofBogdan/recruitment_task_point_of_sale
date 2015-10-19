package pl.kb.pos;

import java.util.Iterator;

public class InMemoryPrinter implements Printer, Iterable {

	Products printed = null;

	@Override
	public void print(Products products) {
		printed = products;
	}

	@Override
	public Iterator iterator() {
		return printed.getCollection().iterator();
	}
}
