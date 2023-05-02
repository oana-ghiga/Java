package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String args[]) {
        try {
            Database.createTables();
            var artists = new ArtistDAO();
            if (artists.findById(1) == null) {
                artists.create(1,"Pink Floyd");
            }
            if (artists.findById(2) == null) {
                artists.create(2,"Nirvana");
            }

            System.out.println(artists.findByName("Nirvana"));
            System.out.println(artists.findById(2));
            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
//public class Main {
//    public static void main(String[] args) throws SQLException {
//
//        try {
//
//            // creating singleton instance
//            Database.getInstance();
//
//            Statement stmt = Database.getConnection().createStatement();
//
//            // reading and executing the sql script
//            String script = new String(Files.readAllBytes(Paths.get("C:\\Users\\oana_\\Desktop\\mine\\eight\\src\\main\\java\\org\\example\\create_tables.sql")));
////            stmt.execute(script);
////
////            stmt.close();
//
//            // adding entries in artists table
//            var artists = new ArtistDAO(1);
//            artists.create("Pink Floyd");
//            artists.create("Michael Jackson");
//
//
//            Database.closeConnection();
//        }
//
//        catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}