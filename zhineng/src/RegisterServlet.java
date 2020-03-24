package com.zhineng.servlet;

import com.alibaba.fastjson.JSON;
import com.zhineng.bean.ResultInfo;
import com.zhineng.bean.User;
import com.zhineng.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet{


    /**
     * 接收注册数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、接收请求数据： Alt+Enter
        Map<String, String[]> map = request.getParameterMap();
        //封装数据
        User user = new User();
        String registerJson;
        try {
            BeanUtils.populate(user,map);
            //2、处理数据：注册
            UserService userService = new UserService ();
            registerJson = userService.register(user);
        } catch (Exception e) {
            e.printStackTrace();
            //处理异常的结果
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("数据异常，请联系管理员！");
            registerJson = JSON.toJSONString(resultInfo);
        }
        //3、响应数据
        response.getWriter().print(registerJson);
    }
}
