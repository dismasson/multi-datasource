package com.sxli.dao.impl;

import com.sxli.annotation.DataSource;
import com.sxli.dao.TestDao;
import com.sxli.datasource.DataSourceContextHolder;
import com.sxli.datasource.DataSourceNodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long countTestByDB1() {
        return jdbcTemplate.queryForObject("select count(1) from test", Long.class);
    }

    @Override
    @DataSource(DataSourceNodeEnum.DB2) // 指定使用db2
    public Long countTestByDB2() {
        /* 指定使用DB2数据源节点
        DataSourceContextHolder.set(DataSourceNodeEnum.DB2);*/
        return jdbcTemplate.queryForObject("select count(1) from test", Long.class);
    }
}
