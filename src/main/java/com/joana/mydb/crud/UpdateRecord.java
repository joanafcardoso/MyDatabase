package com.joana.mydb.crud;

import com.joana.mydb.setup.DbProperties;

import java.sql.*;

/**
 * Created by Cardoso on 06-Apr-16.
 */
public class UpdateRecord {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            String sql = "UPDATE Company SET postcode=?, start_date=? WHERE name=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "3412AB");
            statement.setTimestamp(2,Timestamp.valueOf("2012-03-15 00:00:00"));
            statement.setString(3, "Sportzone");
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Record successfully updated.");
            }

            //or
            //Statement statement = connection.createStatement();
            //int noUpdated = statement.executeUpdate("UPDATE company set postcode = '3412AB' where name like 'Sp%' ");
            //System.out.println("No updates: " + noUpdated);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
