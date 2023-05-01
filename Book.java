package com.BookVendorMachine.book;

public class Book {
	private String title;
	private String author;
	private String content;
	private int edition;
	
	public String getTitle() {
		return title;
	}

//	public void setTitle(String title) {
//		this.title = title;
//	}

	public String getAuthor() {
		return author;
	}

//	public void setAuthor(String author) {
//		this.author = author;
//	}

	public String getContent() {
		return content;
	}

//	public void setContent(String content) {
//		this.content = content;
//	}

	public int getEdition() {
		return edition;
	}

//	public void setEdition(int edition) {
//		this.edition = edition;
//	}

	public int getPages() {
		int chars = getContent().length();
		double pages = chars/700;
		return (int) Math.ceil(pages);
	}

	public Book(String title, String author, int edition) {
		super();
		this.title = title;
		this.author = author;
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Title: " + title + "\nAuthor: " + author + "\nEdition: " + edition + "\n";
	}
	
	

}
