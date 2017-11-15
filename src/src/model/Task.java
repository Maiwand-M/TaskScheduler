package model;

import java.util.List;

public class Task {
    private String name;
    private int effort; //hours
    private List<Task> dependencies;
    private Person person;

    public Task(String name,int effort){
        this.name = name;
        this.effort = effort;
    }

    public void addDependancy(Task task){
        dependencies.add(task);
    }

    public void assignPerson(Person person){
        this.person = person;
    }

    @Override
    public String toString() {
        return "Task name: " + name + "Effort: " + effort;
    }
}
