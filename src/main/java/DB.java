import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:postgresql://localhost:5432/phonebook";
    private static final String USER = "wsky";
    private static final String PASSWORD = "03041988";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    };
}
