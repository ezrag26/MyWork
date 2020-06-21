package il.co.mywork.vendingmachine;

public class InvalidPriceException extends Exception {
	public InvalidPriceException(String message) {
		super(message);
	}
}