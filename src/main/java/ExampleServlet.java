
import models.Todo;

import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.http.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;

public class ExampleServlet extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        ObjectMapper om = new ObjectMapper();
        Todo t1 = new Todo();
        res.setContentType("application/json"); 
        try {
            PrintWriter writer = res.getWriter();
            t1 = om.readValue(new File("src/main/resources/todo1.json"), Todo.class);
            res.setStatus(HttpStatus.OK_200);
            om.writeValue(writer, t1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
