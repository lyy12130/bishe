package com.zhineng.servlet;

import com.alibaba.fastjson.JSON;
import com.zhineng.bean.Category;
import com.zhineng.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@WebServlet( "/categoryQueryServlet")
public class CategoryQueryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.处理业务：查询文章类别数据
        CategoryService categoryService = new CategoryService();
        //查询所有数据    只能放Category对象  泛型
        String categoryListJson = categoryService.queryAll();
        //2.响应数据：json字符串
        response.getWriter().print(categoryListJson);

    }
}
