
import models.Todo;

import com.fasterxml.jackson.databind.*;
import java.io.*;

class Example{
    public static void main(String[] args){
        ObjectMapper om = new ObjectMapper();
        Todo t1 = new Todo();
        Todo t2 = new Todo();
        t2.name = "Watch MTV";
        t2.done = true;
        try {
            t1 = om.readValue(new File("src/main/resources/todo1.json"), Todo.class);
            om.writeValue(new File("src/main/resources/todo2.json"), t2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(t1);
    }
}
