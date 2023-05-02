package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;

public class Database {
    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/java");
        config.setUsername("root");
        config.setPassword("");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }

    private Database() { }
        private static Database java;


    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void closeConnection() {
        ds.close();
        System.out.println("Connection closed successfully");
    }

    public static void createTables() throws SQLException {
        Connection conn = ds.getConnection();
        conn.setAutoCommit(true); // set auto-commit mode to true
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE artists (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL);" ;
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE genres (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL);";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE albums (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255) NOT NULL, release_year INT NOT NULL);";
        stmt.executeUpdate(sql);

        sql = "CREATE TABLE album_genres (album_id INT NOT NULL, genre_id INT NOT NULL, PRIMARY KEY (album_id, genre_id), FOREIGN KEY (album_id) REFERENCES albums(id), FOREIGN KEY (genre_id) REFERENCES genres(id));";
        stmt.executeUpdate(sql);

        System.out.println("Tables created successfully!");
    }

    public static void displayTables(String tableName) throws SQLException {
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + ";");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            if (tableName.equalsIgnoreCase("albums")) {
                int releaseYear = rs.getInt("release_year");
                System.out.println("Release Year: " + releaseYear);
            }
        }
        System.out.println("Table " + tableName + " displayed successfully!");
    }

    public static void dropTables() throws SQLException {
        Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "DROP TABLE album_genres, albums, genres, artists";
        stmt.executeUpdate(sql);
        System.out.println("Tables dropped successfully");
    }
}
//
//public class Database {
//    private static Database java;
//    private static final String URL = "jdbc:mysql://localhost:3306/java";
//        private static final String USER = "root";
//        private static final String PASSWORD = "";
//
//        private static Connection connection = null;
//
//        public static Connection getConnection() {
//            if (connection == null) {
//                createConnection();
//            }
//            return connection;
//        }
//
//        private static void createConnection() {
//            try {
//                connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                connection.setAutoCommit(false);
//                System.out.println("Connection created successfully");
//            } catch (SQLException e) {
//                System.err.println("Error creating connection: " + e.getMessage());
//            }
//        }
//
//        public static void closeConnection() {
//            try {
//                if (connection != null) {
//                    connection.close();
//                    System.out.println("Connection closed successfully");
//                }
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//
//        public static void createTables(){
//            try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//                Statement stmt = conn.createStatement()) {
//                String sql = "CREATE TABLE artists (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL);" +
//                        "CREATE TABLE genres (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255) NOT NULL);" +
//                        "CREATE TABLE albums (id INT PRIMARY KEY AUTO_INCREMENT, release_year INT NOT NULL, title VARCHAR(255) NOT NULL, artist_id INT NOT NULL REFERENCES artists(id));" +
//                        "CREATE TABLE album_genres (album_id INT NOT NULL REFERENCES albums(id), genre_id INT NOT NULL REFERENCES genres(id), PRIMARY KEY (album_id, genre_id));";
//                stmt.executeUpdate(sql);
//            } catch(SQLException e) {
//                System.err.println("Error creating tables: " + e.getMessage());
//            }
//        }
//}
