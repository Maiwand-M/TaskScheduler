package main;

import controller.Controller;
import model.Scheduler;
import view.View;

public class Main {

	public static void main(String[] Args) {

        Scheduler model = new Scheduler();
        View view = new View();
        Controller controller = new Controller(model, view);

	}

}
