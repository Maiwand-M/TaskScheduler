package controller;

public class Controller {

    private Model model;
	private View view;

    public Controller(Model model, View view) {

        this.model = model;
        this.view = view;

    }
	
	    class deleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int i = list.getSelectedIndex();
            listModel.remove(i);

            //if list size equals to zero do nothing
            if (listModel.getSize() == 0) {


            } else {
                //remove last
                if (i == listModel.getSize()) {

                    i--;
                }

                list.setSelectedIndex(i);
            }
        }
    }

    class addPersonListener implements ActionListener, DocumentListener {

        private boolean buttonStatus = false;
        private JButton button;

        public addPersonListener(JButton button){

            this.button = button;
        }

        public void actionPerformed(ActionEvent e){
            String name = personName.getText();

            //User didn't type in a unique name...
            if (name.equals("") || alreadyInList(name)){

                personName.requestFocusInWindow();
                personName.selectAll();

                return;
            }

            int i = list.getSelectedIndex(); //get selected index
            if (i == -1) { //no selection, so insert at beginning
                i = 0;
            } else {           //add after the selected item
                i++;
            }
            //adding the person to the list
            listModel.addElement(personName.getText());

            //Reseting the text field.
            personName.setText("");

            list.setSelectedIndex(i);
        }

        //checks if given name is already in the list
        protected boolean alreadyInList(String name){

            return listModel.contains(name);
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

}
