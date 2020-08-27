package com.learn.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String url = null;
    private static String username = null;
    private static String password = null;
    static {
        Properties properties = new Properties();
        try {
            String path = JDBCUtil.class.getClassLoader().getResource("jdbc.properties").getPath();
            properties.load(new FileReader(path));
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }

    public static Connection getConnection(String url,String user,String password) throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection connection) {
        if(connection != null){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
