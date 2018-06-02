
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Kiosk;

public class AddCustomerController {
	private Kiosk kiosk; 
	
	@FXML private TextField txtID;
	@FXML private TextField txtName;
	@FXML private TextField txtBalance;
	@FXML private TextArea txtAddCustomerMessage;
	
	@FXML private Button btnAddCustomer;
	@FXML private Button btnCloseAddCustomer;
	


	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	  @FXML 
	  void addCustomer(ActionEvent event) {
		  kiosk.addCustomer(Integer.parseInt(txtID.getText()), txtName.getText(), Integer.parseInt(txtBalance.getText()));
		  
		  // set a confirmation message and clear the fields for a new customer to be added
		  txtAddCustomerMessage.setText("Customer added");
		  txtID.setText("");
		  txtName.setText("");
		  txtBalance.setText("");
	  }
	  
}