package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Kiosk;

public class RemoveCustomerController  {

	private Kiosk kiosk;
	
	@FXML private TableView<Customer> tblCustomers;
	
	@FXML private TableColumn<Customer, String> tblColCustomerID;
	@FXML private TableColumn<Customer, String> tblColCustomerName;
	@FXML private TableColumn<Customer, String> tblColCustomerBalance;
	
	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	public void buildCustomerList() {
		// set the Heading of each column. also each column needs to pull out specific property of customer, set that
		tblColCustomerID.setText("ID");
		tblColCustomerID.setCellValueFactory(new PropertyValueFactory<>("id"));		
		tblColCustomerName.setText("Name");
		tblColCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tblColCustomerBalance.setText("Balance");
		tblColCustomerBalance.setCellValueFactory(new PropertyValueFactory<>("balance"));
		
		tblCustomers.setItems(kiosk.getCustomers());
	}

}
