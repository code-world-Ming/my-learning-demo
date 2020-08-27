package com.learn.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 第一次创建连接池，测试。
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws Exception{
        //1、创建连接池对象
        DataSource ds = new ComboPooledDataSource();
        //2、获取连接对象
        Connection connection = ds.getConnection();
        System.out.println(connection);
    }
}
