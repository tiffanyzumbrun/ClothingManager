//Tiffany Zumbrun
//Programming 2
//Semester Project
package com.clothingmanager.resellclothingmanager2;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

//Class responsible for deleting clothing entries UI
public class DeleteClothingEntryUI {
    private Stage stage;
    private Scene scene;
    
    private ListView<String> entryListView;
    private ArrayList<Product> productList;
    
    //Constructor to initialize the UI compenents
    public DeleteClothingEntryUI(Stage primaryStage){
        stage = primaryStage;
        
        //Retrieve the product list
        productList = Inventory.getProducts();
        entryListView = new ListView<>();
        loadEntries();
        
        //Buttons for actions
        Button deleteButton = new Button("Delete Selected Entry");
        deleteButton.setOnAction(e -> deleteSelectedEntry());
        
        Button backToMainMenuButton = new Button("Back to Main Menu");
        backToMainMenuButton.setOnAction(e -> goToMainMenu(primaryStage));
        
        
        //Layout for UI elements
        VBox layout = new VBox(20);
        layout.getChildren().addAll(entryListView, deleteButton, backToMainMenuButton);
        
        scene = new Scene(layout, 300, 400);
        
    }
    
    //Method to delete the selected entry
    private void deleteSelectedEntry(){
        String selectedEntry = entryListView.getSelectionModel().getSelectedItem();
        if (selectedEntry != null){
            int selectedIndex = entryListView.getSelectionModel().getSelectedIndex();
            
            //Remove the entry from the list view
            entryListView.getItems().remove(selectedIndex);
            
            //Remove the entry from the product list
            productList.remove(selectedIndex);
            
            //Save the updated product list
            Inventory.saveProducts(productList);
        }
    }
    
    //Method to display the UI
    public void show(){
       stage.setTitle("Delete Clothing Entry");  
       stage.setScene(scene);
    }
    
    //Method to navigate back to the main menu
    private void goToMainMenu(Stage primaryStage) {
        App mainMenu = new App();
        mainMenu.start(primaryStage);
    }
    
    //Method to load entries into the list view
    private void loadEntries(){
        
        ArrayList<String> productStrings = new ArrayList<>();
        for (Product product : productList) {
            productStrings.add(product.showProduct());
        }
        
        entryListView.setItems(FXCollections.observableArrayList(productStrings));
    }
}
