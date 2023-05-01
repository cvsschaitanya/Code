package com.BookVendorMachine.vendingMachine;

import java.util.*;

import com.BookVendorMachine.book.Book;

public class VendingMachine {
	
	private List<Book> shelf;
	private double locationFactor;
	private int cassette;
	private int safe;
	private String password;

	public VendingMachine(double locationFactor,String password) {
		// TODO Auto-generated constructor stub
		this.locationFactor = locationFactor;
		this.password = password;
		cassette = 0;
		safe = 0;
		List<Book> shelf = new ArrayList<Book>();
	}
	
//	private String getPassword() {
//		return password;
//	}
//	
	
	public int getCassette() {
		return cassette;
	}
	public void insertCoin(int coin) throws IllegalArgumentException{
		try {
			if(coin == 1||coin ==2||coin ==5||coin ==10||coin ==20||coin ==50||coin ==100||coin ==200)
			cassette += coin;
		}catch(Exception e) {
			System.out.println("Invalid denomination");
			System.out.println(e);
		}
	}
	public int returnCoins() {
		cassette = 0;
		return cassette;
	}
	public void restock(List<Book> books, String Password) throws InvalidPasswordException {
		if(Password != password) {
			throw new InvalidPasswordException(1);
		}
		else {
			shelf.addAll(books);
		}
	}
	
	public int emptySafe(String Password) throws InvalidPasswordException {
		int temp;
		if(Password != password) {
			throw new InvalidPasswordException(1);
		}
		else {
			temp = safe;
			safe = 0;
		}
		return temp;
	}
	
	public List<String> getCatalogue(){
		List<String> catalogue = new ArrayList<String>();;
		for(Book tempShelf:shelf) {
			catalogue.add(tempShelf.toString());
		}
		return catalogue;
	}
	public int getPrice(int index) throws IndexOutOfBoundsException {
		int price = 0;
		try {
			Book tempBook = shelf.get(index);
			price = (int) Math.ceil((tempBook.getPages())*locationFactor);
		}catch(Exception e) {
			System.out.println(e);
		}
		return price;
	}
	
	public Book buyBook(int index) throws IndexOutOfBoundsException,CassetteException {
		Book tempBook = shelf.get(index);
		Book saleBook = null;
		try {
			int tempPrice = getPrice(index);
			int tempCassette = getCassette();
			if(tempPrice <= tempCassette) {
				saleBook = tempBook;
				shelf.remove(index);
				cassette -= tempPrice;
				safe += tempPrice;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return saleBook;
	}

}
