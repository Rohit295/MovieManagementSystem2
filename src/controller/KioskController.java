package controller;
import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
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
  
  public final Stage getStage() {
	  return stage;
  }

  
  @FXML 
  void openAdministration(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Admin.fxml"));
			Parent mainView = loader.load();
			AdminController adminController = (AdminController) loader.getController();
			adminController.setKisok(getKiosk());
			
			// set up the view now and run it
	    	Scene mainScene = new Scene(mainView);
	    	Stage stage = new Stage();
	    	stage.setTitle("Administration Menu");
	    	stage.setScene(mainScene);
	    	stage.initModality(Modality.WINDOW_MODAL);
	    	stage.initOwner(((Node)event.getSource()).getScene().getWindow());
	    	stage.show();

	    	//ViewLoader.showStage(getKiosk(), "/view/Admin.fxml", "Administration Menu", new Stage());

		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}
  }
  
  @FXML 
  void exploreCatalogue(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Catalogue.fxml"));
			Parent mainView = loader.load();
			CatalogueController catalogueController = (CatalogueController) loader.getController();
			catalogueController.setKisok(getKiosk());
			
			// set up the view now and run it
			Scene mainScene = new Scene(mainView);
			Stage stage = new Stage();
			stage.setTitle("Catalogue");
			stage.setScene(mainScene);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}
  }

	@FXML 
	void showCustomerRecord(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CustomerRecord.fxml"));
			Parent mainView = loader.load();
			CustomerRecordController customerRecordController = (CustomerRecordController) loader.getController();
			customerRecordController.setKisok(getKiosk());
			
			// set up the view now and run it
			Scene mainScene = new Scene(mainView);
			Stage stage = new Stage();
			stage.setTitle("Patron Record");
			stage.setScene(mainScene);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}
	}

	@FXML 
	void topUpCustomer(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TopUpAccount.fxml"));
			Parent mainView = loader.load();
			TopUpAccountController topUpAccountController = (TopUpAccountController) loader.getController();
			topUpAccountController.setKisok(getKiosk());
			
			// set up the view now and run it
			Scene mainScene = new Scene(mainView);
			Stage stage = new Stage();
			stage.setTitle("Account Top-Up");
			stage.setScene(mainScene);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}
	}

	@FXML 
	void showFavoriteCustomer(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FavouriteMovies.fxml"));
			Parent mainView = loader.load();
			FavouriteMoviesController favouriteMoviesController = (FavouriteMoviesController) loader.getController();
			favouriteMoviesController.setKisok(getKiosk());
			
			// set up the view now and run it
			Scene mainScene = new Scene(mainView);
			Stage stage = new Stage();
			stage.setTitle("Favourites");
			stage.setScene(mainScene);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}
	}

}