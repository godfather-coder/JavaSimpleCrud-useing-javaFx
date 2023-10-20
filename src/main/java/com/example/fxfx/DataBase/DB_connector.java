package com.example.fxfx.DataBase;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_connector {
    private final static String DB_URL = "jdbc:mysql://localhost:3307/pearsons";
    private final static  String USER_NAME = "root";
    private final static  String PASSWORD = "password";

    @Getter
    private static Statement statement;

    static {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}