package model;

import java.util.ArrayList;
public class testMain{
    public static void main(String args[]){
        Person first = new Person("Martin");
        Person second = new Person("shaq");
        Person third = new Person("oneil");

        Task task1 = new Task("First task", 5, 0);
        Task task2 = new Task("second task", 5, 2);
        //task2.addDependancy(task1);
        Task task3 = new Task("third task", 5, 12);
        task3.addDependancy(task2);

        
        ArrayList<Task> b = new ArrayList<>();
        ArrayList<Person> z = new ArrayList<>();
        
        z.add(third);
        z.add(first);
        b.add(task2);
        b.add(task1);
        b.add(task3);
        Compute sys = new Compute(b,z);
        sys.schedule();
        sys.print();
        
    }
}
