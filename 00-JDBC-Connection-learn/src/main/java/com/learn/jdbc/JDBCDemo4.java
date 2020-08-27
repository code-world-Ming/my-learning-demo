package com.learn.jdbc;

import com.learn.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo4 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);
            //定义SQL
            String sql = "update user set balance = ? WHERE name = ?";
            //构造对象
            preparedStatement1 = connection.prepareStatement(sql);
            //设置参数
            preparedStatement1.setInt(1,500);
            preparedStatement1.setString(2,"zhangsan");
            preparedStatement1.executeUpdate();
            //构造对象
            int i= 1/0;
            preparedStatement2 = connection.prepareStatement(sql);
            //设置参数
            preparedStatement2.setInt(1,500);
            preparedStatement2.setString(2,"lisi");
            preparedStatement2.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            JDBCUtil.rollback(connection);
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement1,connection);
            JDBCUtil.close(null,preparedStatement2,null);
        }
    }
}
