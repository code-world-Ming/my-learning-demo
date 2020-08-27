package com.learn.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 第一次使用Druid连接池。
 */
public class DruidDemo1 {
    public static void main(String[] args) throws Exception{
        //加载配置文件
        Properties properties = new Properties();
        InputStream inputStream = DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(inputStream);
        //创建数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
