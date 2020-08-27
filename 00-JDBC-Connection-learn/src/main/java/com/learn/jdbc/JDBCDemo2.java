package com.learn.jdbc;

import com.learn.util.JDBCUtil;

import java.sql.*;

public class JDBCDemo2 {
    /**
     * 查询
     * @param args
     */
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn", "root", "zalimi123");
            String sql = "SELECT * FROM user";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //游标下移
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                System.out.println("id:"+id+",name:"+name);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,statement,connection);
        }
    }
}
