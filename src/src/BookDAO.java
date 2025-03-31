import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public List<Book> getAllBooks() throws SQLException, ClassNotFoundException {
        List<Book> books = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM books");
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Book book = new Book(
                rs.getInt("id"),
                rs.getString("idbook"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getDouble("price"),
                rs.getInt("qty")
            );
            books.add(book);
        }
        return books;
    }

    public void addBook(Book book) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("INSERT INTO books (idbook, title, author, price, qty) VALUES (?, ?, ?, ?, ?)");
        pst.setString(1, book.getIdBook());
        pst.setString(2, book.getTitle());
        pst.setString(3, book.getAuthor());
        pst.setDouble(4, book.getPrice());
        pst.setInt(5, book.getQty());
        pst.executeUpdate();
    }

    public void updateBook(Book book) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("UPDATE books SET idbook=?, title=?, author=?, price=?, qty=? WHERE id=?");
        pst.setString(1, book.getIdBook());
        pst.setString(2, book.getTitle());
        pst.setString(3, book.getAuthor());
        pst.setDouble(4, book.getPrice());
        pst.setInt(5, book.getQty());
        pst.setInt(6, book.getId());
        pst.executeUpdate();
    }

    public void deleteBook(int id) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pst = conn.prepareStatement("DELETE FROM books WHERE id=?");
        pst.setInt(1, id);
        pst.executeUpdate();
    }
}
