package mappe.del2.patient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * The type Patient register application.
 */
public class PatientRegisterApplication extends Application {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private Stage stage;
    @Override
    public void start(Stage primaryStage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        try {
            stage = primaryStage;
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            logger.severe("ERROR: An IOException has occurred. Cause: " + e.getCause());
            throw e;
        }
    }
}
