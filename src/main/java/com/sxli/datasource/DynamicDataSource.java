package com.sxli.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 确定当前数据源代号
     *
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        // 从当前线程的ThreadLocal获取数据源代号
        return DataSourceContextHolder.node();
    }
}
