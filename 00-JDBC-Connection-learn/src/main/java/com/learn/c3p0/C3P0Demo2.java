package com.learn.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接池数量校验
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1、获取DataSource
        DataSource ds = new ComboPooledDataSource();
        for (int i = 0; i < 11; i++) {
            Connection connection = ds.getConnection();
            System.out.println(i+":"+connection);
            if(i == 5){
                //归还连接（C3P0对close方法进行增强）close并不是关闭。
                connection.close();
            }
        }

    }
}
