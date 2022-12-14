package com.applicationfirst.temperatureconverterapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;

    @FXML
    public ChoiceBox<String> choiceBox;
    private final static String C_TO_F_TEXT = "Celsius to Fahrenheit";
    private final static String F_TO_C_TEXT = "Fahrenheit to Celsius";

    private boolean isC_TO_F = true;

    @FXML
    public TextField userInputField;

    @FXML
    public Button convertButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);
        choiceBox.setValue(C_TO_F_TEXT);

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {

                if(newValue.equals(C_TO_F_TEXT)) {
                    isC_TO_F = true;
                }
                else {
                    isC_TO_F = false;
                }
            }
        });



        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               convert();
            }
        });

    }

    private void convert() {

        String input = userInputField.getText();

        float enteredTemperature = 0.0f;
        try {
            enteredTemperature = Float.parseFloat(input);
        } catch (Exception exception) {
            warnUser();
            return;
        }

        float newTemperature = 0.0f;
        if(isC_TO_F) {
            newTemperature = (enteredTemperature * 9/5) + 32;   // If user selected Celsius To Fahrenheit
        }
        else {
            newTemperature = (enteredTemperature - 32) * 5/9;  // If user selected Fahrenheit To Celsius
        }
        display(newTemperature);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid Temperature");
        alert.setContentText("Please Enter Valid Input Temperature");
        alert.show();
    }

    private void display(float newTemperature) {
        String unit = isC_TO_F ? " F" : " C";

        System.out.println("The New temperature Is " + newTemperature + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setHeaderText("Message");
        alert.setContentText("The Converted Temperature Is " + newTemperature + unit);
        alert.show();

    }

}
