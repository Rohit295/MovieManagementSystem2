package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Customer;
import model.Genre;
import model.Kiosk;
import model.Movie;

public class ShowMoviesByGenreController {
	private Kiosk kiosk;
	
	@FXML private TableView<Movie> tblMovies;
	@FXML private ListView<Genre> lstGenres;
	
	@FXML private TableColumn<Customer, String> tblColMovieTitle;
	@FXML private TableColumn<Customer, String> tblColMovieYear;
	@FXML private TableColumn<Customer, String> tblColMovieGenre;
	@FXML private TableColumn<Customer, String> tblColMoviePrice;
	
	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	public void buildGenresList() {
		lstGenres.setItems(kiosk.getCatalogue().getGenres());
	}


	@FXML 
	void showMoviesInGenre(ActionEvent event) {
		int selectedIndex = lstGenres.getSelectionModel().getSelectedIndex();
		if (selectedIndex != -1) {
			Genre selectedGenre = kiosk.getCatalogue().getGenres().get(selectedIndex);

			tblColMovieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));		
			tblColMovieYear.setCellValueFactory(new PropertyValueFactory<>("year"));
			tblColMovieGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
			tblColMoviePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
			
			tblMovies.setItems(kiosk.getCatalogue().getMoviesInGenre(selectedGenre));
		}
	}

	@FXML 
	void closeShowMoviesInGenre(ActionEvent event) {
		((Stage)tblMovies.getScene().getWindow()).close();
	}
}
