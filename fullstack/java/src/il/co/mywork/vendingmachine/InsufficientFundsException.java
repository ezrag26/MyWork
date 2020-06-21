package il.co.mywork.vendingmachine;

public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String message) {
		super(message);
	}
}
