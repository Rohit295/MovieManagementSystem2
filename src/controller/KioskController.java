package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Kiosk;

public class KioskController extends Controller<Kiosk> {

  @FXML
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }

  @FXML 
  void exploreCatalogue(ActionEvent event) {
  }

  @FXML 
  void showCustomerRecord(ActionEvent event) {
  }

  @FXML 
  void topUpCustomer(ActionEvent event) {
  }

  @FXML 
  void showFavoriteCustomer(ActionEvent event) {
  }

}