//Tiffany Zumbrun
//Programming 2
//Semester Project 
//Original Command Line Code
package com.clothingmanager.resellclothingmanager2;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class RCM {
    
    // Static fields for managing the list of products and user input
    private static ArrayList<Product> productList = Inventory.getProducts();
    private static Scanner scanner = new Scanner(System.in);
    private static String menuSelected = "";
    
    // Main method for running the CLI
    public static void main(String[] args) {
        
        //Product instance for updates
        ArrayList<Product> productList = Inventory.getProducts();
        Product selectedProduct = new Product("","","","");
        
        menu(); //Display the main menu
        
        while(!menuSelected.equalsIgnoreCase("5")) {
            
            //Create clothing entry
            if(menuSelected.equalsIgnoreCase("1")) {
                System.out.print("Enter brand: ");
                String brand = scanner.nextLine();
                System.out.print("Enter type: ");
                String type = scanner.nextLine();
                System.out.print("Enter color: ");
                String color = scanner.nextLine();
                System.out.print("Enter size: ");
                String size = scanner.nextLine();
                Product product = new Product(type,color,size, brand); 
                productList.add(product); //Add to the product list
                Inventory.saveProducts(productList);               
                System.out.print("\nProduct added: ");
                System.out.println(product.showProduct());
                menu();

            }
            //Update clothing entry
            else if(menuSelected.equalsIgnoreCase("2")) {
                listProducts(productList);
                System.out.print("Enter product number to update: ");
                int selectProduct = scanner.nextInt();
                System.out.println(selectProduct);
                selectedProduct = productList.get(selectProduct -1);
                scanner.nextLine();
                updateMenu(selectedProduct);
                
            }
            //Update the brand
            else if(menuSelected.equalsIgnoreCase("2.1")) {
                System.out.print("Update brand: ");
                selectedProduct.brand = scanner.nextLine();
                updateMenu(selectedProduct);
                
            }
            //Update the type
            else if(menuSelected.equalsIgnoreCase("2.2")) {
                System.out.print("Update type: ");
                selectedProduct.type = scanner.nextLine();
                updateMenu(selectedProduct);
                
            }
            //Update the color
            else if(menuSelected.equalsIgnoreCase("2.3")) {
                System.out.print("Update color: ");
                selectedProduct.color = scanner.nextLine();
                 updateMenu(selectedProduct);
            }
            //Update the size
            else if(menuSelected.equalsIgnoreCase("2.4")) {
                System.out.print("Update size: ");
                selectedProduct.size = scanner.nextLine();
                updateMenu(selectedProduct);                
            }
            // Save the changes
            else if(menuSelected.equalsIgnoreCase("2.5")) {
                Inventory.saveProducts(productList);
                System.out.print("\nProduct updated: ");
                System.out.println(selectedProduct.showProduct());
                menu();               
            }
            //Delete clothing entry
            else if(menuSelected.equalsIgnoreCase("3")) {
                listProducts(productList);
                System.out.print("Enter product number to delete: ");
                int selectProduct = scanner.nextInt();
                productList.remove(selectProduct -1);
                Inventory.saveProducts(productList);
                System.out.println("This entry has been saved.");
                menu();
                
            }
            //List all clothing entries
            else if(menuSelected.equalsIgnoreCase("4")) {
                listProducts(productList);
                menu();
                
            }
            // Exit the application
            else if(menuSelected.equalsIgnoreCase("5")){
                System.exit(0);
            }
            //Handle invalid menu selection
            else {
                System.out.println();
                System.out.println("Invalid entry. Please choose another action...");
                menu();
            }
        
        }
        scanner.close(); //Close the scanner when the program exits
    }

    // Display the main menu options
    private static void menu() {
        System.out.println();
        System.out.println("Resell Clothing Manager");
        System.out.println("---------------------------");
        System.out.println("1: Create Clothing Entry");
        System.out.println("2: Update Clothing Entry");
        System.out.println("3: Delete Clothing Entry");
        System.out.println("4: List All Clothing Entries");
        System.out.println("5: Exit");
 
        System.out.println();
        System.out.print("Choose Action: ");
        menuSelected = scanner.nextLine();
        
    }
    // Display the update menu
    private static void updateMenu(Product selectedProduct) {
        System.out.println();
        System.out.println("1: Brand (" + selectedProduct.brand + ")");
        System.out.println("2: Type (" + selectedProduct.type + ")");
        System.out.println("3: Color (" + selectedProduct.color + ")");
        System.out.println("4: Size (" + selectedProduct.size + ")");
        System.out.println("---------------------------");
        System.out.println("5: Save");

        System.out.println();
        System.out.print("Select Field to Update: ");
        menuSelected = "2." + scanner.nextLine();

    }
    // List all products with their index numbers
    private static void listProducts(ArrayList<Product> productList) {
        System.out.println();
        for (Product product : productList) { 
            System.out.println((productList.indexOf(product)+1) + " - "+product.showProduct());
        }
        System.out.println();
    }
    // Add a new clothing entry
    public static void addClothingEntry(String brand, String type, String color, String size){
        Product product = new Product(type, color, size, brand);
        productList.add(product);
        Inventory.saveProducts(productList);
        System.out.println("Product added: " + product.showProduct());
        
        displayNotification("Product added", "New clothing entry has been added.");
    }
    //Display a notification
    private static void displayNotification(String title, String content){
        Alert alert = new Alert(AlertType. INFORMATION,content);
        alert.show();
    }
    //Get the current list of products
    public static ArrayList<Product> getProductList() {
        return productList;
    }
    
}
