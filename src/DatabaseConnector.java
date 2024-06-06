import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        System.out.println("\nLoading the driver");
        Class.forName("com.mysql.jdbc.Driver"); // loading the MySQL driver
        System.out.println("Connecting");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc_company", "root", "");
        System.out.println("Connected\n");
        return con;
    }
}
