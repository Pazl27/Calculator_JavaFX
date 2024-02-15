package org.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.image.ImageView;
public class MainWindowController {
    @FXML private Pane titlePane;
    @FXML private ImageView btnClose;
    @FXML private ImageView btnMini;
    @FXML private Label lblDisplay;

    private double x,y;
    private double num1;
    private String operator;
    private final StringBuilder sb = new StringBuilder();
    public void init(Stage stage) {
        titlePane.setOnMouseClicked(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        // Somehow, the drag isn't really working
        titlePane.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
       btnClose.setOnMouseClicked(event -> {
            stage.close();
        });
        btnMini.setOnMouseClicked(event -> {
            stage.setIconified(true);
        });
    }

    @FXML
    void onNumberClick(MouseEvent event) {
        Pane pane = (Pane) event.getSource();
        Label label = (Label) pane.getChildren().get(0);

        sb.append(label.getText());
        lblDisplay.setText("");
        lblDisplay.setText(sb.toString());
    }

    @FXML
    void onSymbolClick(MouseEvent event) {
        Pane pane = (Pane) event.getSource();
        Label label = (Label) pane.getChildren().get(0);
        String operatorTemp = label.getText();

        if (operatorTemp.equals("=")) {
            double result = 0;
            switch (operator) {
                case "+" -> result = num1 + Double.parseDouble(sb.toString());
                case "-" -> result = num1 - Double.parseDouble(sb.toString());
                case "*" -> result = num1 * Double.parseDouble(sb.toString());
                case "/" -> result = num1 / Double.parseDouble(sb.toString());
            }
            lblDisplay.setText(String.valueOf(result));
        }else if(operatorTemp.equals("C")) {
            lblDisplay.setText("");
            sb.delete(0, sb.length());
            num1 = 0;
            operator = "";
        }else {
            operator = operatorTemp;
            lblDisplay.setText("");
            num1 = Integer.parseInt(sb.toString());
            sb.delete(0, sb.length());
            System.out.println(num1);
        }
    }
}
