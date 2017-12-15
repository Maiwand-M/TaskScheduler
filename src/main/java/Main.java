package main.java;

import main.java.controller.Controller;
import main.java.model.Compute;
import main.java.view.SecondPage;
import main.java.view.ThirdPage;
import main.java.view.View;

public class Main {

	public static void main(String[] Args) {

        Compute model = new Compute();
        View view = new View();
        SecondPage p2 = new SecondPage();
        ThirdPage p3 = new ThirdPage();

        Controller controller = new Controller(model, view, p2, p3);

    }

}
