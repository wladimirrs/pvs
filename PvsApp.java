package pvs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PvsApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PvsApp.class.getResource("Dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1100 , 900);
        stage.setResizable(false);
        stage.setTitle("Projektverwaltungssystem");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}