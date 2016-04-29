package com.joana.mydb.crud;

import com.joana.mydb.setup.DbProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Cardoso on 06-Apr-16.
 */
public class DeleteRecord {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            Statement statement = connection.createStatement();
            int noDeleted = statement.executeUpdate("DELETE FROM company WHERE name = 'AH' ");
            if (noDeleted == 1) {
                System.out.println("Deleted successfully");
            }
            else {
                System.out.println("Not in list");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
