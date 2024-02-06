/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csci366onlinegamingstore;

import csci366onlinegamingstore.Subtypes.PC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author jmcmo
 */
public class Product {
    private String productID;
    private double price;
    private String description;
    private String productName;


    // Constructors, getters, and setters
 
    public Product(){}
    
    public Product(String productID, double price, String description, String productName) {
        this.productID = productID;
        this.price = price;
        this.description = description;
        this.productName= productName;
 
             
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public static Product getMostExpensivePC(Connection conn) throws SQLException {
    String sql = "SELECT p.product_name, p.price, p.description, p.productID " +
            "FROM product p " +
            "INNER JOIN pc c ON p.productID = c.productID " +
            "ORDER BY p.price DESC " +
            "LIMIT 1";

    try (Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        if (rs.next()) {
            String productName = rs.getString("product_name");
            double price = rs.getDouble("price");
            String description = rs.getString("description");
            String productID = rs.getString("productID");
            return new Product(productID, price, description, productName);
        } else {
            System.out.println("There are no PC products available.");
            return null;
        }
    }
}
    
    
   public static void addProduct(Connection conn) throws SQLException {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the product ID: ");
    String productId = scanner.nextLine();

    System.out.print("Enter the price: ");
    double price = scanner.nextDouble();

    scanner.nextLine(); // consume the newline character left by nextDouble()

    System.out.print("Enter the description: ");
    String description = scanner.nextLine();

    System.out.print("Enter the product name: ");
    String productName = scanner.nextLine();

    String sqlQuery = "INSERT INTO product (productID, price, description, product_name) VALUES (?, ?, ?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
        stmt.setString(1, productId);
        stmt.setDouble(2, price);
        stmt.setString(3, description);
        stmt.setString(4, productName);

        int rowsInserted = stmt.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("New product inserted successfully");
        } else {
            System.out.println("No product was inserted");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   
   public static void increasePrice(Connection conn) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Increase the price of the product named 'MSI prebuilt gaming PC' by 10% of its original price: ");

        System.out.print("Enter the name of the product: ");
        String productName = scanner.nextLine().toLowerCase();

        System.out.print("Enter the percentage of price increase: ");
        double increasePercentage = scanner.nextDouble();
        scanner.nextLine();

        String Query = "UPDATE product SET price = price * (1 + ? / 100) WHERE lower(product_name) = ?";

        try (PreparedStatement stmt = conn.prepareStatement(Query)) {
            stmt.setDouble(1, increasePercentage);
            stmt.setString(2, productName);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Price of " + productName + " has been updated by " + increasePercentage + "%");
            } else {
                System.out.println("No product found with name " + productName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    
    
    

}
    
 









