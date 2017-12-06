package main;

import controller.Controller;
import model.Scheduler;
import view.*;

public class Main {

	public static void main(String[] Args) {

        Scheduler model = new Scheduler();
        View view = new View();
        Controller controller = new Controller(model, view);
        pageForm2 form = new pageForm2();


    }

}
