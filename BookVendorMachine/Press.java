
import java.util.*;
import java.io.*;
/**
 * Press
 */
public class Press {
	
	private Map<String,List<Book>> shelf = new HashMap<>();
	private int shelfSize;
	private Map<String, Integer> edition = new HashMap<>();
	private Map<String, File> fileObject = new HashMap<>();

	/**
	 * Press
	 */
	public Press(String pathToBookDir, int shelfSize) {
		this.shelfSize = shelfSize;
		File directory = new File(pathToBookDir);
		File[] contentsOfDirectory = directory.listFiles();
		try {
			for(File object:contentsOfDirectory) {
				if(!object.isFile() ) {
					throw new FileNotFoundException();
				}
				if(object.isFile()) {
					List<Book> tempBook = new ArrayList<Book>();
					fileObject.put(object.getName(), object);
					shelf.put(object.getName(), tempBook);
					edition.put(object.getName(), 0);
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}
	}
	/**
	 * Print
	 */
	protected Book print(String bookID, int edition)throws IllegalArgumentException, IOException {
		Book tempBook = null;
		if(shelf.containsKey(bookID)) {
			File file = fileObject.get(bookID);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			String tempTitle = null;
			String tempAuthor = null;
			String tempContent = null;
			
			while ((st = br.readLine()) != null) {
				if(st.startsWith("Title: ") ){
					tempTitle = st.substring(7);
				}
				else if(st.startsWith("Author: ") ){
					tempAuthor = st.substring(8);
				}
				else if(st.startsWith("*** START OF") ){
					tempContent = "";
					while((st = br.readLine()) != null) {
						tempContent += st+"\n";
					}
					tempContent = tempContent.substring(0, tempContent.length()-1);
					break;
				}
			}
			br.close();
			if(tempTitle == null || tempAuthor == null || tempContent == null) throw new IOException();
			tempBook = new Book(tempTitle, tempAuthor, tempContent, edition);
		}
		else {
			throw new IllegalArgumentException();
		}
	
		return tempBook;
			
	}
	
	/**
	 * getCatalogue
	 */
	public List<String> getCatalogue(){
		return  new ArrayList<String>(shelf.keySet());
	}
	
	/**
	 * request
	 */
	public List<Book> request(String bookID, int amount) throws IllegalArgumentException, IOException{
		List<Book> books ;
		if(amount <= shelf.get(bookID).size() ) {
			books = new ArrayList<Book>(shelf.get(bookID).subList(0,amount));
			shelf.put(bookID, new ArrayList<Book>(shelf.get(bookID).subList(amount,shelf.get(bookID).size() )));
			if(shelf.get(bookID).size()<shelfSize) edition.put(bookID, edition.get(bookID)+1);
			while(shelf.get(bookID).size() < shelfSize) {
				shelf.get(bookID).add(print(bookID, edition.get(bookID)));
			}
			
		}
		else {
			books = shelf.get(bookID);
			shelf.put(bookID, new ArrayList<Book>());
			
			while(books.size()<amount){
				books.add(print(bookID, edition.get(bookID)+1));
			}
			
			for(int i=0 ; i<shelfSize; i++) {
				shelf.get(bookID).add(print(bookID, edition.get(bookID)+1));
			}
			edition.put(bookID, edition.get(bookID)+1);
		}
		return books;
	}
}
		
