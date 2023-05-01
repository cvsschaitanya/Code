package com.BookVendorMachine.press;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

import com.BookVendorMachine.book.Book;

public class Press {
	
	private Map<String,List<Book>> shelf = new HashMap<>();
	private int shelfSize;
	private Map<String, Integer> edition = new HashMap<>();

	public Press(String pathToBookDir, int shelfSize) {
		File directory = new File(pathToBookDir);
		File[] contentsOfDirectory = directory.listFiles();
		try {
			for(File object:contentsOfDirectory) {
				if(object.isFile() ) {
					throw new FileNotFoundException();
				}
				if(object.isFile() && shelfSize!=0) {
					List<Book> tempBook = new ArrayList<Book>();
					shelf.put(object.getName(), tempBook);
					edition.put(object.getName(), 0);
					shelfSize--;
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	protected Book print(String bookDir, int edition)throws IlleagalArgumentsException {
		
	}
}
		
