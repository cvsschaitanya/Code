
import java.util.*;
/**
 * VendingMachine
 */
public class VendingMachine {

	private List<Book> shelf;
	private double locationFactor;
	private int cassette;
	private int safe;
	private String password;

	/**
	 * VendingMachine
	 */
	public VendingMachine(double locationFactor, String password) {
		this.locationFactor = locationFactor;
		this.password = password;
		this.cassette = 0;
		this.safe = 0;
		this.shelf = new ArrayList<Book>();
	}

	/**
	 * getCassette
	 */
	public int getCassette() {
		return cassette;
	}

	/**
	 * insertCoin
	 */
	public void insertCoin(int coin) throws IllegalArgumentException {
		switch (coin) {
			case 1:
			case 2:
			case 5:
			case 10:
			case 20:
			case 50:
			case 100:
			case 200:
				cassette += coin;
				break;
			default:
				throw new IllegalArgumentException();
		}
	}

	/**
	 * returnCoins
	 */
	public int returnCoins() {
		int tempCassette = getCassette();
		this.cassette = 0;
		return tempCassette;
	}

	/**
	 * restock
	 */
	public void restock(List<Book> books, String Password) throws InvalidPasswordException {
		if (Password != password) {
			throw new InvalidPasswordException();
		} else {
			shelf.addAll(books);
		}
	}

	/**
	 * emptySafe
	 */
	public int emptySafe(String Password) throws InvalidPasswordException {
		int temp;
		if (Password != password) {
			throw new InvalidPasswordException();
		} else {
			temp = safe;
			safe = 0;
		}
		return temp;
	}

	/**
	 * getCatalogue
	 */
	public List<String> getCatalogue() {
		List<String> catalogue = new ArrayList<String>();
		;
		for (Book tempShelf : shelf) {
			catalogue.add(tempShelf.toString());
		}
		return catalogue;
	}

	/**
	 * getPrice
	 */
	public int getPrice(int index) throws IndexOutOfBoundsException {
		int price = 0;
		Book tempBook = shelf.get(index);
		price = (int) Math.ceil((tempBook.getPages()) * locationFactor);
		return price;
	}

	/**
	 * buyBook
	 */
	public Book buyBook(int index) throws IndexOutOfBoundsException, CassetteException {
		Book tempBook = shelf.get(index);
		Book saleBook = null;
		int tempPrice = getPrice(index);
		int tempCassette = getCassette();
		if (tempPrice <= tempCassette) {
			saleBook = tempBook;
			shelf.remove(index);
			cassette -= tempPrice;
			safe += tempPrice;
		} else {
			throw new CassetteException();
		}
		return saleBook;
	}

}
