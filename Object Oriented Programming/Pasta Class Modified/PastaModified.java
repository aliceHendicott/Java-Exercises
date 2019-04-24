package oop.PastaModified;

public class PastaModified {
	// Private properties
	private int price;
	private String type;

	// Constructs a PastaModified object with a price and a type
	public PastaModified(PastaType type) {
		this.type = type.type();
		this.price = type.price();
	}

	// Gets the price of the pasta
	public int price() {
		return price;
	}

	// Gets the type of the pasta
	public String type() {
		return type;
	}
}