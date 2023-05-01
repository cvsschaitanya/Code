package com.BookVendorMachine.vendingMachine;

public class CassetteException extends Exception {
	int CassetteStatus;
	public CassetteException(int CassetteStatus) {
		this.CassetteStatus = CassetteStatus;
	}
	public String printCassetteError() {
		String msg = null;
		if(CassetteStatus == 1) {
			msg = "PRICE OF BOOK EXCEEDS THE VALUE OF THE CASSETTE!! ";
		}
		return msg;
	}

}
