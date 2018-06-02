package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Kiosk;

public class AdminController {
	private Kiosk kiosk; 

	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}
	
	  @FXML 
	  void addCustomer(ActionEvent event) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AddCustomer.fxml"));
				Parent mainView = loader.load();
				
				AddCustomerController addCustomerController = (AddCustomerController) loader.getController();
				addCustomerController.setKisok(kiosk);
				
				// set up the view now and run it
		    	Scene mainScene = new Scene(mainView);
		    	Stage stage = new Stage();
		    	stage.setTitle("Add Customer");
		    	stage.setScene(mainScene);
		    	stage.initModality(Modality.WINDOW_MODAL);
		    	stage.initOwner(((Node)event.getSource()).getScene().getWindow());
		    	stage.show();
			} catch(IOException ioe) {
				System.out.println(ioe.getMessage());			
			}		  
	  }
}
