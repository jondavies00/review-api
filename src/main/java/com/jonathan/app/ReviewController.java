package com.jonathan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private String url;

    private Connection conn;




    public ReviewController() {
        final String url = "jdbc:postgresql://localhost:5432/reviews?user=postgres&password=postgres";
        this.url = url;
        try {
            Connection conn = DriverManager.getConnection(url);
            this.conn = conn;
        }
        catch(Exception e) {
            System.out.println(String.format("Could not connect to DB with url %s", this.url));
        }
        
        
    }
    

    @GetMapping("/reviews")
    String all() {
        try {
            Statement statement = this.conn.createStatement();
            String sql = "SELECT * FROM user_reviews;";
            ResultSet results  = statement.executeQuery(sql);
            while (results.next()){
                String first = results.getString(1);
                System.out.println(String.format("Got value %s", first));

            }
            
            
            return "SUCCESS";
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Could not execute query"));
            return "ERROR";
        }
        
    }

    @PostMapping("/reviews")
    void review() {
        try {
            Statement statement = this.conn.createStatement();
            String sql = "INSERT INTO user_reviews (id, name) VALUES (123, 'jon') ";
            statement.executeUpdate(sql);
            System.out.println("Inserted!");
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println(String.format("Could not execute query"));
        }
        
    }

  
    
}

