package DB;

import Entities.Book;

import java.sql.*;


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


}

