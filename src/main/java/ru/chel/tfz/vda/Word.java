package ru.chel.tfz.vda;

import javax.persistence.PersistenceContext;

@PersistenceContext(name="word")
public class Word {
    private int id;
    private String word;

    public Word(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public Word() {
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
