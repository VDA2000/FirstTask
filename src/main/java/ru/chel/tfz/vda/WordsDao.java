package ru.chel.tfz.vda;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WordsDao {
    private static final String url = "jdbc:mysql://localhost:3306/word";
    private static final String user = "root";
    private static final String password = "root";
    @Inject EntityManager em;

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
    @Transactional
    public void createNewWord(String... words ) {
        for(String word: words){
            em.persist(new Word(word));
        }
    }

    @Transactional
     public Collection<Word> queryAllWords() {
        return em.createQuery( "from Word", Word.class ).getResultList();
    }

    public Collection<Word> getWords2() {
        em.getTransaction().begin();
        Collection<Word> arrayWords = em.createQuery( "from Word", Word.class ).getResultList();
        em.getTransaction().commit();
        em.close();
        return arrayWords;
    }

    @Inject
    WordsDao(EntityManager em) {
        System.out.println(em);
    }

    public WordsDao() {
    }
}