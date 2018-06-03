
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

public class CatalogueController {
	private Kiosk kiosk; 

	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}
	
	@FXML 
	void showAvailableMovies(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ShowAvailableMovies.fxml"));
			Parent mainView = loader.load();
			ShowAvailableMoviesController showAvailableMoviesController = (ShowAvailableMoviesController) loader.getController();
			showAvailableMoviesController.setKisok(kiosk);
			showAvailableMoviesController.buildMovieList();;
			
			// set up the view now and run it
			Scene mainScene = new Scene(mainView);
			Stage stage = new Stage();
			stage.setTitle("Available Movies");
			stage.setScene(mainScene);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}		
	}
	
	
	@FXML 
	void showMoviesByGenre(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ShowMoviesByGenre.fxml"));
			Parent mainView = loader.load();
			ShowMoviesByGenreController showMoviesByGenreController = (ShowMoviesByGenreController) loader.getController();
			showMoviesByGenreController.setKisok(kiosk);
			showMoviesByGenreController.buildGenresList();
			
			// set up the view now and run it
			Scene mainScene = new Scene(mainView);
			Stage stage = new Stage();
			stage.setTitle("Movies by Genre");
			stage.setScene(mainScene);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}		
	}
	
	@FXML 
	void rentAMovie(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/RentMovie.fxml"));
			Parent mainView = loader.load();
			RentMovieController rentMovieController = (RentMovieController) loader.getController();
			rentMovieController.setKisok(kiosk);
			
			// set up the view now and run it
			Scene mainScene = new Scene(mainView);
			Stage stage = new Stage();
			stage.setTitle("Rent a Movie");
			stage.setScene(mainScene);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}
	}

	@FXML 
	void returnAMovie(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ReturnMovie.fxml"));
			Parent mainView = loader.load();
			ReturnMovieController returnMovieController = (ReturnMovieController) loader.getController();
			returnMovieController.setKisok(kiosk);
			
			// set up the view now and run it
			Scene mainScene = new Scene(mainView);
			Stage stage = new Stage();
			stage.setTitle("Return a Movie");
			stage.setScene(mainScene);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());			
		}
	}
}