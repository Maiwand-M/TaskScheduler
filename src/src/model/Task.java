package model;

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
