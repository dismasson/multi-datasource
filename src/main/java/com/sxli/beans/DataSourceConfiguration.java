package com.sxli.beans;

import com.alibaba.druid.pool.DruidDataSource;
import com.sxli.datasource.DataSourceNodeEnum;
import com.sxli.datasource.DynamicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfiguration {

    /**
     * 创建数据源节点db1
     *
     * @return
     * @throws Exception
     */
    private DataSource db1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(5);
        dataSource.setDbType("mysql");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("db1");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://47.98.116.157:3306/db1");
        return dataSource;
    }

    /**
     * 创建数据源节点db2
     *
     * @return
     * @throws Exception
     */
    private DataSource db2() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(5);
        dataSource.setDbType("mysql");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("db2");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://47.98.116.157:3306/db2");
        return dataSource;
    }

    /**
     * 创建动态数据源节点对象
     *
     * @return
     */
    @Bean
    @Primary
    public DynamicDataSource dynamicDataSource() {
        // 创建储存数据源节点的map
        Map<Object, Object> nodes = new HashMap<>(3, 1);
        nodes.put(DataSourceNodeEnum.DB1, db1());
        nodes.put(DataSourceNodeEnum.DB2, db2());
        // 创建动态数据源对象
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 设置动态数据源的节点
        dynamicDataSource.setTargetDataSources(nodes);
        // 设置动态数据源的默认节点
        dynamicDataSource.setDefaultTargetDataSource(nodes.get(DataSourceNodeEnum.DB1));
        return dynamicDataSource;
    }
}
