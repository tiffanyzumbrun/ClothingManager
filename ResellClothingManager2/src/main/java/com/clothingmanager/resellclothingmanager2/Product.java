//Tiffany Zumbrun
//Programming 2
//Semester Project 
//Original Command Line Code
package com.clothingmanager.resellclothingmanager2;

// Class that represents a clothing product
public class Product {
    // Fields representing the attributes
    String brand;
    String type;
    String color;
    String size;
    
    // Constructor to initialize a product with its attributes
    public Product(String type, String color, String size, String brand){
        super();
        this.type = type;
        this.color = color;
        this.size = size;
        this.brand = brand;
    }
    
    //Getter method for the brand
    public String getBrand(){
        return brand;
    }
    
    //Setter method for the brand
    public void setBrand(String brand){
        this.brand = brand;
    }
    
    //Setter method for the type
    public void setType(String type){
        this.type = type;
    }
    
    //Setter method for the color
    public void setColor(String color){
        this.color = color;
    }
    
    //Setter method for the size
    public void setSize(String size){
        this.size = size;
    }
    //Returns a string representation
    public String showProduct(){
        return size + " " + color + " " + brand + " " + type;
    }
}
