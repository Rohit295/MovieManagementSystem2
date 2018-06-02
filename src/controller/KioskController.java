package controller;
import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import model.Kiosk;

public class KioskController extends Controller<Kiosk> {

  @FXML
  public void initialize() {

  }

  public final Kiosk getKiosk() {
        return model;
    }

}
