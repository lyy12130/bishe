package com.zhineng.dao;

import com.zhineng.utils.C3p0Utils;
import org.springframework.jdbc.core.JdbcTemplate;

public class CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(C3p0Utils.getDataSource());

}
