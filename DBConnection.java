import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/my_booklibrary";
    private static final String USER = "root";  // Αν έχεις κωδικό, βάλε τον σωστό εδώ
    private static final String PASSWORD = "";

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to the database!");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        connect();  // Δοκιμή σύνδεσης
    }
}
