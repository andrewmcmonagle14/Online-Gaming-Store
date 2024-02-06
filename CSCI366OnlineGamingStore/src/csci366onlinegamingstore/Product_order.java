/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csci366onlinegamingstore;

/**
 *
 * @author jmcmo
 */
public class Product_order {
    private int orderNumber;
    private String productID;
    private int quantity;
    
    public Product_order(int orderNumber, String productID, int quantity){
        this.orderNumber=orderNumber;
        this.productID=productID;
        this.quantity=quantity;
    }
    
    public int getOrderNumber(){
        return orderNumber;
    }
    
    public void setOrderNumber(int orderNumber){
        this.orderNumber=orderNumber;
    }
    
    public String getProductID(){
        return productID;
    }
    
    public void setProductID(String productID){
        this.productID=productID;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
    
}
