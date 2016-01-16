
package dao;

import java.sql.*;
import java.util.*;
import models.Todo;
import config.JdbcConnection;

public class TodosDAO{
    public static List<Todo> findAll(){
        List<Todo> todos = new ArrayList<Todo>();
        Connection conn = null;
        if(JdbcConnection.getConnection().isPresent()){
            conn = JdbcConnection.getConnection().get();
            System.out.println("Conn succ");
        }
        ResultSet rs;
        Todo temp;
        try {
            rs = conn.prepareStatement("SELECT * FROM todos").executeQuery();
            while(rs.next()){
                temp = new Todo();
                temp.setId(Integer.parseInt(rs.getString("id")));
                temp.setName(rs.getString("name"));
                temp.setDone(Boolean.parseBoolean(rs.getString("done")));
                todos.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query error");
        }
        return todos;
    }
}
