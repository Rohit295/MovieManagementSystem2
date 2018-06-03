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
		    	stage.initOwner(((Node)event.getSource()).getScene().getWindow());
		    	stage.show();
			} catch(IOException ioe) {
				System.out.println(ioe.getMessage());			
			}		  
	  }

	  @FXML 
	  void addMovie(ActionEvent event) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AddMovie.fxml"));
				Parent mainView = loader.load();
				
				AddMovieController addMovieController = (AddMovieController) loader.getController();
				addMovieController.setKisok(kiosk);
				
				// set up the view now and run it
		    	Scene mainScene = new Scene(mainView);
		    	Stage stage = new Stage();
		    	stage.setTitle("Add Movie");
		    	stage.setScene(mainScene);
		    	stage.initOwner(((Node)event.getSource()).getScene().getWindow());
		    	stage.show();
			} catch(IOException ioe) {
				System.out.println(ioe.getMessage());			
			}		  
	  }

	  @FXML 
	  void removeCustomer(ActionEvent event) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RemoveCustomer.fxml"));
				Parent mainView = loader.load();
				
				RemoveCustomerController removeCustomerController = (RemoveCustomerController) loader.getController();
				removeCustomerController.setKisok(kiosk);
				removeCustomerController.buildCustomerList();
				
				// set up the view now and run it
		    	Scene mainScene = new Scene(mainView);
		    	Stage stage = new Stage();
		    	stage.setTitle("Remove customer");
		    	stage.setScene(mainScene);
		    	stage.initOwner(((Node)event.getSource()).getScene().getWindow());
		    	stage.show();
			} catch(IOException ioe) {
				System.out.println(ioe.getMessage());			
			}		  
	  }

	  @FXML 
	  void removeMovie(ActionEvent event) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RemoveMovie.fxml"));
				Parent mainView = loader.load();
				
				RemoveMovieController removeMovieController = (RemoveMovieController) loader.getController();
				removeMovieController.setKisok(kiosk);
				removeMovieController.buildMovieList();
				
				// set up the view now and run it
		    	Scene mainScene = new Scene(mainView);
		    	Stage stage = new Stage();
		    	stage.setTitle("Remove Movie");
		    	stage.setScene(mainScene);
		    	stage.initOwner(((Node)event.getSource()).getScene().getWindow());
		    	stage.show();
			} catch(IOException ioe) {
				System.out.println(ioe.getMessage());			
			}		  
	  }
}
