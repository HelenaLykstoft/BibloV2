package Entities;

public class Book {

    private int bookID;
    private String titel;
    private String forfatter;

    public Book(int bookID, String titel, String forfatter) { // From DB to object
        this.bookID = bookID;
        this.titel = titel;
        this.forfatter = forfatter;
    }

    public Book(String titel, String forfatter){ // From object to DB ( first time )
        this.titel = titel;
        this.forfatter = forfatter;
    }

    public int getBookID(){
        return bookID;
    }
}
