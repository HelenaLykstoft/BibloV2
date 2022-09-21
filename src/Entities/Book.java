package Entities;

public class Book {

    private int bookID;
    private static String titel;
    private static String forfatter;

    public Book(int bookID, String titel, String forfatter) { // From DB to object
        this.bookID = bookID;
        this.titel = titel;
        this.forfatter = forfatter;
    }

    public Book(String titel, String forfatter){ // From object to DB ( first time )
        this.titel = titel;
        this.forfatter = forfatter;
    }

    public static String getForfatter() {
        return forfatter;
    }

    public void setForfatter(String forfatter) {
        this.forfatter = forfatter;
    }

    public static String getTitle() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getBookID(){
        return bookID;
    }

    public void setBookId(int bogId) {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", titel='" + titel + '\'' +
                ", forfatter='" + forfatter + '\'' +
                '}';
    }
}
