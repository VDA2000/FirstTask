package ru.chel.tfz.vda;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.Collection;

public class WordsDao {
    public Collection<Word> getWords() {
        Collection<Word> arrayWords = new ArrayList();
        for (int i=0; i<5;i++) {arrayWords.add(new Word(i, "Number "+i));}
        return arrayWords;
    }
    @Inject
    public WordsDao() {
    }
}