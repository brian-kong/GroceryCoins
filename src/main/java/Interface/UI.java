package Interface;

import Models.CoinMatrixAnalysis;
import Models.Exceptions.RatioNotFound;
import javafx.application.Application;

import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import nu.pattern.OpenCV;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.Mat;

import openCV.ScanCoin;
import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;

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
            }
        });

        // Add in buttons/user inputs
        Button runBotton = new Button("Count coins");
        runBotton.addEventFilter(MouseEvent.MOUSE_CLICKED, filter -> {
            if (smallestCoinChoices.getValue() != null && imgLocation != null){
                System.out.println("success");

                // Add in other classes
                System.out.println(imgLocation.substring(5));

                Mat src = Imgcodecs.imread(imgLocation.substring(5), IMREAD_COLOR);
                ArrayList<Integer> sizes = ScanCoin.findCoins(src);

                HashMap<Double, Integer> coins = null;

                try {
                    coins = CoinMatrixAnalysis.countRatio(sizes);
                } catch (RatioNotFound e) {

                }

                String smallestCoinName = "";

                // TODO
            }

            else if (imgLocation == null) {
                final Stage popUp = new Stage();
                popUp.initModality(Modality.APPLICATION_MODAL);
                popUp.initOwner(stage);
                VBox popUpBox = new VBox(20);
                popUpBox.getChildren().add(new Text("Please upload a valid image."));
                Scene popUpScene = new Scene(popUpBox, 200, 50);
                popUp.setScene(popUpScene);
                popUp.show();
            }
            else if (smallestCoinChoices.getValue() == null) {
                final Stage popUp = new Stage();
                popUp.initModality(Modality.APPLICATION_MODAL);
                popUp.initOwner(stage);
                VBox popUpBox = new VBox(20);
                popUpBox.getChildren().add(new Text("Please select the lowest valued coin"));
                Scene popUpScene = new Scene(popUpBox, 200, 50);
                popUp.setScene(popUpScene);
                popUp.show();
            }
        });

        Integer smallestCoinValue = dictionary.get(smallestCoinChoices.getValue());
        userControls.getChildren().addAll(filler, uploadButton, smallestCoinChoices, runBotton);

        result.setAlignment(Pos.CENTER);
        Label resultLabel = new Label("Result");

        resultTable.setEditable(false);
        TableColumn coinTypeCol = new TableColumn("Coin Type");
        TableColumn coinAmountCol = new TableColumn("Amount");
        resultTable.getColumns().addAll(coinTypeCol, coinAmountCol);

        coinTypeCol.setMinWidth(200);
        coinAmountCol.setMinWidth(200);

        result.getChildren().addAll(resultLabel, resultTable, userControls);

        backgroundPanel.setCenter(result);

        Scene inputScene = new Scene(backgroundPanel, 400, 500);


    }

    // launch standalone Application
    public static void main(String[] args) {
        launch(args);
    }
}
