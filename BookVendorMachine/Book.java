/**
 * Book
 */
public class Book {
	private String title;
	private String author;
	private String content;
	private int edition;
	
	/**
	 * getTitle
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * getAuthor
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * getContent
	 */
	public String getContent() {
		return content;
	}

	/**
	 * getEdition
	 */
	public int getEdition() {
		return edition;
	}

	/**
	 * getPages
	 */
	public int getPages() {
		int chars = getContent().length();
		double pages = chars/700;
		return (int) Math.ceil(pages);
	}

	/**
	 * Book
	 */
	public Book(String title, String author,String content, int edition) {
		super();
		this.title = title;
		this.author = author;
		this.content = content;
		this.edition = edition;
	}

	/**
	 * toString
	 */
	public String toString() {
		return "Title: " + title + "\nAuthor: " + author + "\nEdition: " + edition + "\n";
	}
	
	

}
