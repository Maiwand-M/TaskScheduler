package main.java.view;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class View extends JFrame {

    private JList list;
    private DefaultListModel listModel;

    private JButton deleteButton;
    private JButton addPersonButton;
    private JButton nextbutton;
    private JTextField personName;
    private JLabel labelListPeople;

    public View() {

//        super(new BorderLayout());

        listModel = new DefaultListModel();
        //list created.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        //list is added to scrollpane
        JScrollPane listScrollPane = new JScrollPane(list);

        addPersonButton = new JButton("  add  ");
        addPersonButton.setEnabled(false);


        deleteButton = new JButton("delete");

        labelListPeople = new JLabel("List Of People:");

        personName = new JTextField(5);

        nextbutton = new JButton("Next");


        //BoxLayout panel created.
        JPanel buttonPane = new JPanel();

        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(addPersonButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(personName);
        buttonPane.add(deleteButton);

        buttonPane.add(nextbutton);

        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(listScrollPane, BorderLayout.CENTER);
        add(labelListPeople, BorderLayout.NORTH);
        add(buttonPane, BorderLayout.PAGE_END);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        this.setOpaque(true);
//        frame.setContentPane(this);
        setTitle("Project Task Scheduler");

        setPreferredSize(new Dimension(600, 400));

        pack();
        setVisible(true);

        setLocationRelativeTo(null);


    }


    public JButton getNextbutton() {
        return nextbutton;
    }

    public void updatePersonList(ArrayList<String> staffRoster) {
        int listSize = getListModel().getSize();
        for(int i = 0; i < listSize; i++) {
            getListModel().remove(0);
        }
        for(int i = 0; i < staffRoster.size(); i++) {
            getListModel().addElement(staffRoster.get(i));
        }
    }


    public JTextField getPersonName() {
        return personName;
    }

    public JList getList() {
        return list;
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

    public JButton getAddPersonButton() {
        return addPersonButton;
    }

    public JButton getNextButton() { return nextbutton;}

    public JButton getDeleteButton() {
        return deleteButton;
    }

}
