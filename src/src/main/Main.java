package main;

import controller.Controller;
import model.Compute;
import view.*;

public class Main {

	public static void main(String[] Args) {

        Compute model = new Compute();
        View view = new View();
        Controller controller = new Controller(model, view);
        //pageForm2 form = new pageForm2();


    }

}
