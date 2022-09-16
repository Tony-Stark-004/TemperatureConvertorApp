package com.applicationfirst.temperatureconverterapp;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class TemperatureConvertor extends Application {


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void init() throws Exception {
        System.out.println("INIT");
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("add_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0 , menuBar);

        Scene scene = new Scene(rootNode);

        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Target Convertor Tool");
        primaryStage.show();

    }

    private MenuBar createMenu() {

        // File Menu

    Menu fileMenu = new Menu("File");

    // FileMenu Item
        MenuItem newMenuItem = new MenuItem("New");
        
        newMenuItem.setOnAction(actionEvent -> System.out.println("New MenuItem Clicked"));
        
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");
        
        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        
        

        fileMenu.getItems().addAll(newMenuItem , separatorMenuItem ,  quitMenuItem);


    // AboutMenu

    Menu helpMenu = new Menu("Help");
    MenuItem aboutMenu = new MenuItem("About");

    helpMenu.getItems().addAll(aboutMenu);

    aboutMenu.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
         aboutApp();   
        }
    });

    // MenuBar

    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu , helpMenu);

        return menuBar;
    }

    private void aboutApp() {
        Alert alertDialogue = new Alert(Alert.AlertType.INFORMATION);
        alertDialogue.setTitle("Temperature Convertor");
        alertDialogue.setHeaderText("Leaning JavaFX");
        alertDialogue.setContentText("Use CareFully");

        ButtonType yesButton = new ButtonType("Yes");
        ButtonType noButton = new ButtonType("No");

        alertDialogue.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> clickedButton = alertDialogue.showAndWait();

        if (clickedButton.isPresent() && clickedButton.get() == yesButton) {

            System.out.println("Yes Button is Clicked");
        }
        else {
        System.out.println("No Button is clicked");
        }
    }




    @Override
    public void stop() throws Exception {
        System.out.println("Stop");
        super.stop();
    }
}

