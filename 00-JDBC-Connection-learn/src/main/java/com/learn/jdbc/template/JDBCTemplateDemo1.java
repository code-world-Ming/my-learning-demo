package com.learn.jdbc.template;

import com.learn.domain.User;
import com.learn.util.DruidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo1 {

    /**
     * 创建JdbcTemplate并传入DataSource
     */
    private static JdbcTemplate jdbcTemplate = null;

    static {
        jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
    }

    /**
     * 修改
     */
    @Test
    public void test1(){
        String sql = "UPDATE user SET balance = ? WHERE name = ?";
        int count = jdbcTemplate.update(sql,1000,"zhangsan");
        System.out.println(count);
    }

    /**
     * 查询一条记录
     */
    @Test
    public void test2(){
        String sql = "SELECT * FROM user WHERE name =?";
        Map<String, Object> resultMap = jdbcTemplate.queryForMap(sql, "lisi");
        System.out.println(resultMap);
    }

    /**
     * 查询多条记录
     * 使用queryForList方法
     */
    @Test
    void test3(){
        String sql = "SELECT * FROM user";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        System.out.println(resultList);
    }

    /**
     * 查询多条记录
     * 使用封装类RowMapper
     */
    @Test
    void test4(){
        String sql = "SELECT * FROM user";
        List<User> query = jdbcTemplate.query(sql, (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setBalance(resultSet.getBigDecimal("balance"));
            return user;
        });
    }

    /**
     * 查询多条记录
     * 使用封装类BeanPropertyRowMapper
     */
    @Test
    void test5(){
        String sql = "SELECT * FROM user";
        List<User> beanPropertyRowMapper = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(beanPropertyRowMapper);
    }

    /**
     * queryForObject的使用
     */
    @Test
    void test6(){
        String sql = "SELECT COUNT(id) FROM user";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }
}
