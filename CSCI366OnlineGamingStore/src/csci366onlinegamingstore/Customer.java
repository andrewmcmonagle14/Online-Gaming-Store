package csci366onlinegamingstore;

import static java.lang.System.in;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private int customerID;
    private String customerName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    public Customer(int customerID, String customerName, String email, String phone, String address, String city, String state, String zipCode) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.email = email;
        this.phone= phone;
        this.address=address;
        this.city = city;
        this.state=state;
        this.zipCode=zipCode;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address=address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    @Override
    public String toString() {
    return  "\n    Customer Name = " + getCustomerName() + 
            "\n    Email =" + getEmail() +
            "\n    Phone Number = " + getPhone() + 
            "\n    Customer ID = " + getCustomerID() + 
            "\n    City = " + getCity() + 
            "\n    State = " + getState() + 
            "\n    Zip Code = " + getZipCode() + 
            "\n    Address = " + getAddress() + 
            "\n";
}

    

    public static List<Customer> getCustomersByYear(Connection conn, int year) throws SQLException {
    List<Customer> customers = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    System.out.print("List all customers that have ordered a product in the year: ");
    scanner.nextLine();
    
    
    String sqlQuery = "SELECT DISTINCT c.* FROM customer c " +
            "INNER JOIN orders o ON c.customerID = o.customerID " +
            "WHERE o.order_date BETWEEN ? AND ?";

    try (PreparedStatement stmt = conn.prepareStatement(sqlQuery)) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        stmt.setDate(1, Date.valueOf(startDate));
        stmt.setDate(2, Date.valueOf(endDate));
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Customer customer = new Customer(rs.getInt("customerID"),
                    rs.getString("customer_name"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getString("address"),
                    rs.getString("state"),
                    rs.getString("city"),
                    rs.getString("zip_code")
                    );
            customers.add(customer);
        }
        rs.close();
        stmt.close();

    } catch (SQLException e) {
        throw e;
    }

    return customers;
}

   
    
    

}
