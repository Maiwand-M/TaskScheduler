import java.util.ArrayList;
public class Person {
    private String name;
    private Task task;
    public Person(String name){
        this.name = name;
    }
    
    
    public String getName(){
        return this.name;
    }
    @Override
    public String toString() {
        return "Name: " + name + " Task: " + task;
    }
}
