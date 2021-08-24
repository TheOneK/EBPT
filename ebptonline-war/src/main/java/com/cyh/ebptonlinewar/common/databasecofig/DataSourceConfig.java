package com.cyh.ebptonlinewar.common.databasecofig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//表示这个类为一个配置类
@Configuration
// 配置mybatis的接口类放的地方
@MapperScan(basePackages = "cn.witsky.quota.dao.dao1", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSourceConfig {

    @Value("")
//    @Bean("dynamicDataSource")
//    public DataSource dynamicDataSource() {
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        Map<Object, Object> dataSourceMap = new HashMap<>(2);
//        dataSourceMap.put("master", master());
//        dataSourceMap.put("slave", slave());
//        // 将 master 数据源作为默认指定的数据源
//        dynamicDataSource.setDefaultDataSource(master());
//        // 将 master 和 slave 数据源作为指定的数据源
//        dynamicDataSource.setDataSources(dataSourceMap);
//        return dynamicDataSource;
//    }


//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
//        return new DataSourceTransactionManager(dynamicDataSource());
//    }


    // ---------------------------------------------------------

    // 将这个对象放入Spring容器中
    @Bean(name = "dataSource1")
    // 表示这个数据源是默认数据源
    @Primary
    // 读取application.properties中的配置参数映射成为一个对象
    // prefix表示参数的前缀
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "dataSourceTransactionManager1")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource1")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sessionFactory(@Qualifier("dataSource1")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean.getObject();
    }

    @Bean("sqlSessionTemplate1")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
