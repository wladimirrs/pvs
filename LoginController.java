package pvs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {

    @FXML                       // Buttons
    private Button btnRegister;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnAusfuehren;

    @FXML
    private Button btnBeenden;

    @FXML                       // Fenster content und main (mitte und oben)
    private AnchorPane contentPane;

    @FXML
    private BorderPane mainPane;



    @FXML private TextField txtEmail;
    @FXML private PasswordField txtPasswort;





    @FXML
    void beenden(ActionEvent event) { // App beenden
        System.exit(0);
    }


    @FXML
    void loadLogin(ActionEvent event) {                         // zum Login
        ViewLoader loader = new ViewLoader();
        Pane view = loader.loadView("LoginView");

        if (view != null) {
            mainPane.getChildren().clear();
            mainPane.getChildren().add(view);

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
        }
    }

    @FXML
    void loadRegister(ActionEvent event) {                      // zum Registrieren
        ViewLoader loader = new ViewLoader();
        Pane view = loader.loadView("RegisterView");

        if (view != null) {
            mainPane.getChildren().clear();
            mainPane.getChildren().add(view);

            AnchorPane.setTopAnchor(view, 0.0);  // Rand
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);
        }
    }

    @FXML
    void loadAusfuehren(ActionEvent event) throws Exception {

        boolean ok = NutzerDAO.login(txtEmail.getText(), txtPasswort.getText());
        if (ok) {
            ViewLoader viewLoader = new ViewLoader();
            Pane view = viewLoader.loadView("Dashboard");
            mainPane.getChildren().clear();
            mainPane.getChildren().add(view);

            AnchorPane.setTopAnchor(view, 0.0);
            AnchorPane.setBottomAnchor(view, 0.0);
            AnchorPane.setLeftAnchor(view, 0.0);
            AnchorPane.setRightAnchor(view, 0.0);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Benutzername oder Passwort falsch");
            alert.showAndWait();
        }
    }








}
