import DB.Facade;
import Entities.Book;
import Util.UserInput;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws SQLException {

        //Book book = new Book("hej","helena");
        //Facade.createBook(book);

        List<Book> bookList = new LinkedList<>();

        while (true){
            switch (UserInput.getString("What do u want?")){

                case "create book":
                    Book book1 = new Book(UserInput.getString("Add title: "),
                            UserInput.getString(" Add author:"));
                    System.out.println("You have now added the book: " + Facade.createBook(book1).toString());
                    break;
                case "see books":
                    bookList = Facade.getBooks();
                    soutLists(bookList);
                    break;
                case "delete books":
                    System.out.println(Facade.deleteBook(UserInput.getInt("Write bookID")));

            }
        }
    }

    public static void soutLists(List<Book> bookList){
        for (Book book : bookList) {
            System.out.println(book.toString());
        }

    }
}