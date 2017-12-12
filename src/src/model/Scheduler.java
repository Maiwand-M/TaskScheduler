package model;

import java.util.ArrayList;

public class Scheduler {
   ArrayList<Person> staffRoster;
    ArrayList<Task> taskList;
    ArrayList<Task> completedTasks;
    int currentTime = 0;

   public void addTask(String name,int effort){
       taskList.add(new Task(name,effort));
   }

   public void addPerson(String name){
       for(Person p : staffRoster){

           if(p.getName().equals(name)) return;
       }
       staffRoster.add(new Person(name));
   }

   public void assignTask(Person person,Task task,int currentTime){
       task.assignPerson(person,currentTime);
       person.assignTask(task);
   }


   public ArrayList<Task> getSchedule(){

        /*
        Punn???
         */


       /*while(!taskList.isEmpty()){
            for(taskList){
                if(currentTime == task.getEnd){

                   //get task person
                   //remove task from person

                }
            }
       }*/

       return null;




   }
}
