package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Customer;
import model.Kiosk;

public class TopUpAccountController  {
	private Kiosk kiosk;
	
	@FXML private TextField txtCustomerToTopUp;
	@FXML private TextField txtTopUpAmount;
	@FXML private TextField txtTopUpAccountMessage;
	
	
	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	@FXML 
	void topUpCustomerAccount(ActionEvent event) {
		Customer customerToTopUp = kiosk.getCustomer(Integer.parseInt(txtCustomerToTopUp.getText()));
		customerToTopUp.topUpAccount(Integer.parseInt(txtTopUpAmount.getText()));
		txtTopUpAccountMessage.setText(customerToTopUp.getName() + "'s new balance is: " + customerToTopUp.getBalance());
	}

}
