package model;

import java.util.ArrayList;

public class Scheduler {
    ArrayList<Person> staffRoster = new ArrayList<Person>();
    ArrayList<Task> taskList = new ArrayList<Task>();
    ArrayList<Task> completedTasks = new ArrayList<Task>();
    int currentTime = 0;

   public void addTask(String name,int effort){
       taskList.add(new Task(name,effort));
   }

   public void addPerson(String name){
       staffRoster.add(new Person(name));
   }

   public void removePerson(String name){
       for(Person person : staffRoster){
           if(person.getName().equals(name)){
               staffRoster.remove(person);
           }
       }
   }

   public void removeTask(String taskName){

   }

   public void assignTask(Person person,Task task,int currentTime){
       task.assign(person,currentTime);
       person.assignTask(task);
   }

   public void getStaffRoster() {
       return staffRoster;
   }

   public ArrayList<Task> getTaskList(){
       return taskList;
    }

   public ArrayList<Task> getSchedule(){


        /*
        Punwong's code here please krub
         */

       /*while(!taskList.isEmpty()){
            for(taskList){
                if(currentTime == task.getEnd){


                }
            }
       }*/

       return null;




   }
}
