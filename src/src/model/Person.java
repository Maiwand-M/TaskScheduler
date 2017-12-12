package model;

public class Person {
    private String name;
    private Task task;
    public Person(String name){
        this.name = name;
    }

    public Person(String name,Task task) {
        this(name);
        this.task = task;
    }

    public void assignTask(Task task){
        this.task = task;
    }

    public String getName(){
        return this.name;
    }
    public void completeTask(){
        this.task = null;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Task: " + task;
    }
}
