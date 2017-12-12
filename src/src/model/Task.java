import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private int effort; //hours
    private ArrayList<Task> dependencies;
    private Person person;
    private int startTime;
    private int endTime;
    public Task(String name,int effort, int time){
        this.name = name;
        this.effort = effort;
        this.startTime = time;
        this.endTime = time + effort;
        this.person = null;
        dependencies = new ArrayList<>();
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getStart(){
        return startTime;
    }
    
    public int getEnd(){
        return endTime;
    }
    
    public ArrayList<Task> getDependencies(){
        return dependencies;
    }

    public void addDependancy(Task task){
        dependencies.add(task);
    }

    public void assignPerson(Person person){
        this.person = person;
    }
    
    public Person getWorker(){
        return person;
    }
    
    public int getEffort(){
        return effort;
    }

    @Override
    public String toString() {
        return "Task name: " + name + "Effort: " + effort;
    }
}
import java.util.List;

public class Task {
    private String name;
    private int startTime;
    private int endTime;
    private int effort; //hours
    private List<Task> dependencies;
    private Person person;
    
    public Task(String name,int effort){
        new Task(name,effort,null);
    }
    
    public Task(String name, int effort, Task prerequiste){
        this.name = name;
        this.effort = effort;
        dependencies.add(prerequiste);
    }
    
    public void addDependancy(Task task){
        dependencies.add(task);
    }
    
    public void assign(Person person,int startTime){
        
        this.person = person;
        setStartTime(startTime);
    }
    
    public int getStartTime(){
        return startTime;
    }
    private void setStartTime(int startTime){
        this.startTime = startTime;
        this.endTime = startTime + effort;
    }
    
    
    
    @Override
    public String toString() {
        return "Task name: " + name + "Effort: " + effort;
    }
}
