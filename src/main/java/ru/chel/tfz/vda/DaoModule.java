package ru.chel.tfz.vda;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.Collection;

public class DaoModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(WordsDao.class);
//      bind(WordsDao.class).in(Singleton.class);
    }
}
