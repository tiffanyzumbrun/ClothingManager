//Tiffany Zumbrun
//Programming 2
//Semester project 
package com.clothingmanager.resellclothingmanager2;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.scene.control.Button;

//Class responsible for displaying a list of all clothing entries UI
public class ListAllClothingEntriesUI {
    private Stage stage;
    private Scene scene;
    
    private ListView<String> entryListView;
    
    //Constructor to initialize the UI components
    public ListAllClothingEntriesUI(Stage primaryStage) {
        stage = primaryStage;
        
        //Create list view and load entries
        entryListView = new ListView<>();
        loadEntries();
        
        //Button to go back to the main menu
        Button backToMainMenuButton = new Button("Back to Main Menu");
        backToMainMenuButton.setOnAction(e -> goToMainMenu(primaryStage));
        
        //Layout for UI elements
        VBox layout = new VBox(20);
        layout.getChildren().addAll(entryListView, backToMainMenuButton);
        
        scene = new Scene(layout, 300, 400);   
    }
    
    //Method to navigate back to the main menu
    private void goToMainMenu(Stage primaryStage) {
        App mainMenu = new App();
        mainMenu.start(primaryStage);
    }
    
    //Methid to display the UI
    public void show(){
       stage.setTitle("All Listings");  
       stage.setScene(scene);
    }
    
    //Methid to load entries into the list view
    private void loadEntries() {
        ArrayList<Product> productList = Inventory.getProducts();
        ArrayList<String> productStrings = new ArrayList<>();
        for (Product product : productList) {
            productStrings.add(product.showProduct());
        }
        
        entryListView.setItems(FXCollections.observableArrayList(productStrings));
    } 
}
