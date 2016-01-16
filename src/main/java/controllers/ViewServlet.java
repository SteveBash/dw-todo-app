
package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import org.eclipse.jetty.http.*;

public class ViewServlet extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        RequestDispatcher rd = req.getRequestDispatcher("index.html");
        try {
            rd.forward(req, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
