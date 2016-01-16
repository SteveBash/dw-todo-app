
package controllers;

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

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res){
        Todo t = new Todo();
        ObjectMapper om = new ObjectMapper();
        res.setContentType("application/json"); 
        try {
            t = om.readValue(req.getInputStream(), Todo.class);
            PrintWriter writer = res.getWriter();
            om.writeValue(writer, TodosDAO.create(t));
            res.setStatus(HttpStatus.OK_200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse res){
        Todo t = new Todo();
        ObjectMapper om = new ObjectMapper();
        res.setContentType("application/json"); 
        String path = req.getPathInfo();
        String[] pathParts = path.split("/");
        Integer id = Integer.parseInt(pathParts[1]);
        TodosDAO.delete(id);
        try {
            res.setStatus(HttpStatus.OK_200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
