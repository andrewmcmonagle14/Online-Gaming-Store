/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csci366onlinegamingstore;

/**
 *
 * @author jmcmo
 */
public abstract class Subtypes extends Product {
    
    private String brand;
    private String consolePlatform;
    
    public Subtypes(String productID, Double price, String description, String productName, String brand) {
        super(productID, price, description, productName);
    }
    
    
    public class PC extends Subtypes{
        public PC(String productID, Double price, String description, String productName, String brand) {
        super(productID, price, description, productName, brand);   
    } 
}
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
     public class Console extends Subtypes{
        public Console(String productID, Double price, String description, String productName, String console_platform) {
        super(productID, price, description, productName, console_platform);   
    } 
}
     
     public String getConsolePlatform() {
        return consolePlatform;
    }

    public void setConsolePlatform(String consolePlatform) {
        this.consolePlatform = consolePlatform;
    }
    
}
