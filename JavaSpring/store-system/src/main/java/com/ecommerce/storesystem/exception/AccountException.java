package com.ecommerce.storesystem.exception;

public class AccountException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// ACCOUNT NOT FOUND
	public AccountException(String username) {
		super(String.format("Invalid username or password"));
	}
}
