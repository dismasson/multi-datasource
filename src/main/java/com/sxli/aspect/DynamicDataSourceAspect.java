package com.sxli.aspect;

import com.sxli.annotation.DataSource;
import com.sxli.datasource.DataSourceContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 动态数据源切面处理
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    /**
     * 定义凡是使用此注解的方法就是切点
     */
    @Before("@annotation(dataSource)")
    public void selectDataSource(DataSource dataSource) {
        // 指定数据源节点代码
        DataSourceContextHolder.set(dataSource.value());
    }

}
