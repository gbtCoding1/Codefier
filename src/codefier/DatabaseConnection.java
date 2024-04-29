/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DatabaseConnection {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://192.168.1.109:3306/poapp";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // JDBC variables for opening, closing, and managing connection
    private static Connection connection;

    // Method to establish a connection to the database
    public static Connection getConnection() {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close the connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}