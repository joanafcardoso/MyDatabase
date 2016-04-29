package com.joana.mydb.examples;

import com.joana.mydb.setup.DbProperties;

import java.sql.*;

/**
 * Created by Cardoso on 29-Mar-16.
 */
public class LookAtDatabaseMetaData {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());


            DatabaseMetaData meta = connection.getMetaData();

            listDatabaseProperties(meta);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    private static void listDatabaseProperties(DatabaseMetaData meta) throws SQLException {

        System.out.println(meta.getDatabaseProductName());
        System.out.println(meta.getDatabaseProductVersion());
        System.out.println(meta.getURL());
        System.out.println("Type scroll insensitive " + meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
        if (meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
            if (meta.supportsResultSetConcurrency(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)) {
                System.out.println(" and supports CONCUR_UPDATABLE");
            }
        }
        /*
        TYPE_SCROLL_INSENSITIVE A cursor position can be moved in the
        result forward or backward, or positioned to a particular cursor location. Any
        changes made to the underlying data—the database itself—are not reflected
        in the result set. In other words, the result set does not have to "keep state"
        with the database. This type is generally supported by databases.

        */

       /* CONCUR_UPDATABLE A result set can be modified through the
        ResultSet methods while the result set is open.
        System.out.println("Type scrol sensitive " + meta.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));
        */
    }
}