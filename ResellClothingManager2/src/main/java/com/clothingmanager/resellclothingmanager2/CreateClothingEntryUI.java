//Tiffany Zumbrun
//Programming 2
//Semester Project
package com.clothingmanager.resellclothingmanager2;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Platform;

//Class responsible for creating UI to add new clothing entries
public class CreateClothingEntryUI {
    private TextField brandField;
    private TextField typeField;
    private TextField colorField;
    private TextField sizeField;
    private Stage stage;
    private Scene scene;
    
    //Constructor to initialize the UI components
    public CreateClothingEntryUI(Stage primaryStage) {
       //Initialize the primary stage
        stage = primaryStage;
        
        //Text fields for user input
        brandField = new TextField();
        brandField.setPromptText("Enter Brand: ");
        
        typeField = new TextField();
        typeField.setPromptText("Enter Type: ");
        
        colorField = new TextField();
        colorField.setPromptText("Enter Color: ");
        
        sizeField = new TextField();
        sizeField.setPromptText("Enter Size: ");
        
        //Buttons for actions
        Button createButton = new Button("Create Clothing Entry");
        createButton.setOnAction( e -> createClothingEntry());
        
        Button backToMainMenuButton = new Button("Back to Main Menu");
        backToMainMenuButton.setOnAction(e -> goToMainMenu(primaryStage));
        
        //Layout for UI elements
        VBox layout = new VBox(20);
        layout.getChildren().addAll(brandField, typeField, colorField, sizeField, createButton, backToMainMenuButton);
        
        //Create the scene for the UI
        scene = new Scene(layout, 300, 400);
        
    }
    
    //Method to navigate back to the main menu
    private void goToMainMenu(Stage primaryStage) {
        App mainMenu = new App();
        mainMenu.start(primaryStage);
    }
    
    //Method to display the UI
    public void show(){
       stage.setTitle("Create Clothing Entry");  
       stage.setScene(scene);
    }
    
    //Method to create a new clothing entry
    private void createClothingEntry(){
        RCM rcmInstance = new RCM();
        
        //Retrieve input values from the text fields
        String brand = brandField.getText();
        String type = typeField.getText();
        String color = colorField.getText();
        String size = sizeField.getText();
        
        //Add clothing entry using RCM instance
        rcmInstance.addClothingEntry(brand, type, color, size);
    }
    
}
