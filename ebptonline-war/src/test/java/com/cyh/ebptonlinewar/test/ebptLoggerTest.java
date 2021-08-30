package com.cyh.ebptonlinewar.test;


import com.cyh.ebptpubjar.common.Constant;
import com.cyh.ebptpubjar.ebptLogger.EbptLogger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;
// 获取启动类，加载配置，确定装载 Spring 程序的装载方法，它回去寻找 主配置启动类（被 @SpringBootApplication 注解的）
@SpringBootTest
public class ebptLoggerTest {

    @Test
    @DisplayName("Test method2 with condition")
    public void testLogger() {
        MDC.clear();
        Thread.currentThread().setName("abcdefg");
        MDC.put("SERVER_NAME","abcdefg");
        System.out.println( "----------"+Thread.currentThread().getName());
        // 初始化上下文
        Map<String, Object> context = new HashMap<>();
        context.put(Constant.EDPT_REQSEQNO, "bbbbb");
        context.put(Constant.EDPT_SEQBUS, "cccc");
        EbptLogger.info(EbptLogger.class, context, "xxxxxx:[{}]", "aaaaa");
        EbptLogger.trace(EbptLogger.class, context, "xxxxxx:[{}]", "aaaaa");
    }
}
