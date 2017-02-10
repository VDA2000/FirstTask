package ru.chel.tfz.vda;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ResourceConfig config = new ResourceConfig();
        config.packages("ru.chel.tfz.vda");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));


        Server server = new Server(2222);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");
//        Injector injector = Guice.createInjector(new DaoModule());
//        WordsDao WordsDao = injector.getInstance(WordsDao.class);
        System.out.println("A");
        System.out.println("A");

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
