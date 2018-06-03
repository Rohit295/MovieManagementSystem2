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

public class RemoveMovieController {

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
		tblColMovieTitle.setText("Title");
		tblColMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));		
		tblColMovieYear.setText("Year");
		tblColMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		tblColMovieGenre.setText("Genre");
		tblColMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
		tblColMoviePrice.setText("Price");
		tblColMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		tblMovies.setItems(kiosk.getCatalogue().getAvailableMovies());
	}
	
	
	  @FXML 
	  void removeMovie(ActionEvent event) {
		  int selectedIndex = tblMovies.getSelectionModel().getSelectedIndex();
		  if (selectedIndex != -1) {
			  Movie movieToRemove = kiosk.getCatalogue().getAvailableMovies().get(selectedIndex);
			  kiosk.getCatalogue().getAvailableMovies().remove(selectedIndex);
			  txtRemoveMovieMessage.setText(movieToRemove.getTitle() + " removed from catalogue");
		  }
		  else {
			  txtRemoveMovieMessage.setText("Please select a movie to remove first");
			  }
		  }

	  @FXML 
	  void closeRemoveMovie(ActionEvent event) {
		  ((Stage)btnCloseRemoveMovie.getScene().getWindow()).close();
	  }

}
