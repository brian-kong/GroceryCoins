package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class UI extends Application {
    private static BorderPane backgroundPanel = new BorderPane();
    public static Image coinImg;
    private static Pane resultPane = new Pane();
    private static HBox userControls = new HBox();
    private static VBox result = new VBox(10);

    public void start(Stage stage) throws Exception {

        Button uploadButton = new Button();
        Label uploadLabel = new Label();
        uploadLabel.setPrefSize(100, 100);

        // Combobox for key list of cents
        ComboBox smallestCoinChoices = new ComboBox();
        LinkedHashMap<String, Integer> dictionary = new LinkedHashMap<String, Integer>();

        dictionary.put("Nickel - 5c", 5);
        dictionary.put("Dime - 10c", 10);
        dictionary.put("Quarter - 25c", 25);
        dictionary.put("Loonie - $1", 1);
        dictionary.put("Toonie - $2", 2);

        List keys = new ArrayList<>(dictionary.keySet());

        for (int i = 0; i < keys.size(); i++) {
            smallestCoinChoices.getItems().add(keys.get(i));
        }

        // MouseEvent input needed
        uploadButton.addEventFilter(MouseEvent.MOUSE_CLICKED, filter -> {
            FileChooser imgUploaded = new FileChooser();
            imgUploaded.setTitle("Uploaded Image");

            File file = imgUploaded.showOpenDialog(null);

            if (file != null) {
                String imgLocation = file.toURI().toString();
                System.out.println();
                uploadLabel.setText(imgLocation);
                coinImg = new Image(imgLocation);
            }
        });

        // Add in buttons/user inputs
        Button runBotton = new Button("Count coins");

        userControls.getChildren().addAll(uploadButton, uploadLabel, smallestCoinChoices);
        result.getChildren().add(runBotton);
        backgroundPanel.setRight(result);
        backgroundPanel.setBottom(userControls);

        Scene inputScene = new Scene(backgroundPanel, 400, 500);

    }
        // Check if comboBox exists
        private static boolean isSmallestExist(ComboBox comboBox) {
            if (comboBox.getValue() != null) {
                return true;
            } else {
                return false;
            }
        }

    // launch standalone Application
    public static void main(String[] args) {
        launch(args);
    }
}
