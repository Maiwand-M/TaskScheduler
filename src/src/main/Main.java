package main;

import controller.Controller;
import model.Compute;
import view.*;

public class Main {

	public static void main(String[] Args) {

        Compute model = new Compute();
        View view = new View();
        Page2 p2 = new Page2();
        Page3 p3 = new Page3();

        Controller controller = new Controller(model, view, p2, p3);
//        PageForm2 form = new PageForm2();
//        ScheduleView sv = new ScheduleView();


    }

}
