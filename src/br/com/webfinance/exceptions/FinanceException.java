package br.com.webfinance.exceptions;

public class FinanceException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public FinanceException() {
        super();
    }
	
	public FinanceException(String e) {
		super(e);
	}

}
