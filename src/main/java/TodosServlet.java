
import models.Todo;
import dao.TodosDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.http.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;

public class TodosServlet extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        ObjectMapper om = new ObjectMapper();
        res.setContentType("application/json"); 
        try {
            PrintWriter writer = res.getWriter();
            res.setStatus(HttpStatus.OK_200);
            om.writeValue(writer, TodosDAO.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
