package com.cyh.ebptonlinewar;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan(basePackages = "cn.witsky.quota.dao.dao1", sqlSessionFactoryRef = "test1SqlSessionFactory")
class EbptonlineWarApplicationTests {

    @Test
    void contextLoads() {
    }

}
