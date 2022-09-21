package DB;

import Entities.Book;

public class Facade {

    public static Book createBook(Book book){
        return BookMapper.createBook(book);
    }
}
