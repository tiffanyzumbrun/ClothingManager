package com.clothingmanager.resellclothingmanager2;

public class SystemInfo {

    //Retrieve the Java version that's being used
    public static String javaVersion() {
        return System.getProperty("java.version");
    }

    //Retrieve the JavaFX version being used
    public static String javafxVersion() {
        return System.getProperty("javafx.version");
    }

}