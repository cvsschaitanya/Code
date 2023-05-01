package com.BookVendorMachine.vendingMachine;

public class InvalidPasswordException extends Exception {
	int PassStatus = 0;
	public InvalidPasswordException(int PassStatus) {
		this.PassStatus = PassStatus;
	}
	public String printPassError() {
		String msg = null;
		if(PassStatus == 1) {
			msg = "INVALID PASSWORD";
		}
		return msg;
	}

}
