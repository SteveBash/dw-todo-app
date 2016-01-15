
package models;

public class Todo{
    public String name;
    public Boolean done;

    public String toString(){
        String done;
        done = this.done?" : Done":" : Not done";
        return name.concat(done); 
    }
}
