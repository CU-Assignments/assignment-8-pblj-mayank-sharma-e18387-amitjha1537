import java.sql.*;

public class DBConnection {
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        String dbName = "company";
        String dbUsername = "root";
        String dbPassword = "password";
        Class.forName(dbDriver);
        return DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
    }
}