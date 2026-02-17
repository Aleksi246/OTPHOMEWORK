package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MariaDBExample {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/testdb"; // your DB name
        String user = "testuser";
        String password = "testpass";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected to MariaDB!");

            // Create a table (if it doesn't exist)
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employees (id INT PRIMARY KEY, name VARCHAR(50))");

            // Insert sample data
            stmt.executeUpdate("INSERT INTO employees (id, name) VALUES (1, 'Alice')");

            // Query the table
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}