package com.jonathan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
    static final String DB_URL = "jdbc:postgresql://localhost/";
    static final String USER = "postgres";
    static final String PASS = "postgres";


    public static void main() {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();){
                String sql = "CREATE DATABASE user_reviews";
                stmt.executeUpdate(sql);

                sql = "CREATE TABLE reviews.user_reviews";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}