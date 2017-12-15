package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ThirdPage extends JFrame {


    private JPanel thatPanel;
    private JButton goBackButton;
    private JList list1;
    private DefaultListModel listModel;

    public ThirdPage() {

        listModel = new DefaultListModel();

        thatPanel = new JPanel();
        thatPanel.setLayout(new GridLayout(1, 3));
        thatPanel.setBorder(BorderFactory.createTitledBorder("The Schedule:"));
        goBackButton = new JButton();

        goBackButton.setText("Go Back");


        JPanel buttonPane = new JPanel();

        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(goBackButton);
        goBackButton.setPreferredSize(new Dimension(50, 60));

        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(thatPanel, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.SOUTH);


        list1 = new JList(listModel);
        //final DefaultListModel defaultListModel1 = new DefaultListModel();
        list1.setVisibleRowCount(5);
        /*defaultListModel1.addElement("arda \t\ttask1 \t\t\t05/06/2017");
        defaultListModel1.addElement("bob \t\ttask 2 \t\t\t06/12/2017");
        defaultListModel1.addElement("etc.etc");*/
        //list1.setModel(listModel);
        thatPanel.add(list1);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Project Task Scheduler");

        setPreferredSize(new Dimension(600, 400));

        pack();
        setLocationRelativeTo(null);


    }

    public JButton getGoBackButton() {
        return goBackButton;
    }
    public JPanel getThatPanel() {
        return thatPanel;
    }
    public DefaultListModel getListModel() {
        return listModel;
    }

    public JList getList1() {
        return list1;
    }

    public void updateScheduleList(ArrayList<String> staffRoster) {
        int listSize = getListModel().getSize();
        for(int i = 0; i < listSize; i++) {
            getListModel().remove(0);
        }
        for(int i = 0; i < staffRoster.size(); i++) {
            getListModel().addElement(staffRoster.get(i));
        }
    }




}
