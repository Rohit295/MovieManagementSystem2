
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
import model.Movie;

public class FavouriteMoviesController  {
	private Kiosk kiosk;
	
	@FXML private TextField txtCustomerID;
	@FXML private Button btnSelectCustomer;	
	
	@FXML private TableView<Movie> tblFavouriteMovies;
	
	@FXML private TableColumn<Customer, String> tblColMovieTitle;
	@FXML private TableColumn<Customer, String> tblColMovieYear;
	@FXML private TableColumn<Customer, String> tblColMovieGenre;
	@FXML private TableColumn<Customer, String> tblColMoviePrice;
	
	@FXML private Button btnCloseRemoveMovie;

	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	@FXML 
	void showFavouriteMoviesFor(ActionEvent event) {
		Customer customerToList = kiosk.getCustomer(Integer.parseInt(txtCustomerID.getText()));
	  
		tblColMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));		
		tblColMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		tblColMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
		tblColMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
	
		tblFavouriteMovies.setItems(customerToList.favouriteMovies());
	}

	
	
}
