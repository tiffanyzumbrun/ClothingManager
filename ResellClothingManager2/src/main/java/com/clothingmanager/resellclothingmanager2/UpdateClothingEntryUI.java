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
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;


import java.util.ArrayList;

//Class responsible for updating clothing entries UI
public class UpdateClothingEntryUI{
    private Stage stage;
    private Scene scene;
    private ListView<String> entryListView;
    private ArrayList<Product> productList;
    
    //Constructor to initialize the UI components
    public UpdateClothingEntryUI(Stage primaryStage){
        stage = primaryStage;
        productList = Inventory.getProducts();

        entryListView = new ListView<>();
        loadEntries();
        
        //Buttons for actions
        Button updateButton = new Button("Update Selected Entry");
        updateButton.setOnAction(e -> openUpdateDialog());
        
        Button backToMainMenuButton = new Button("Back to Main Menu");
        backToMainMenuButton.setOnAction(e -> goToMainMenu(primaryStage));
        
        //Layout for UI elements
        VBox layout = new VBox(20);
        layout.getChildren().addAll(entryListView, updateButton, backToMainMenuButton);
        
        scene = new Scene(layout, 300, 400);
        
    }
    
    //Method to open the update dialog
    private void openUpdateDialog(){
        stage.setTitle("Update Product");
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        int selectedIndex = entryListView.getSelectionModel().getSelectedIndex();
        Product selectedProduct = productList.get(selectedIndex);
        
        //Text fields for editing product details
        TextField brandField = new TextField(selectedProduct.brand);
        TextField typeField = new TextField(selectedProduct.type);
        TextField colorField = new TextField(selectedProduct.color);
        TextField sizeField = new TextField(selectedProduct.size);
        
        //Adding labels and fields to the grid pane
        gridPane.addRow(0, new Label("Brand:"), brandField);
        gridPane.addRow(1, new Label("Type:"), typeField);
        gridPane.addRow(2, new Label("Color:"), colorField);
        gridPane.addRow(3, new Label("Size:"), sizeField);
        
        //Button for updating or canceling changes
        Button confirmUpdateButton = new Button("Update");
        confirmUpdateButton.setOnAction(e -> {
            //Update product details
           String brand = brandField.getText();
           String type = typeField.getText();
           String color = colorField.getText();
           String size = sizeField.getText();
           
           if (entryListView.getSelectionModel().getSelectedItem() != null) {
               
               selectedProduct.setBrand(brand);
               selectedProduct.setType(type);
               selectedProduct.setColor(color);
               selectedProduct.setSize(size);
               
               Inventory.saveProducts(productList);
               entryListView.getItems().set(selectedIndex, selectedProduct.showProduct());
           }
           
           stage.setScene(scene);
        });
        
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            stage.setScene(scene);
            stage.show();
                });
        
        gridPane.addRow(4, cancelButton, confirmUpdateButton);
        
        //Scene for the dialog
        Scene dialogScene = new Scene(gridPane, 300, 200); 
        stage.setScene(dialogScene);
        stage.show();
    }
    
    //Method to display the UI
    public void show(){
       stage.setTitle("Update Clothing Entry");  
       stage.setScene(scene);
       
       stage.show();
     
    }
    
    //Method to load entries into the list view
    private void loadEntries(){
        ArrayList<Product> productList = Inventory.getProducts();
        ArrayList<String> productStrings = new ArrayList<>();
        for (Product product : productList) {
            productStrings.add(product.showProduct());
        }
        
        entryListView.setItems(FXCollections.observableArrayList(productStrings));
        
    }
    
    //Method to navigate back to the main menu
    private void goToMainMenu(Stage primaryStage){
        App mainMenu = new App();
        mainMenu.start(primaryStage);
    }
    
}
