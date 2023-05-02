package DAO;

import java.sql.SQLException;

abstract class AbstractDAO {
    public abstract void create(int id, String name) throws SQLException; // artistDAO & genreDAO
    public abstract void create(int id, String title, int releaseYear) throws SQLException; // albumDAO
    public abstract String findById(int id) throws SQLException;
    public abstract int findByName(String name) throws SQLException;
}
