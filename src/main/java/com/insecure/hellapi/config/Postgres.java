package com.insecure.hellapi.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Postgres {

    public static Connection connection() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/postgres";
            return DriverManager.getConnection(url, "postgres", "admin");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(1);
        }
        return null;
    }



}
