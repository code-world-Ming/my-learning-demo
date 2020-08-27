package com.learn.jdbc;

import java.sql.*;

public class JDBCDemo1 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        /**
         * 加载该类时会自动调用该类的静态代码块
         * try {
         *     DriverManager.registerDriver(new Driver());
         * } catch (SQLException var1) {
         *     throw new RuntimeException("Can't register driver!");
         * }
         * 注册驱动
         * Class.forName("com.mysql.jdbc.Driver");
         * mysql-connector 5.0以上的版本，可以省略上面的注册驱动代码
         * 因为在META-INF -> service 中自动注册了驱动。
         */



        //2.获取数据库的连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/learn", "root", "zalimi123");
        //关闭自动提交（开启事务）
        connection.setAutoCommit(false);
        //定义sql语句
        String sql = "UPDATE user SET balance = 1000 WHERE name = 'zhangsan'";
        Statement statement = connection.createStatement();
        int count = statement.executeUpdate(sql);
        //提交事务
        connection.commit();
        System.out.println(count);
        statement.close();
        connection.close();
    }
}

