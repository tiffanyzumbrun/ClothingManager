//Tiffany Zumbrun
//Programming 2
//Semester Project 
//Original Command Line Code
package com.clothingmanager.resellclothingmanager2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

// This class is responsible for managing inventory by reading from and writing to a file
public class Inventory {
    
    static String filename = "inventory.txt"; // File name for the inventory
    // Retrieves the list of products from the inventory file
    public static ArrayList<Product> getProducts() {
        ArrayList<Product> al = new ArrayList<>();
        
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = in.readLine();
            while(line != null) {
                // Split each line into fields and create a Product object
                String[] fields = line.split("\t");
                String brand = fields[0];
                String type = fields[1];
                String color = fields[2];
                String size = fields[3];
                
                al.add(new Product(type, color, size, brand));
                line = in.readLine();
                
            }
            in.close();
        }catch (FileNotFoundException e) {
            // If the file is not found, create a new file
           createFile(); 
        }catch (IOException ex) {
 
        }
        return al;
    }
    // Method that creates a new inventory file if it does not exist
    public static void createFile() {
        
        try { 
            File file = new File(filename);
            if(file.createNewFile()){
                System.out.println(filename + " File Created in Project root directory");
                
                
                
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
           
        }
        
    }
    // Method to save the list of products to the inventory file
    public static boolean saveProducts(ArrayList<Product> conversions) {
        try {
            PrintWriter out = new PrintWriter( new BufferedWriter(new FileWriter(filename)));
            for(Product c: conversions){
                // Write each products details to the file
                out.print(c.brand + "\t");
                out.print(c.type + "\t");
                out.print(c.color + "\t");
                out.println(c.size + "\t");
            }    
            
            out.close();
            return true;  
        
        }catch (IOException e) {
            System.out.println(e);
            return false;
            
        }
  
    }
}
