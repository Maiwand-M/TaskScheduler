package model;

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

    public Task(String name, int effort, Task prerequisite){
        this.name = name;
        this.effort = effort;
        dependencies.add(prerequisite);
        this.endTime  = this.startTime + effort;
    }

    public void addDependancy(Task task){
        dependencies.add(task);
    }

    public void assignPerson(Person person,int startTime){

        this.person = person;
        setStartTime(startTime);
    }

    public int getEndTime() {
        return endTime;
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
