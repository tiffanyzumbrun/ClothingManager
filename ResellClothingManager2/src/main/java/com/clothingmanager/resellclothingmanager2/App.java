//Tiffany Zumbrun
//Programming 2
//Semester Project

package com.clothingmanager.resellclothingmanager2;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Main class
public class App extends Application {
    
    private VBox mainMenuLayout;//Layout for the menu
    
    //Method called when the application starts
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Clothing Manager");//Set the window title
        
        //Create Main Menu Buttons
        
        Button createEntryButton = new Button("Create Clothing Entry");
        createEntryButton.setOnAction(e ->  new CreateClothingEntryUI(primaryStage).show());
        
        Button updateEntryButton = new Button("Update Clothing Entry");
        updateEntryButton.setOnAction(e -> new UpdateClothingEntryUI(primaryStage).show());
        
        Button deleteEntryButton = new Button("Delete Clothing Entry");
        deleteEntryButton.setOnAction(e -> {
            DeleteClothingEntryUI deleteUI = new DeleteClothingEntryUI(primaryStage);
            deleteUI.show();
        });

        Button listEntriesButton = new Button("List All Clothing Entries");
        listEntriesButton.setOnAction(e -> new ListAllClothingEntriesUI(primaryStage).show());
        
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(e -> Platform.exit());
        
        //Create the main menu layout wuth buttons
        mainMenuLayout = new VBox(20);
        mainMenuLayout.getChildren().addAll(
            createEntryButton, updateEntryButton, deleteEntryButton,
               listEntriesButton, exitButton);
        
        //Create the main menu scene
        Scene mainMenuScene = new Scene(mainMenuLayout, 300, 400);
        
        //Set the scene and display the window
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }
    //Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }

}