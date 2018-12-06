package com.sxli.annotation;

import com.sxli.datasource.DataSourceNodeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    // 数据源节点默认使用db1
    DataSourceNodeEnum value() default DataSourceNodeEnum.DB1;

}
