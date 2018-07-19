package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    private Deduction deduction = new Deduction();
    public TextField input;

    @FXML
    private Button nine;
    @FXML
    private Button six;
    @FXML
    private Button one;
    @FXML
    private Button clear;
    @FXML
    private Button seven;
    @FXML
    private Button three;
    @FXML
    private Button two;
    @FXML
    private Button point;
    @FXML
    private Button eight;
    @FXML
    private Button result;
    @FXML
    private Button zero;
    @FXML
    private Button doubleZero;
    @FXML
    private Label prom;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button div;
    @FXML
    private Button multi;
    @FXML
    private Button plus;
    @FXML
    private Button minus;

    @FXML
    void initialize() {
        initActions();
    }

    private void initActions() {
        one.setOnAction(event -> input.setText(input.getText() + "1"));
        two.setOnAction(event -> input.setText(input.getText() + "2"));
        three.setOnAction(event -> input.setText(input.getText() + "3"));
        four.setOnAction(event -> input.setText(input.getText() + "4"));
        five.setOnAction(event -> input.setText(input.getText() + "5"));
        six.setOnAction(event -> input.setText(input.getText() + "6"));
        seven.setOnAction(event -> input.setText(input.getText() + "7"));
        eight.setOnAction(event -> input.setText(input.getText() + "8"));
        nine.setOnAction(event -> input.setText(input.getText() + "9"));
        point.setOnAction(event -> input.setText(input.getText() + "."));
        div.setOnAction(event -> input.setText(input.getText() + " / "));
        multi.setOnAction(event -> input.setText(input.getText() + " * "));
        plus.setOnAction(event -> input.setText(input.getText() + " + "));
        minus.setOnAction(event -> input.setText(input.getText() + " - "));
        zero.setOnAction(event -> input.setText(input.getText() + "0"));
        doubleZero.setOnAction(event -> input.setText(input.getText() + "00"));
        clear.setOnAction(event -> input.setText(""));
        result.setOnAction(event -> {
            prom.setText(" deduction ...   ");
            try {
                input.setText(deduction.getResult(input.getText()));
            } catch (ArithmeticException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                prom.setText(" Incorrect input ...   ");
                input.setText("");
                initialize();
            }
        });
    }
}
