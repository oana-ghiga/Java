package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
    private static Database java;
    private static final String URL = "jdbc:mysql://localhost:3306/java";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        private static Connection connection = null;

        public static Connection getConnection() {
            if (connection == null) {
                createConnection();
            }
            return connection;
        }

        private static void createConnection() {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
                System.out.println("Connection created successfully");
            } catch (SQLException e) {
                System.err.println("Error creating connection: " + e.getMessage());
            }
        }

        public static void closeConnection() {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        public static void createTables(){
            try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement stmt = conn.createStatement()) {
                String sql = "CREATE TABLE artists (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL);" +
                        "CREATE TABLE genres (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL);" +
                        "CREATE TABLE albums (id INT PRIMARY KEY AUTO_INCREMENT, release_year INT NOT NULL, title VARCHAR(255) NOT NULL, artist_id INT NOT NULL REFERENCES artists(id));" +
                        "CREATE TABLE album_genres (album_id INT NOT NULL REFERENCES albums(id), genre_id INT NOT NULL REFERENCES genres(id), PRIMARY KEY (album_id, genre_id));";
                stmt.executeUpdate(sql);
            } catch(SQLException e) {
                System.err.println("Error creating tables: " + e.getMessage());
            }
        }
}
