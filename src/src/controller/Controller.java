package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;

import model.Scheduler;
import view.View;

public class Controller {

    private Scheduler model;
	private View view;

    public Controller(Scheduler m, View v) {

        this.model = m;
        this.view = v;

        // Listeners

        addPersonListener addPersonListener = new addPersonListener(view.getAddPersonButton());
        view.getAddPersonButton().setActionCommand("  add  ");
        view.getAddPersonButton().addActionListener(addPersonListener);

        view.getDeleteButton().setActionCommand("delete");
        view.getDeleteButton().addActionListener(new deleteListener());

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
}
