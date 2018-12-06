package com.sxli.datasource;

/**
 * 给当前线程指定数据源代号或者获取数据源代号
 */
public class DataSourceContextHolder {

    private static ThreadLocal<DataSourceNodeEnum> DATASOURCE_NODES = new ThreadLocal<DataSourceNodeEnum>();

    /**
     * 给当前线程指定数据源代号
     *
     * @param node
     */
    public static void set(DataSourceNodeEnum node) {
        DATASOURCE_NODES.set(node);
    }

    /**
     * 获取当前线程的数据源代号
     *
     * @return
     */
    public static DataSourceNodeEnum node() {
        DataSourceNodeEnum nodeEnum;
        try {
            nodeEnum = DATASOURCE_NODES.get();
        } finally {
            DATASOURCE_NODES.remove();
        }
        return nodeEnum;
    }
}
