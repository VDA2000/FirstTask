package ru.chel.tfz.vda;

import com.google.inject.Inject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class WordsDao {
    private static final String url = "jdbc:mysql://localhost:3306/word";
    private static final String user = "root";
    private static final String password = "root";

    public Collection<Word> getWords() {
        Collection<Word> arrayWords = new ArrayList();
//        for (int i=0; i<5;i++) {arrayWords.add(new Word(i, "Number "+i));}
        String queryMeanings = "select id, word from word";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryMeanings);
            while (rs.next()) {
                int id = rs.getInt(1);
                String word = rs.getString(2);
                arrayWords.add(new Word(id, word));
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return arrayWords;
    }
    @Inject
    public WordsDao() {
    }
}