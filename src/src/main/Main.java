package main;

import controller.Controller;
import model.Compute;
import view.*;

public class Main {

	public static void main(String[] Args) {

        Compute model = new Compute();
        View view = new View();
        SecondPage p2 = new SecondPage();
        ThirdPage p3 = new ThirdPage();

        Controller controller = new Controller(model, view, p2, p3);

    }

}
