package DAO;

import org.example.Database;

import java.sql.*;

public class ArtistDAO {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArtistDAO() {

    }
    public void create(int id, String name) throws SQLException {

        try (Connection con = Database.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "INSERT INTO artists VALUES (?,?)")) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
//            System.out.println("Artist " + this.id + " inserted in the database");
        } catch (SQLException e) {
            System.out.println("SQLException message: " + e);
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT id FROM artists WHERE name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT name FROM artists WHERE id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}