package com.learn.druid;

import com.learn.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用DruidUtil
 */
public class DruidDemo2 {
    public static void main(String[] args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DruidUtils.getConnection();
            String sql = "insert into user(name,balance) values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"wangwu");
            preparedStatement.setInt(2,100);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.close(preparedStatement,connection);
        }

    }
}
