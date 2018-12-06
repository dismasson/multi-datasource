#### 1.新建一个SpringBoot工程并且创建依赖
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
##`DataSourceNodeEnum`
    数据源节点代码枚举  
##`DataSourceContextHolder`
    线程安全的获取数据源节点代码的容器，提供线程安全的设置和获取数据源节点代码  
##`DynamicDataSource`
    继承了`AbstractRoutingDataSource`并重写`determineCurrentLookupKey()`，该方法用来确定一个数据源节点代码  
##`TestDaoImplTest`
    JUnit测试案例
