package controller;
import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Kiosk;

public class KioskController extends Controller<Kiosk> {
	private Kiosk kiosk;
	
  @FXML
  public void initialize() {

  }

  public void setKiosk(Kiosk kiosk) {
	  this.kiosk = kiosk;
  }
  public final Kiosk getKiosk() {
        return model;
    }

  
  @FXML 
  void openAdministration(ActionEvent event) {
		try {
			// Open the Admin Window and Close the Main Library window
			// ref: https://stackoverflow.com/questions/15041760/javafx-open-new-window
			// ref: https://stackoverflow.com/questions/10486731/how-to-create-a-modal-window-in-javafx-2-1
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Admin.fxml"));
			Parent mainView = loader.load();
			
			// Controller will need the Library object to act on things, pass it in
			// ref: https://stackoverflow.com/questions/27965401/passing-parameters-between-two-javafx-controllers
			AdminController adminController = (AdminController) loader.getController();
			adminController.setKisok(kiosk);
			
			// set up the view now and run it
	    	Scene mainScene = new Scene(mainView);
	    	Stage stage = new Stage();
	    	stage.setTitle("Administration Menu");
	    	stage.setScene(mainScene);
	    	stage.initModality(Modality.WINDOW_MODAL);
	    	stage.initOwner(((Node)event.getSource()).getScene().getWindow());
	    	stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}
  }
  
  @FXML 
  void exploreCatalogue(ActionEvent event) {
  }

  @FXML 
  void showCustomerRecord(ActionEvent event) {
  }

  @FXML 
  void topUpCustomer(ActionEvent event) {
  }

  @FXML 
  void showFavoriteCustomer(ActionEvent event) {
  }

}