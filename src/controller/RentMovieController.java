package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import model.Kiosk;
import model.Movie;

public class RentMovieController {
	private Kiosk kiosk;
	
	@FXML private TextField txtCustomerID;
	@FXML private Button btnSelectCustomer;	
	
	@FXML private TableView<Movie> tblAvailableMovies;
	
	@FXML private TableColumn<Customer, String> tblColMovieTitle;
	@FXML private TableColumn<Customer, String> tblColMovieYear;
	@FXML private TableColumn<Customer, String> tblColMovieGenre;
	@FXML private TableColumn<Customer, String> tblColMoviePrice;
	
	@FXML private Button btnRentSelectedMovie;
	@FXML private Button btnCloseRentMovie;

	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}
	
	@FXML 
	void showAvailableMovies(ActionEvent event) {
		Customer customerRentingMovie = kiosk.getCustomer(Integer.parseInt(txtCustomerID.getText()));
	  
		tblColMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));		
		tblColMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		tblColMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
		tblColMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
	
		tblAvailableMovies.setItems(kiosk.getCatalogue().getAvailableMovies());
	}

	@FXML 
	void rentSelectedMovie(ActionEvent event) {
		Customer customerRentingMovie = kiosk.getCustomer(Integer.parseInt(txtCustomerID.getText()));
		
		int selectedIndex = tblAvailableMovies.getSelectionModel().getSelectedIndex();
		if (selectedIndex != -1) {
			Movie movieToRent = kiosk.getCatalogue().getAvailableMovies().get(selectedIndex);
			kiosk.getCatalogue().rentMovieToCustomer(movieToRent, customerRentingMovie);
		}
	}	
}
