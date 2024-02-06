package csci366onlinegamingstore;

import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class CSCI366OnlineGamingStore {
  public static void main(String[] args) {
        Dao dao = new Dao();
        Connection conn = Dao.getConnection();

	//read operation 1 - List all pc products whose price is lower than $1000
        
        String sql = "SELECT p.productID, p.price, p.description, p.product_name, pc.brand " +
             "FROM product p " +
             "INNER JOIN pc pc ON p.productID = pc.productID " +
             "WHERE p.price < ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("List all pc products whose price is lower than: ");
            double maxPrice = scanner.nextDouble();

            pstmt.setDouble(1, maxPrice);
            ResultSet rs = pstmt.executeQuery();

            // print results
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getString("productID"));
                System.out.println("Price: " + rs.getBigDecimal("price"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Product Name: " + rs.getString("product_name"));
                System.out.println("Brand: " + rs.getString("brand"));
                System.out.println();
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    
   
     
	//read operation 2 - List all customers that have ordered a product in the year 2020
        try {
            List<Customer> customers = Customer.getCustomersByYear(conn, 2020);
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


           

	
	//read operation 3 - Show the most expensive PC product available at the store
	
        try {
            Product mostExpensivePC = Product.getMostExpensivePC(conn);
            if (mostExpensivePC != null) {
                System.out.println("The most expensive PC product available is:");
                System.out.println("Product Name: " + mostExpensivePC.getProductName());
                System.out.println("Price: $" + mostExpensivePC.getPrice());
                System.out.println("Description: " + mostExpensivePC.getDescription());
                System.out.println("Product ID: " + mostExpensivePC.getProductID());


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        
        //write operation 1 - Add a new gaming headset and name it Razor Headset and set the price to 200
        try {
            Product.addProduct(conn);

        } catch(SQLException e){
            e.printStackTrace();
        }
        

        
      

        //write operation 2 - Increase the price of the product named “MSI prebuilt gaming PC” by 10% of its original price
        try {
            Product.increasePrice(conn);
        } catch(Exception e){
            e.printStackTrace();
        }


        
 

        //write operation 3
        // Delete order for customer named "Jake Luck"
       try {
            System.out.println("Enter customer name: ");
            Scanner scanner = new Scanner(System.in);
            String customerName = scanner.nextLine();
            Orders.deleteOrdersForCustomer(conn, customerName);
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
         
        //c. Search for past orders for the product named "PS5 Deluxe"
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Search for past orders with the product name of PS5 Deluxe: ");
            String productName = scanner.nextLine();
            Orders.searchPastOrdersByProductName(conn, productName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //Search for reviews with rating greater than 90
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter minimum rating to search for: ");
            int rating = scanner.nextInt();
            Review.searchReviewsByRating(conn, rating);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        }

    }


  



    



