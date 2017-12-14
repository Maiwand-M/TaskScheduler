package view;

import javax.swing.*;
import java.awt.*;

public class Page2 extends JFrame{
    private JTextField pleaseEnterTaskTextField;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton submitButton;
    private JButton nextButton;
    private JButton backButton;
    private JPanel panelss;
    View v;


    public Page2(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        this.setOpaque(true);
//        frame.setContentPane(this);
        setTitle("Project Task Scheduler");

        setContentPane(panelss);

        setPreferredSize(new Dimension(600, 400));


        pack();

        setLocationRelativeTo(null);



    }

        public JButton getBackButton(){

        return backButton;
        }

       public JButton getNextButton(){

            return nextButton;
        }
}
