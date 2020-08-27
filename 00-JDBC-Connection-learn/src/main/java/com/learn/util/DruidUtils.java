package com.learn.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.learn.druid.DruidDemo1;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds = null;
    static {
        Properties properties = new Properties();
        try {
            properties.load(DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     * @param connection
     */
    public static void close(Statement statement,Connection connection){
        try {
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet,Statement statement, Connection connection){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
