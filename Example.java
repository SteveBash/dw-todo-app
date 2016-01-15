
import models.Todo;
import com.fasterxml.jackson.databind.*;

class Example{
    public static void main(String[] args){
        Todo t1 = new Todo();
        Todo t2 = new Todo();
        t1.name = "Buy bread";
        t1.done= false;
        t2.name = "Learn webdev";
        t2.done= true;
        System.out.println(t1);
        System.out.println(t2);
    }
}
