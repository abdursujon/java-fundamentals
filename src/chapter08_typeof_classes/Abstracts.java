import java.util.ArrayList;
import java.util.List;

/**
 * Abstract BuiltInClass vs Interface:
 *
 * Abstract BuiltInClass:
 * - Can have both abstract (no body) and concrete (with body) methods
 * - Can have instance fields/variables
 * - A class can only extend ONE abstract class
 * - Use when classes share common state and behaviour
 *
 * Interface:
 * - All methods are abstract by default (before Java 8)
 * - Can only have constants (static final fields)
 * - A class can implement MULTIPLE interfaces
 * - Use when unrelated classes share common behaviour
 */
public abstract class Abstracts implements InterfaceInJava{
    String bookName;
    String author;
    double price;
    int numberOfCopySold;
    int bookInStock;

    Abstracts(String bookName, String author, double price, int numberOfCopySold, int bookInStock){
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.numberOfCopySold = numberOfCopySold;
        this.bookInStock = bookInStock;
    }

    Abstracts(){};

    // abstract methods - subclass must implement them
    public abstract List<BookDetails> bookDetails();
    public abstract boolean inStock();

    // concrete methods - all subclasses by default get this behaviour
    public int howManyCopySold(){
        return numberOfCopySold;
    }

    @Override
    public void typeOfClass() {
        System.out.println("I am an example of Abstract class in Java");
    }
}

class BookDetails extends Abstracts{

    BookDetails(String bookName, String author, double price, int numberOfCopySold, int bookInStock){
        super(bookName, author, price, numberOfCopySold, bookInStock);
    }

    BookDetails(){};

    public List<BookDetails> bookDetails(){
        List<BookDetails> bd = new ArrayList<>();
        bd.add(new BookDetails("Robot", "Isaac Asimov", 6.78,  100000, 78));
        for(BookDetails b: bd){
            System.out.println("Book name: " + b.bookName);
            System.out.println("Book author: " + b.author);
            System.out.println("Book price: " + b.price);
            System.out.println("Book sold: " + b.numberOfCopySold);
            System.out.println("Book in stock: " + b.bookInStock);
        }
        return bd;
    }

    public boolean inStock(){
        List<BookDetails> books = bookDetails();
        for(BookDetails b: books){
            if(b.bookInStock != 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public void typeOfClass() {
        System.out.println("I am an example of Default class who implements Abstract class in Java");
    }

    @Override
    public void speak() {

    }

    @Override
    public void speakTwo() {

    }

    @Override
    public void speakThree() {

    }

    @Override
    public void speakFour() {

    }

    public static void main(String[] args){
        BookDetails bd = new BookDetails(
                "Robot",
                "Isaac Asimov",
                6.78,
                1000900,
                89);
        bd.bookDetails();
        System.out.println("Copy Sold: " + bd.howManyCopySold());
        System.out.println(bd.inStock());
        bd.typeOfClass();
    }
}