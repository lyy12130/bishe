package com.zhineng.dao;

import com.zhineng.bean.User;
import com.zhineng.utils.C3p0Utils;
import com.zhineng.utils.UuidUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @version V1.0
 * @author: buguniao
 * @date: 2019/7/22 9:31
 * @description: 从数据库中查询数据
 */
public class UserDao {

    static JdbcTemplate jdbcTemplate = new JdbcTemplate(C3p0Utils.getDataSource());

    /**
     * 查询所有数据
     * @return
     */
    public List<User> queryAll() {

        //1、初始化JdbcTemplate模板：创建JdbcTemplate对象
        //2、写sql
        String sql = "SELECT * FROM tuser";
        //3、执行sql，返回值 List-集合
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        return userList;
    }


    /**
     * 添加数据
     * @param user
     * @return
     */
    public int addUser(User user) {

        //写SQL：
        String sql = "INSERT INTO tuser(userName,userSex,userPassword,userBirthday,userEmail,userAddress,userMobile,userStatus) values(?,?,?,?,?,?,?,?)";
        //执行SQL：
        int update = jdbcTemplate.update(sql,

                                        user.getUserName(),
                                        user.getUserSex(),
                                        user.getUserPassword(),
                                        user.getUserBirthday(),
                                        user.getUserEmail(),
                                        user.getUserAddress(),
                                        user.getUserMoblie(),
                                        user.getUserStatus()
                                        );
        return update;
    }

    //根据用户名查询用户信息
    public static User selectByName (String userName) {
        User user = null;
        //try  catch处理异常
        try{
            //定义SQL语句
            String sql = "select * from tuser where userName = ?";
            //执行SQL
            user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),userName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }


    /**
     * 根据username和password查询数据
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password) {
    User use =null;
        try {
        //1、书写sql
        String sql = "SELECT * FROM tuser WHERE userName=? AND userPassword=?";
        //2、执行sql :处理异常  Ctrl+Alt+T
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            return  null;
        }
    }
}

