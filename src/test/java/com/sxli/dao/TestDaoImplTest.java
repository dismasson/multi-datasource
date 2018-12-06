package com.sxli.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 动态数据源测试
 *
 * {@link com.sxli.dao.impl.TestDaoImpl}
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class TestDaoImplTest {

    @Autowired
    private TestDao testDao;

    @Test
    public void testDynamicDataSource() {
        System.out.println("db1中test的数据量:" + testDao.countTestByDB1());
        System.out.println("db2中test的数据量:" + testDao.countTestByDB2());
    }
}
