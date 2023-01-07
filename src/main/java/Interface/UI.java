package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx. scene.text.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import nu.pattern.OpenCV;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Mat;

public class UI extends Application {
    private static BorderPane backgroundPanel = new BorderPane();
    public static Image coinImg;
    private static HBox userControls = new HBox(22.5);
    private static VBox result = new VBox();
    private static String imgLocation;
    private TableView resultTable = new TableView();

    private static HashMap<String, Integer> coinCount = null;
    private static Integer total = null;

    public void start(Stage stage) throws Exception {

        Button uploadButton = new Button();
        Label uploadLabel = new Label();
        uploadLabel.setPrefSize(100, 100);
        Text filler = new Text();

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
                OpenCV.loadShared();
                imgLocation = file.toURI().toString();
                System.out.println("img uploaded");
                coinImg = new Image(imgLocation);
                Mat src = Imgcodecs.imread(imgLocation);
            }
        });

        // Add in buttons/user inputs
        Button runBotton = new Button("Count coins");
        runBotton.addEventFilter(MouseEvent.MOUSE_CLICKED, filter -> {
            if (smallestCoinChoices.getValue() != null && imgLocation != null){
                System.out.println("success");
            }
        });

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
