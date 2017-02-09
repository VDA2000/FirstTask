package ru.chel.tfz.vda;

import java.util.ArrayList;
import java.util.Collection;

public class WordsDao {
    public Collection<Word> getWords() {
        Collection<Word> arrayWords = new ArrayList();
        for (int i=0; i<3;i++) {arrayWords.add(new Word(i, "Number "+i));}
        return arrayWords;
    }
}