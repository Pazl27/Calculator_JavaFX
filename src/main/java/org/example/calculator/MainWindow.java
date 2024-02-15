package org.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindowInterface.fxml"));

        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/styles/MainWindowStyle.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);

        stage.setTitle("Calculator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();

        Image icon = new Image(getClass().getResourceAsStream("/images/icon.png"));
        stage.getIcons().add(icon);

        ((MainWindowController) loader.getController()).init(stage);
    }

    public void run() {
        launch();
    }
}