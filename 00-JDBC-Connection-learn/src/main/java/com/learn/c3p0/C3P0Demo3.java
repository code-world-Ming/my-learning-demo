package com.learn.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 多数据源学习
 */
public class C3P0Demo3 {
    public static void main(String[] args) throws SQLException {
        DataSource ds1 = new ComboPooledDataSource("other1-C3P0");
        Connection connection1 = ds1.getConnection();
        System.out.println(connection1);
        DataSource ds2 = new ComboPooledDataSource("other2-C3P0");
        Connection connection2 = ds2.getConnection();
        System.out.println(connection2);
    }
}
