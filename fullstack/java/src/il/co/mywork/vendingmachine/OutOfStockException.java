package il.co.mywork.vendingmachine;

public class OutOfStockException extends Exception {
	public OutOfStockException(String message) {
		super(message);
	}
}
