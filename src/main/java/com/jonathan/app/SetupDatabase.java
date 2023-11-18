package com.jonathan.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {
    static final String DB_URL = "jdbc:postgresql://localhost/reviews";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    public static void main() {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();){
    

                String sql = "CREATE TABLE user_reviews (id INTEGER not null, name VARCHAR(255))";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");

            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
