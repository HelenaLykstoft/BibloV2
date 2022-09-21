import DB.Facade;
import Entities.Book;
import Util.UserInput;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //Book book = new Book("hej","helena");
        //Facade.createBook(book);

        while (true){
            switch (UserInput.getString("What do u want?")){
                case "create book":
                    Book book1 = new Book(UserInput.getString("Add title: "),
                            UserInput.getString(" Add author:"));
                    System.out.println("You have now added the book: " + Facade.createBook(book1).toString());
            }
        }
    }
}