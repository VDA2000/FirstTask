package ru.chel.tfz.vda;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static final Injector injector = Guice.createInjector(new DaoModule());
    public static final Injector injector = Guice.createInjector(new DaoModule(),new JpaPersistModule("word"));
    public static void main( String[] args )
    {
        injector.getInstance(PersistService.class).start();
        injector.getInstance(WordsDao.class).createNewWord("228");
        injector.getInstance(WordsDao.class).createNewWord("224");

        ResourceConfig config = new ResourceConfig();
        config.packages("ru.chel.tfz.vda");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));

        Server server = new Server(2222);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");

        try {
            server.start();
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.destroy();}


    }
}
