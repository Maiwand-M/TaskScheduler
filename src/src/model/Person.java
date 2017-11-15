package model;

public class Person {
    private String name;
    private Task task;
    public Person(String name){
        this.name = name;
    }

    public Person(String name,Task task){
        this(name);
        this.task = task;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Task: " + task;
    }
}
