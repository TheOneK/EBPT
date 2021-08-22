package com.cyh.ebptonlinewar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 配置mybatis的接口类放的地方
@MapperScan(basePackages = "cn.witsky.quota.dao.dao1", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class EbptonlineWarApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbptonlineWarApplication.class, args);
    }

}
