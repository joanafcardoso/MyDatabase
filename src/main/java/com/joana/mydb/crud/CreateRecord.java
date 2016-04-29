package com.joana.mydb.crud;

import com.joana.mydb.datasource.ConnectionFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by Cardoso on 05-Apr-16.
 */
public class CreateRecord {
    public static void main(String[] args) throws InterruptedException {
        Connection connection = null;
        try {
            DataSource ds = ConnectionFactory.getDataSource();
            ConnectionFactory.displayDataSource();
            connection = ds.getConnection();
            Thread.sleep(10000);

            //PreparedStatement statement = connection.prepareStatement("INSERT INTO company ( name, postcode, " +
              //      "start_date ) values ( 'AH','1234AB','01-01-2004' )");
            //int rowsInserted = statement.executeUpdate();
            //or

            String sql = "INSERT INTO company (name,postcode,start_date) VALUES(?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,"AH");
            ps.setString(2,"1234AB");
            ps.setTimestamp(3, Timestamp.valueOf("2004-01-01 00:00:00"));

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
