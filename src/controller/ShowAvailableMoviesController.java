package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;
import model.Kiosk;
import model.Movie;

public class ShowAvailableMoviesController {
	private Kiosk kiosk;
	
	@FXML private TableView<Movie> tblMovies;
	
	@FXML private TableColumn<Customer, String> tblColMovieTitle;
	@FXML private TableColumn<Customer, String> tblColMovieYear;
	@FXML private TableColumn<Customer, String> tblColMovieGenre;
	@FXML private TableColumn<Customer, String> tblColMoviePrice;
	
	@FXML private Button btnRemoveMovie;
	@FXML private Button btnCloseRemoveMovie;
	@FXML private TextArea txtRemoveMovieMessage ;
		
	
	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	public void buildMovieList() {
		// set the Heading of each column. also each column needs to pull out specific property of customer, set that
		tblColMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));		
		tblColMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		tblColMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
		tblColMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		tblMovies.setItems(kiosk.getCatalogue().getAvailableMovies());
	}

	  @FXML 
	  void closeRemoveMovie(ActionEvent event) {
		  ((Stage)btnCloseRemoveMovie.getScene().getWindow()).close();
	  }
}
