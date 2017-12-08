package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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
        view.getPersonName().addActionListener(addPersonListener);
        view.getPersonName().getDocument().addDocumentListener(addPersonListener);

        view.getDeleteButton().addActionListener(new deleteListener());

    }

    class addPersonListener implements ActionListener, DocumentListener {

        /*

        The process of adding a person should be as follows:

        1) add button is pressed
        2) the name (as a string) is taken from the text field
        3) this string is passed to the model addPerson(String name)
        -- every time the model changes the UI should be updated--
        4) updatePerosonList is called

           void updatePersonList{
                view.showPeople(model.getPersonList())
                }
         */
        private boolean buttonStatus = false;
        private JButton button;

        public addPersonListener(JButton button){
            this.button = button;
        }

        public void actionPerformed(ActionEvent e){
            String name = view.getPersonName().getText();

            //User didn't type in a unique name...
            if (name.equals("") || alreadyInList(name)){

                view.getPersonName().requestFocusInWindow();
                view.getPersonName().selectAll();

                return;
            }

            int i = view.getList().getSelectedIndex(); //get selected index
            if (i == -1) { //no selection, so insert at beginning
                i = 0;
            } else {           //add after the selected item
                i++;
            }
            //adding the person to the view.getList()
            model.addPerson(name);
            view.getListModel().addElement(model.getStaffRoster().get(model.getStaffRoster().size()-1).getName());

            //Reseting the text field.
            view.getPersonName().setText("");

            view.getList().setSelectedIndex(i);
        }

        //checks if given name is already in the list
        protected boolean alreadyInList(String name){

            return view.getListModel().contains(name);
        }

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

        /*

        The process of deleting an entry from the person list should be as follows:

        1) delete button is pressed
        2) the name (as a string) is taken from the visual list
        3) this string is passed to the model removePerson(String personName)
        -- every time the model changes the UI should be updated--
        4) updateTaskList is called

           void updatePersonList{
                view.clear()? ///
                view.showPeople(model.getTaskList())
                }

                ^^^^^
                The implementation of this is up to the view and controller but this is the gist of what needs to happen
                The name of every person (string) should be extracted from the Person object using Person.getName()
                Then either, put into an Array/ArrayList<String> and passed to the view to be displayed

                As we dicussed in the lab there was some disagreement in whethere or not the view should be freshly
                updated each time the model changes: actually this is not up to me. So long as it is coded in such a way
                there is no inconsistency between the model and view it's all good with me.
         */
        public void actionPerformed(ActionEvent e) {

            int i = view.getList().getSelectedIndex();
            view.getListModel().remove(i);

            //if list size equals to zero do nothing
            if (view.getListModel().getSize() == 0) {


            } else {
                //remove last
                if (i == view.getListModel().getSize()) {

                    i--;
                }

                view.getList().setSelectedIndex(i);
            }
        }
    }

}
