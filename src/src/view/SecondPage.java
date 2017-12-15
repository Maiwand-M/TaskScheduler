package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.*;

public class SecondPage extends JFrame {


    private JTextField pleaseEnterTaskTextField;
        private JComboBox comboBox1;
        private JComboBox comboBox2;
        private JButton submitButton;
        private JButton nextButton;
        private JButton backButton;
        private JPanel panelss;


        public SecondPage(){


            panelss = new JPanel();
            panelss.setLayout(new GridLayout(7,1));
            panelss.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(), "Addition Of Tasks:"));
            pleaseEnterTaskTextField = new JTextField();
            pleaseEnterTaskTextField.setText("Please enter task...");
            panelss.add(pleaseEnterTaskTextField);
            pleaseEnterTaskTextField.setPreferredSize(new Dimension(100, 10));
            final JLabel label1 = new JLabel();
            label1.setText("Effort Required:");
            panelss.add(label1);

            final JLabel label2 = new JLabel();
            label2.setText("(Indicate Hours spent)");
            panelss.add(label2);

            comboBox1 = new JComboBox();
            final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
            defaultComboBoxModel1.addElement(1);
            defaultComboBoxModel1.addElement(2);
            defaultComboBoxModel1.addElement(3);
            defaultComboBoxModel1.addElement(4);
            defaultComboBoxModel1.addElement(5);
            defaultComboBoxModel1.addElement(6);
            defaultComboBoxModel1.addElement(7);
            defaultComboBoxModel1.addElement(8);
            defaultComboBoxModel1.addElement(9);
            defaultComboBoxModel1.addElement(10);


            comboBox1.setModel(defaultComboBoxModel1);

            panelss.add(comboBox1);

            final JLabel label3 = new JLabel();
            label3.setText("Select Dependancy:");
            panelss.add(label3);
            comboBox2 = new JComboBox();
            final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
            defaultComboBoxModel2.addElement("No Dependancies");

            comboBox2.setModel(defaultComboBoxModel2);

            panelss.add(comboBox2);

            submitButton = new JButton();
            submitButton.setText("Submit");

            nextButton = new JButton();
            nextButton.setText("Next");
            backButton = new JButton();
            backButton.setText("Back");
            panelss.add(backButton);



            JPanel buttonPane = new JPanel();

            buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
            buttonPane.add(backButton);
            buttonPane.add(Box.createHorizontalStrut(5));
            buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
            buttonPane.add(Box.createHorizontalStrut(5));

            buttonPane.add(submitButton);

            buttonPane.add(Box.createHorizontalStrut(5));
            buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
            buttonPane.add(Box.createHorizontalStrut(5));


            buttonPane.add(nextButton);


            buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            add(panelss, BorderLayout.CENTER);
            add(buttonPane, BorderLayout.SOUTH);


            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("Project Task Scheduler");
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

    public JTextField getPleaseEnterTaskTextField() {
        return pleaseEnterTaskTextField;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public JComboBox getComboBox2() {
        return comboBox2;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JPanel getPanelss() {
        return panelss;
    }

    }
