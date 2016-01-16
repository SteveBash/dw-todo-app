
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
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setDone(rs.getBoolean("done"));
                todos.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query error");
        }
        return todos;
    }

    public static Todo create(Todo t){
        Connection conn = null;
        Integer id = -1;
        if(JdbcConnection.getConnection().isPresent()){
            conn = JdbcConnection.getConnection().get();
            System.out.println("Conn succ");
        }
        try {
            PreparedStatement st = conn.prepareStatement("INSERT INTO todos(name, done) VALUES(?, ?)", new String[]{"id"});
            st.setString(1, t.getName());
            st.setBoolean(2, t.getDone());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1); 
                t.setId(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void delete(Integer id){
        Connection conn = null;
        if(JdbcConnection.getConnection().isPresent()){
            conn = JdbcConnection.getConnection().get();
            System.out.println("Conn succ");
        }
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM todos WHERE id=?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Integer id, Boolean done){
        Connection conn = null;
        if(JdbcConnection.getConnection().isPresent()){
            conn = JdbcConnection.getConnection().get();
            System.out.println("Conn succ");
        }
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE todos SET done=? WHERE id=?");
            st.setBoolean(1, done);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
