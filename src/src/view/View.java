package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class View extends JPanel {

    private JList list;
    private DefaultListModel listModel;

    private JButton deleteButton;
    private JButton addPersonButton;
    private JTextField personName;

    public View() {

        super(new BorderLayout());

        listModel = new DefaultListModel();
        listModel.addElement("");

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
        deleteButton.setActionCommand("delete");

        personName = new JTextField(5);
        String name = listModel.getElementAt(
                list.getSelectedIndex()).toString();

        //BoxLayout panel created.
        JPanel buttonPane = new JPanel();

        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(addPersonButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(personName);
        buttonPane.add(deleteButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);

        JFrame frame = new JFrame("List of People");
        frame.setSize( 600,100);
        frame.setPreferredSize(new Dimension(600,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setOpaque(true);
        frame.setContentPane(this);
        frame.setTitle("Project Task Scheduler");

        frame.setPreferredSize(new Dimension(600, 400));


        frame.pack();
        frame.setVisible(true);
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

    public JButton getDeleteButton() {
        return deleteButton;
    }

}
