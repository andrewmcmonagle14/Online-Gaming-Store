/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csci366onlinegamingstore;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmcmo
 */
public class Review {
    private int reviewID;
    private int rating;
    private String comment;
    private String productID;
    
    public Review(int reviewID, int rating, String comment, String productID) {
        this.reviewID = reviewID;
        this.rating = rating;
        this.comment = comment;
        this.productID= productID;
        
    }
    
    public int getReviewID(){
        return reviewID;
    }
    
    public void setReviewID(int reviewID){
        this.reviewID=reviewID;
    }
    
    public int getRating(){
        return rating;
    }
    
    public void setRating(int rating){
        this.rating=rating;
    }
    
    public String getComment(){
        return comment;
    }
    
    public void setComment(String comment){
        this.comment=comment;
    }
    
    public String getProductID(){
        return productID;
    }
    
    public void setProductID(String productID){
        this.productID=productID;
    }
    

    
public static void searchReviewsByRating(Connection conn, int rating) throws SQLException {
    String sqlQuery = "SELECT * FROM review WHERE rating > ?";
    PreparedStatement stmt = conn.prepareStatement(sqlQuery);
    stmt.setInt(1, rating);
    ResultSet rs = stmt.executeQuery();

    // process the results
    while (rs.next()) {
        String reviewID = rs.getString("reviewID");
        int reviewRating = rs.getInt("rating");
        String comment = rs.getString("comment");
        String productID = rs.getString("productID");
        System.out.println("Review ID: " + reviewID + "\n"
                + "Rating: " + reviewRating + "\n"
                + "Comment: " + comment + "\n"
                + "Product ID: " + productID + "\n");
    }

    rs.close();
    stmt.close();
    }
}

    
    

