package ru.chel.tfz.vda;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "WORD" )
public class Word {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    @Column(name= "word", length=64)
    private String word;

    public Word(int id, String word) {
        this.id = id;
        this.word = word;
    }
    public Word(String word) {
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
