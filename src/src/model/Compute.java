package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Compute {
    private ArrayList<Person> staffRoster;
    //private ArrayList<ArrayList<Task>> tasks;
    private ArrayList<Task> taskList;
    private ArrayList<Task> completedTasks;
    
    public Compute(){
        completedTasks = new ArrayList<>();
        staffRoster = new ArrayList<>();
        taskList = new ArrayList<>();
    }
    
    
    public void addTask(String name,int effort, int time){
        taskList.add(new Task(name,effort,time));
    }
    
    public void addPerson(String name){
        staffRoster.add(new Person(name));
    }
    
    /**private void schedule(ArrayList<Task> input){ //Sorting work into index
        int index = 0;
            for(int i = 0; i < input.size(); i++){
                if (input.get(i).getDependencies().size() == 0){
                    tasks.get(0).add(input.get(i));
                }
                else {
                    ArrayList<Task> temp = input.get(i).getDependencies();
                    int addto = 0;
                    for (int k = 0; k < temp.size(); k++){
                        for(int j = 0; j < tasks.size(); j++){
                            if(tasks.get(j).contains(temp.get(k)) && (j > addto) ){
                                addto = j;
                            }
                        }
                    }
                    if(addto + 1 > tasks.size()) tasks.get(addto + 1).add(input.get(i));
                    else tasks.get(addto + 1).add(input.get(i));
                }
            }
    }
    
    /**public void assign(){
        int time = 0;
        int index = 0;
        int completedCount = 0;
        while(true){
            if(index == tasks.size()) break;
            for(Task i : tasks.get(index)){
                if (i.getEnd() == time){
                    completed.add(i);
                    completedCount++;
                    workers.add(i.getWorker());
                }
                else if(i.getStart() == time) {
                    i.assignPerson(workers.remove(0));
                }
            }
            if (completedCount == tasks.get(index).size()){
                index++;
                completedCount = 0;
            }
            time++;
        }
    }**/
    
    public void removePerson(String name){
        for(Iterator<Person> iterator = staffRoster.iterator(); iterator.hasNext();){
            Person person = iterator.next();
            if(person.getName().equals(name)){
                iterator.remove();
            }
        }
    }
    
    public ArrayList<Person> getStaffRoster(){
        return this.staffRoster;
    }
    
    public boolean dependenciesCompleted(Task input){
        for(Task k : input.getDependencies()){
            if (!completedTasks.contains(k)) return false;
        }
        return true;
    }
    
    public void schedule(){ //Sorting work into index
        int taskLength = taskList.size();
        int time = 0;
        int index = 0;
        while(true){
            if(time == taskList.get(taskList.size() - 1).getEnd() + 1) break;
            for(Task i : taskList){
                if(i.getStart() == time){
                    if(dependenciesCompleted(i)) i.assignPerson(staffRoster.remove(0));
                }
                else if ((i.getEnd() == time) && (i.getWorker() != null)){
                    Task temp = i;
                    staffRoster.add(i.getWorker());
                    completedTasks.add(temp);
                    //taskList.remove(i);
                }
            }
            time++;
        }
    }
    
    public ArrayList<Task> getSchedule(){
        return this.completedTasks;
    }
    
    public void print(){
        System.out.println(completedTasks.size());
        if (completedTasks.size() == 0) System.out.println("This is empty");
        else{
            for (Task i : completedTasks){
                System.out.println(i.getName() + " done by " + i.getWorker().getName());
            }
        }
    }

    
    
    
}
