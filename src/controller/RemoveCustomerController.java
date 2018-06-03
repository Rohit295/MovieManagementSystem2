package controller;

import javafx.event.ActionEvent;
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
	
	@FXML private Button btnRemoveCustomer;
	@FXML private Button btnCloseRemoveCustomer;
	@FXML private TextArea txtRemoveCustomerMessage ;
		
	
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

	
	  @FXML 
	  void removeCustomer(ActionEvent event) {
		  int selectedIndex = tblCustomers.getSelectionModel().getSelectedIndex();
		  if (selectedIndex != -1) {
			  // ensure the customer does not have a movie rented out currently
			  Customer selectedCustomer = kiosk.getCustomers().get(selectedIndex);
			  if (selectedCustomer.hasCurrentlyRented()) {
				  txtRemoveCustomerMessage.setText("Customer has currently rented movie and cannot be removed.");		
			  } else {
				  kiosk.getCustomers().remove(selectedIndex);
				  txtRemoveCustomerMessage.setText("Customer " + selectedCustomer.getName() + " has been removed");
			  }
		  }
		  else {
			  txtRemoveCustomerMessage.setText("Please select a customer to remove first");
		  }
	  }
}