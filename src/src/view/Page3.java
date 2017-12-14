package view;

import javax.swing.*;
import java.awt.*;

public class Page3 extends JFrame{
    private JPanel thatPanel;
    private JButton goBackButton;
    private JList list1;


    public Page3() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        this.setOpaque(true);
//        frame.setContentPane(this);
        setTitle("Project Task Scheduler");

        setContentPane(thatPanel);

        setPreferredSize(new Dimension(600, 400));


        pack();

        setLocationRelativeTo(null);


    }

    public JButton getGoBackButton() {
        return goBackButton;
    }
}
