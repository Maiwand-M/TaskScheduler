package model;

import java.util.ArrayList;

/**
 * Created by k1502425 on 06/12/17.
 */
public class Scheduler {
    ArrayList<Person> staffRoster;
    ArrayList<Task> taskList;
    ArrayList<Task> completedTasks;
    int currentTime = 0;

   public void addTask(String name,int effort){
       taskList.add(new Task(name,effort));
   }

   public void addPerson(String name){
       staffRoster.add(new Person(name));
   }

   public void assignTask(Person person,Task task,int currentTime){
       task.assign(person,currentTime);
       person.assignTask(task);
   }


   public ArrayList<Task> getSchedule(){




       while(!taskList.isEmpty()){
            for(taskList){
                if(currentTime == task.getEnd){
                   /*
                   get task person
                   remove task from person
                    */
                }
            }
       }

       return null;




   }
}
