package br.com.webfinance.util;

public class Error {

	private String error;

	private int code;

	public Error(int code, String error) {
		this.code = code;
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
