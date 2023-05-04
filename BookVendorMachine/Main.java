import java.io.IOException;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IllegalArgumentException, IOException, InvalidPasswordException, IndexOutOfBoundsException, CassetteException{
        Book b = new Book("title_", "author_","content_",1);
        VendingMachine v = new VendingMachine(1.5, "Password_");
        Press p = new Press("Data",10);
        
        List<String> st = p.getCatalogue();
        System.out.println(st);
        

        // List<Book> books1 = p.request("11-0-bad.txt", 15);
        List<Book> books2 = p.request("pg514.txt", 5);
        List<Book> books3 = p.request("2852-0.txt", 15);
        // System.out.println(books1);
        System.out.println(books2);
        System.out.println(books3);

        System.out.println(books3.get(0).getTitle());
        System.out.println(books3.get(0).getAuthor());
        // System.out.println(books3.get(0).getContent());
        System.out.println(books3.get(0).getEdition());
        System.out.println(books3.get(0).getPages());
        System.out.println(books3.get(0).toString());
        
        System.out.println(v.getCassette());
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        v.insertCoin(100);
        try {
            v.insertCoin(101);
            
        } catch (IllegalArgumentException e) {
            System.out.println(e);

        }
        
        // System.out.println(v.returnCoins());

        v.restock(books2,"Password_");
        try {
            v.restock(books3,"Passworbkd_");
            
        } catch (InvalidPasswordException e) {
            System.out.println(e);

        }
        System.out.println(v.emptySafe("Password_"));
        try {
            System.out.println(v.emptySafe("Passworkjbkbd_"));
            
        } catch (InvalidPasswordException e) {
            System.out.println(e);

        }
        System.out.println(v.getCatalogue());

        System.out.println(v.getPrice(2));
        
        System.out.println(v.buyBook(2));
        
        try {
            System.out.println(v.buyBook(27));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);

        }

    }
}