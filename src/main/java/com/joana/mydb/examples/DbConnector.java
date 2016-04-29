package com.joana.mydb.examples;

import com.joana.mydb.setup.DbProperties;

import java.sql.*;

/**
 * Created by Cardoso on 19-Mar-16.
 */
public class DbConnector {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Class.forName(DbProperties.getDriver()); // not required for jdbc
            connection = DriverManager.getConnection(DbProperties.getUrl(),DbProperties.getUser(),DbProperties.getPassword());
            // "jdbc:postgresql://localhost/ivik", "postgres", "joana")

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from company");
            //ResultSet resultSet = statement.executeQuery("Select * from company where name = 'bbc ltd'");
            while (resultSet.next()) {//returns a boolean, if there is a row, it prints it, otherwise it stops
                // note column indexes start with 1 !
                System.out.println(resultSet.getInt(1) + ":" +resultSet.getString(2));//get column 1 (id) and 2 (name)
                // can also get values using column name
                // System.out.println(resultSet.getString("name"));
            }
            resultSet.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}