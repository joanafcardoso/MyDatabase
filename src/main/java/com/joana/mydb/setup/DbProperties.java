package com.joana.mydb.setup;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Cardoso on 29-Mar-16.
 */
public class DbProperties {
    private static final String CONNECTION_URL = "jdbc.url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String JDBC_DRIVER = "jdbc.driver";

    private DbProperties (){};

    private static Properties dbProperties = new Properties();

    static {
        ClassLoader classLoader = DbProperties.class.getClassLoader();
        try {
            dbProperties.load(classLoader.getResourceAsStream("database.properties"));
        } catch (IOException e) {
            System.exit(12);
        }
    }

    public static String getUrl(){
        return dbProperties.getProperty(CONNECTION_URL);
    }
    public static String getPassword(){
        return dbProperties.getProperty(PASSWORD);
    }
    public static String getUser(){
        return dbProperties.getProperty(USERNAME);
    }
    public static String getDriver(){
        return dbProperties.getProperty(JDBC_DRIVER);
    }
}
