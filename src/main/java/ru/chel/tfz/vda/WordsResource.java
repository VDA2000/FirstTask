package ru.chel.tfz.vda;

import com.google.inject.Guice;
import com.google.inject.Injector;

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
        Injector injector = Guice.createInjector(new DaoModule());
        return injector.getInstance(WordsDao.class).getWords();
    }
}
