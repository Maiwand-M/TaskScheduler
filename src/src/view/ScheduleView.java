package view;


import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class ScheduleView extends JPanel {

    private JList list;
    private DefaultListModel listModel;

    public ScheduleView() {

        super(new BorderLayout());

        listModel = new DefaultListModel();
        //list created.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);

        //list is added to scrollpane
        JScrollPane listScrollPane = new JScrollPane(list);
        add(listScrollPane, BorderLayout.CENTER);

        JFrame frame = new JFrame("ScheduleView");
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

    public void updateScheduleList(ArrayList<String> staffRoster) {
        int listSize = getListModel().getSize();
        for(int i = 0; i < listSize; i++) {
            getListModel().remove(0);
        }
        for(int i = 0; i < staffRoster.size(); i++) {
            getListModel().addElement(staffRoster.get(i));
        }
    }


    public JList getList() {
        return list;
    }

    public DefaultListModel getListModel() {
        return listModel;
    }

}
