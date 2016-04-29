package com.joana.mydb.crud;

import com.joana.mydb.setup.DbProperties;

import java.sql.*;

/**
 * Created by Cardoso on 28-Apr-16.
 */
public class AddEmployeeForCompany {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            int companyId =  getCompanyId(connection,"Sportzone");

            addPerson(connection,companyId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addPerson(Connection connection, int companyId) throws SQLException {

        String sql = "INSERT INTO Employee (firstname,lastname,salary,company_id)" +
                " VALUES(?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"Peter");
        ps.setString(2,"Smith");
        ps.setDouble(3,45000.50);
        ps.setDouble(4,companyId);

        int noAdded = ps.executeUpdate();
        System.out.println("No Added: " + noAdded);

        // now run ...
        // select * from company c left join employee e on e.company_id = c.id
    }

    private static int getCompanyId(Connection connection,String name) throws SQLException {

        String select = "SELECT id FROM company WHERE name = ?";

        PreparedStatement ps = connection.prepareStatement(select);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return 0;
    }
}
