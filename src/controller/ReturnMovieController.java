
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

public class ReturnMovieController  {
	private Kiosk kiosk;
	
	@FXML private TextField txtCustomerID;
	@FXML private Button btnSelectCustomer;	
	
	@FXML private TableView<Movie> tblRentedMovies;
	
	@FXML private TableColumn<Customer, String> tblColMovieTitle;
	@FXML private TableColumn<Customer, String> tblColMovieYear;
	@FXML private TableColumn<Customer, String> tblColMovieGenre;
	@FXML private TableColumn<Customer, String> tblColMoviePrice;
	
	@FXML private TextArea txtReturnMovieMessage;
	@FXML private Button btnreturnSelectedMovie;
	@FXML private Button btnCloseReturnMovie;

	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}
	
	@FXML 
	void showRentedMovies(ActionEvent event) {
		tblColMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));		
		tblColMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		tblColMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
		tblColMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));

		Customer customerReturningMovie = kiosk.getCustomer(Integer.parseInt(txtCustomerID.getText()));
		if (customerReturningMovie.currentlyRented().size() == 0) {
			txtReturnMovieMessage.setText("Customer " + customerReturningMovie.getName() + " has not rented out any movies");
		} else {
			tblRentedMovies.setItems(customerReturningMovie.currentlyRented());			
		}
	}

	@FXML 
	void returnSelectedMovie(ActionEvent event) {
		Customer customerReturningMovie = kiosk.getCustomer(Integer.parseInt(txtCustomerID.getText()));
		
		int selectedIndex = tblRentedMovies.getSelectionModel().getSelectedIndex();
		if (selectedIndex != -1) {
			Movie movieToReturn = tblRentedMovies.getSelectionModel().getSelectedItem();
			kiosk.getCatalogue().returnMovieFromCustomer(movieToReturn, customerReturningMovie);
			txtReturnMovieMessage.setText("Movie " + movieToReturn.getTitle() + " has been returned");
		}
	}	
}