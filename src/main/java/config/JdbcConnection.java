
package config;

import java.sql.*;
import java.util.Optional;

public class JdbcConnection{
    
    public static Optional<Connection> getConnection(){
        Optional<Connection> c = null; 
        try {
            c = Optional.ofNullable(DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/todos", "stevebash", "nueveabril"));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error when connection to the db");
        }
        return c;
    }

}
