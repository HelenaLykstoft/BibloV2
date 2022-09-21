package DB;

import Entities.Book;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class BookMapper {
    protected static Book createBook(Book book) throws SQLException {

        String sql = "INSERT INTO BogTabelx (Forfatter , Titel ) VALUES (?, ?)";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            try {
                ps.setString(1, Book.getForfatter());
                ps.setString(2, Book.getTitle());

                ps.executeUpdate();

                ResultSet resultSet = ps.getGeneratedKeys();

                resultSet.next();

                book.setBookId(resultSet.getInt(1));
                //System.out.println(book.toString());

                return book;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return book;

        }
    }

    protected static List<Book> getBooks() throws SQLException {
        List<Book> bookList = new LinkedList<>();

        String sql = "SELECT * FROM BogTabelx";

        try (Connection con = ConnectionConfiguration.getConnection();  // får en connection

             // se evt. https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int bookID = resultSet.getInt("idBogTabelx");
                String author = resultSet.getString("Forfatter");
                String title = resultSet.getString("Titel");

                bookList.add(new Book(bookID, title, author));

            }

            return bookList;
        }

    }

    protected static String deleteBook(int bookID) {

        String sql = "delete from BogTabelx where idBogTabelx = ?";

        try (Connection con = ConnectionConfiguration.getConnection(); PreparedStatement ps = con.prepareStatement(sql);

        ) {
            ps.setInt(1, bookID);
            int res = ps.executeUpdate();
            if (res > 0) {

                return "The book with the ID " + "\"" + bookID + "\"" + " has now been deleted.";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "A book with the ID " + "\"" + bookID + "\"" + " was not found in the list.";

    }

}


