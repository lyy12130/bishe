package com.zhineng.service;

import com.alibaba.fastjson.JSON;
import com.zhineng.bean.ResultInfo;
import com.zhineng.bean.User;
import com.zhineng.dao.UserDao;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
    public String queryAll(){
        //查询数据，调用dao层查询数据
        List<User> userList = userDao.queryAll();
        //userList ===> JSON String
        String s = JSON.toJSONString(userList);
        return s;
    }

    public String register(User user){
        //处理注册业务  数据存到数据库  调用Dao层存储数据
        //布尔值与String不符
        //数据库不会返回bool值，返回int值0添加0条数据，即添加失败/1 添加成功
        //0：添加了0条数据--添加失败    1：添加成功
        int addFlag =  userDao.addUser(user);

        //封装结果
        ResultInfo resultInfo = new ResultInfo();
        if (addFlag == 0) {
            resultInfo.setFlag(false);
        }else{
            resultInfo.setFlag(true);
        }

        String s = JSON.toJSONString(resultInfo);

        return s;
    }


    /**
     * 登陆方法
     * @param user
     * @return
     */
    public User login(User user) {
        //处理用户登录业务：调用dao层拿用户输入的username，password到数据库中查询数据
        return userDao.findByUsernameAndPassword(user.getUserName(), user.getUserPassword());
    }
}


