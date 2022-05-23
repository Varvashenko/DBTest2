package com.dbtest2.database;

import java.sql.*;

public class DBTest2 {

    static final String _URL = "jdbc:mysql://localhost:3306/mydbtest";
    static final String _USERNAME = "root";
    static final String _USERPASS = "anta";

    public static void main(String[] args) {

        System.out.println("DB.Start");

        // connection
        try (Connection connection = DriverManager.getConnection(_URL, _USERNAME, _USERPASS)) {
            if(connection.isClosed()) System.out.println("DB.Close");

            // get statement for Query
            Statement statement = connection.createStatement();
            String selectUsers = "SELECT COUNT(*) FROM mydbtest.users;";
            ResultSet resultSet = statement.executeQuery(selectUsers);
            if(resultSet.next()) {
                int i = resultSet.getInt(1);
                System.out.println("Count of users : " + i);
            }

        } catch (SQLException ex) {
            System.out.println("DB.SQL_Error : " + ex.getMessage() );
        }

        System.out.println("DB.Finish");
    }
}
