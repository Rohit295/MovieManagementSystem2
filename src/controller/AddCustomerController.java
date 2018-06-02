
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Kiosk;

public class AddCustomerController {
	private Kiosk kiosk; 
	
	@FXML private TextField txtID;
	@FXML private TextField txtName;
	@FXML private TextField txtBalance;
	@FXML private TextArea txtAddCustomerMessage;


	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	  @FXML 
	  void addCustomer(ActionEvent event) {
		  kiosk.addCustomer(Integer.parseInt(txtID.getText()), txtName.getText(), Integer.parseInt(txtBalance.getText()));
		  txtAddCustomerMessage.setText("Customer added");
	  }
	  
}