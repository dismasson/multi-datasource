package com.sxli.dao;

public interface TestDao {

    /*
     * 统计db1的test表的数据量
     */
    Long countTestByDB1();

    /*
     * 统计db2的test表的数据量
     */
    Long countTestByDB2();
}
