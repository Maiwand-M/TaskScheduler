package controller;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

import model.Compute;
import model.Task;
import view.SecondPage;
import view.ThirdPage;
import view.View;

public class Controller {

    private Compute model;
    private Task task;
	private View view;
	private SecondPage page2;
	private ThirdPage page3;

    public Controller(Compute m, View v, SecondPage p2, ThirdPage p3) {

        this.model = m;
        this.view = v;
        page2 = p2;
        page3 = p3;


        // Listeners

        addPersonListener addPersonListener = new addPersonListener(view.getAddPersonButton());
        view.getAddPersonButton().setActionCommand("  add  ");
        view.getAddPersonButton().addActionListener(addPersonListener);

        view.getDeleteButton().setActionCommand("delete");
        view.getDeleteButton().addActionListener(new deleteListener());


        page2.getSubmitButton().setActionCommand("submit");
        page2.getSubmitButton().addActionListener(new submitListener());


        view.getNextButton().addActionListener(e ->{

            page2.setVisible(true);
            view.setVisible(false);

        });


        page2.getNextButton().addActionListener(e ->{

            page3.setVisible(true);
            page2.setVisible(false);

        });

        page2.getBackButton().addActionListener(e ->{

            view.setVisible(true);
            page2.setVisible(false);

        });


        page3.getGoBackButton().addActionListener(e -> {
            page2.setVisible(true);
            page3.setVisible(false);

        });


        view.getPersonName().addActionListener(addPersonListener);
        view.getPersonName().getDocument().addDocumentListener(addPersonListener);
    }

    class addPersonListener implements ActionListener, DocumentListener {
        private boolean buttonStatus = false;
        private JButton button;

        public addPersonListener(JButton button){
            this.button = button;
        }

        public void actionPerformed(ActionEvent e){
            String name = view.getPersonName().getText();

            //User didn't type in a unique name...
            if (name.equals("")){

                view.getPersonName().requestFocusInWindow();
                view.getPersonName().selectAll();

                return;
            }

            model.addPerson(name);
            ArrayList<String> staffRoster = new ArrayList<String>();
            for(int i = 0; i < model.getStaffRoster().size(); i++) {
                staffRoster.add(model.getStaffRoster().get(i).getName());
            }
            view.updatePersonList(staffRoster);

            //Reseting the text field.
            view.getPersonName().setText("");

            //move selection to end
            view.getList().setSelectedIndex(view.getListModel().getSize()-1);
        }


        //Removed as this check should be done inside the model by the model
        //checks if given name is already in the list

        /*protected boolean alreadyInList(String name){


        protected boolean alreadyInList(String name){

            return view.getListModel().contains(name);
        }*/

        //enabling the button if text if the written text is valid
        public void insertUpdate(DocumentEvent e){
            enableButton();
        }

        //handling the empty field
        public void removeUpdate(DocumentEvent e){
            handleEmptyTextField(e);
        }

        //again checking the text field is not empty
        public void changedUpdate(DocumentEvent e){
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        //enabling the button
        private void enableButton(){
            if (!buttonStatus) {
                button.setEnabled(true);
            }
        }

        //handling if the text field is empty
        private boolean handleEmptyTextField(DocumentEvent e){
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                buttonStatus = false;
                return true;
            }
            return false;
        }
    }



	class deleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(view.getListModel().size() > 0) {
                int i = view.getList().getSelectedIndex();

                model.removePerson(view.getListModel().get(i).toString());
                ArrayList<String> staffRoster = new ArrayList<String>();
                for(int j = 0; j < model.getStaffRoster().size(); j++) {
                    staffRoster.add(model.getStaffRoster().get(j).getName());
                }
                view.updatePersonList(staffRoster);

                //remove last
                if (i == view.getListModel().getSize()) {
                    i--;
                }
                view.getList().setSelectedIndex(i);
            }
        }
    }


    class submitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.addTask(page2.getPleaseEnterTaskTextField().getText(),page2.getComboBox1().getItemCount(),page2.getComboBox2().getItemCount());
            model.schedule();
            ArrayList<String> scheduleRoster = new ArrayList<String>();
            for(int i = 0; i < model.getSchedule().size(); i++) {
                scheduleRoster.add(model.getSchedule().get(i).toString());
            }
            page3.updateScheduleList(scheduleRoster);

            System.out.println("try");

        }
    }




}
