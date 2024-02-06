/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csci366onlinegamingstore;
import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author jmcmo
 */
public class Orders {
    private int orderNumber;
    private String orderStatus;
    private int quantity;
    private String shippingAddress;
    private java.sql.Date orderDate;
    private int customerID;
    
    public Orders(int orderNumber, String orderStatus, int quantity, String shippingAddress, 
            java.sql.Date orderDate, int customerID) {
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
        this.shippingAddress= shippingAddress;
        this.orderDate = orderDate;
    }
    
    public int getOrderNumber(){
        return orderNumber;
    }
    
    public void setOrderNumber(int orderNumber){
        this.orderNumber=orderNumber;
    }
    
    public String getOrderStatus(){
        return orderStatus;
    }
    
    public void setOrderStatus(String orderStatus){
        this.orderStatus=orderStatus;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
    public String getShippingAddress(){
        return shippingAddress;
    }
    
    public void setShippingAddress(String shippingAddress){
        this.shippingAddress=shippingAddress;
    }
    
    public java.sql.Date getOrderDate(){
        return orderDate;
    }
    
    public void setOrderDate(java.sql.Date orderDate){
        this.orderDate=orderDate;
    }
    
    public int getCustomerID(){
        return customerID;
    }
    
    public void setCustomerID(int customerID){
        this.customerID=customerID;
    }
    
    
    public static void deleteOrdersForCustomer(Connection conn, String customerName) throws SQLException {
    PreparedStatement stmt = conn.prepareStatement("DELETE FROM orders WHERE customerID = (SELECT customerID FROM customer WHERE LOWER(customer_name) = ?)");
    stmt.setString(1, customerName.toLowerCase());
    int rowsAffected = stmt.executeUpdate();

    if (rowsAffected > 0) {
        System.out.println("Orders for " + customerName + " deleted successfully");
    } else {
        System.out.println("No orders found for " + customerName);
    }
}
    
    public static void searchPastOrdersByProductName(Connection conn, String productName) throws SQLException {
    String sqlQuery2 = "SELECT o.order_number, o.order_date, o.order_status, p.product_name, p.price, po.quantity "
            + "FROM orders o "
            + "JOIN product_order po ON o.order_number = po.order_number "
            + "JOIN product p ON po.productID = p.productID "
            + "WHERE p.product_name = ?";

    PreparedStatement stmt = conn.prepareStatement(sqlQuery2);
    stmt.setString(1, productName);
    ResultSet rs = stmt.executeQuery();

    // process the results
    while (rs.next()) {
        int orderNumber = rs.getInt("order_number");
        LocalDate orderDate = rs.getDate("order_date").toLocalDate();
        String orderStatus = rs.getString("order_status");
        String productNameResult = rs.getString("product_name");
        double productPrice = rs.getDouble("price");
        int quantity = rs.getInt("quantity");
        System.out.println("Order Number: " + orderNumber + "\n"
                + "Order Date: " + orderDate + "\n"
                + "Order Status: " + orderStatus + "\n"
                + "Product Name: " + productNameResult + "\n"
                + "Product Price: $" + productPrice + "\n"
                + "Quantity: " + quantity + "\n");
        }

            rs.close();
            stmt.close();
    }



}

    







    

