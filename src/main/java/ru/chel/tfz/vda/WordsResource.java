package ru.chel.tfz.vda;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;

@Path("words")
public class WordsResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Word> getCollectionWordsInJSON() {
        Collection<Word> arrayWords = new ArrayList();
        for (int i=0; i<10;i++) {arrayWords.add(new Word(i, "Number "+i));}
        return arrayWords;
    }
}
