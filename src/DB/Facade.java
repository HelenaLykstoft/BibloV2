package DB;

import Entities.Book;
import java.sql.SQLException;

public class Facade {

    public static Book createBook(Book book) throws SQLException {
        return BookMapper.createBook(book);
    }
}
