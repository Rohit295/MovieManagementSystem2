
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

public class CustomerRecordController {
	private Kiosk kiosk;

	@FXML private TextField txtCustomerID;
	@FXML private Button btnSelectCustomer;	
	
	@FXML private TableView<Movie> tblRentedMovies;
	@FXML private TableView<Movie> tblRentingHistory;
	
	@FXML private TableColumn<Customer, String> tblColMovieTitle;
	@FXML private TableColumn<Customer, String> tblColMovieYear;
	@FXML private TableColumn<Customer, String> tblColMovieGenre;
	@FXML private TableColumn<Customer, String> tblColMoviePrice;

	@FXML private TableColumn<Customer, String> tblColRentingHistoryMovieTitle;
	@FXML private TableColumn<Customer, String> tblColRentingHistoryMovieYear;
	@FXML private TableColumn<Customer, String> tblColRentingHistoryMovieGenre;
	@FXML private TableColumn<Customer, String> tblColRentingHistoryMoviePrice;

	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	@FXML 
	void showCustomerRecord(ActionEvent event) {
		Customer customerRecordFor = kiosk.getCustomer(Integer.parseInt(txtCustomerID.getText()));
		
		tblColMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));		
		tblColMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		tblColMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
		tblColMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));

		tblColRentingHistoryMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));		
		tblColRentingHistoryMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
		tblColRentingHistoryMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
		tblColRentingHistoryMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		tblRentedMovies.setItems(customerRecordFor.currentlyRented());
		tblRentingHistory.setItems(customerRecordFor.rentingHistory());
	}
}
