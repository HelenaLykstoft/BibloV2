package DB;

import Entities.Book;
import java.sql.SQLException;
import java.util.List;

public class Facade {

    public static Book createBook(Book book) throws SQLException {
        return BookMapper.createBook(book);
    }

    public static List<Book> getBooks() throws SQLException {
        return BookMapper.getBooks();
    }

    public static String deleteBook(int bookID) {
        return BookMapper.deleteBook(bookID);
    }
}
