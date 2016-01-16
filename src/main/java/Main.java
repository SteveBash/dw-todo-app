
import models.Todo;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import org.eclipse.jetty.util.resource.*;

import controllers.*;

public class Main{
    public static void main(String[] args){
        Integer port = 8000;
        Server server = new Server(port);
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        //Static files
        //http://stackoverflow.com/questions/28418449/what-is-difference-between-servletcontexthandler-setresourcebase-and-resourcehan/28419106#28419106)
        try {
            handler.setBaseResource(Resource.newResource("src/main/resources/web"));
            handler.addServlet(DefaultServlet.class,"/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        handler.addServlet(TodosServlet.class, "/todos");
        handler.addServlet(ViewServlet.class, "/welcome");
        try {
            server.start();
            System.out.println(String.format("Server started in %s", port));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
