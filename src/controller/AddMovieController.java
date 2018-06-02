
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Kiosk;

public class AddMovieController  {
	private Kiosk kiosk; 
	
	@FXML private TextField txtTitle;
	@FXML private TextField txtYear;
	@FXML private TextField txtGenre;
	@FXML private TextField txtPrice;
	@FXML private TextArea txtAddMovieMessage;
	
	@FXML private Button btnAddMovie;
	@FXML private Button btnCloseAddMovie;
	


	public void setKisok(Kiosk kiosk) {
		this.kiosk = kiosk;
	}

	  @FXML 
	  void addMovie(ActionEvent event) {
		  kiosk.getCatalogue().addMovie(txtTitle.getText(), Integer.parseInt(txtYear.getText()), txtGenre.getText(), Integer.parseInt(txtPrice.getText()));
		
		  txtAddMovieMessage.setText("Added " + txtTitle.getText() + " to the catalogue");
		  txtTitle.setText("");
		  txtYear.setText("");
		  txtGenre.setText("");
		  txtPrice.setText("");
	  }
	  

}
