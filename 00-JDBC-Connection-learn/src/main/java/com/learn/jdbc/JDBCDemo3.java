package com.learn.jdbc;

import com.learn.util.JDBCUtil;

import java.sql.*;

public class JDBCDemo3 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            //生成SQL
            String sql = "SELECT * FROM user WHERE name = ?";
            //构造对象
            preparedStatement = connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,"zhangsan");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                System.out.println("id:"+id+",name:"+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }
    }
}
