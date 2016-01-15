
import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.http.*;

public class ExampleServlet extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        res.setContentType("text/html"); 
        res.setStatus(HttpStatus.OK_200);
        try {
            res.getWriter().println("<h1>Hello Java Servlet</h1>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
