package com.cyh.ebptpubjar.ebptLogger;

import com.cyh.ebptpubjar.common.Constant;
import com.cyh.ebptpubjar.utils.ServerInfoApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.Map;

/**
 * 自定义日志记录器
 *
 */
// TODO 找不到更好的方法前，暂时先这么用吧，其实有更好的方法。。。。，先做下测试，看看效果
public class EbptLogger {
    // 服务器名称
    public static final String SERVER_NAME = ServerInfoApi.SERVER_NAME;


    /**
     * 初始化LogBack的MDC参数
     * @param context 数据总线
     */
    private static void initMDC(Map<String,Object> context){
        if(context == null){
            MDC.clear();
            MDC.put("SERVER_NAME",SERVER_NAME);
        }else {
            MDC.put("SERVER_NAME",SERVER_NAME);
            MDC.put(Constant.EDPT_REQSEQNO, (String) context.get(Constant.EDPT_REQSEQNO));
            MDC.put(Constant.EDPT_SEQBUS, (String) context.get(Constant.EDPT_SEQBUS));
        }
    }
    /**
     * 记录info级别日志
     * @param classType 类型
     * @param context 数据总线
     * @param message 日志
     * @param params 日志参数
     */
    public static void info(Class<?> classType,Map<String,Object> context,String message,Object... params){
        Logger logger = LoggerFactory.getLogger(classType);
        if(logger.isInfoEnabled()){
            initMDC(context);
            logger.info(message,params);
            MDC.clear();
            MDC.put("SERVER_NAME",SERVER_NAME);
        }
    }

    /**
     * 记录trace级别日志
     * @param classType 类型
     * @param context 数据总线
     * @param message 日志
     * @param params 日志参数
     */
    public static void trace(Class<?> classType,Map<String,Object> context,String message,Object... params){
        Logger logger = LoggerFactory.getLogger(classType);
        if(logger.isInfoEnabled()){
            initMDC(context);
            logger.trace(message,params);
            MDC.clear();
            MDC.put("SERVER_NAME",SERVER_NAME);
        }
    }

    /**
     * 记录error级别日志
     * @param classType 类型
     * @param context 数据总线
     * @param message 日志
     * @param params 日志参数
     */
    public static void error(Class<?> classType,Map<String,Object> context,String message,Object... params){
        Logger logger = LoggerFactory.getLogger(classType);
        if(logger.isInfoEnabled()){
            initMDC(context);
            logger.error(message,params);
            MDC.clear();
            MDC.put("SERVER_NAME",SERVER_NAME);
        }
    }

    /**
     * 记录info级别日志
     * @param classType 类型
     * @param message 日志
     * @param params 日志参数
     */
    public static void info(Class<?> classType,String message,Object... params){
        Logger logger = LoggerFactory.getLogger(classType);
        if(logger.isInfoEnabled()){
            initMDC(null);
            logger.info(message,params);
        }
    }

    /**
     * 记录trace级别日志
     * @param classType 类型
     * @param message 日志
     * @param params 日志参数
     */
    public static void trace(Class<?> classType,String message,Object... params){
        Logger logger = LoggerFactory.getLogger(classType);
        if(logger.isInfoEnabled()){
            initMDC(null);
            logger.trace(message,params);
        }
    }

    /**
     * 记录error级别日志
     * @param classType 类型
     * @param message 日志
     * @param params 日志参数
     */
    public static void error(Class<?> classType,String message,Object... params){
        Logger logger = LoggerFactory.getLogger(classType);
        if(logger.isInfoEnabled()){
            initMDC(null);
            logger.error(message,params);
        }
    }

//    /**
//     * 用于单点测试
//     * @param args
//     */
//    public static void main(String[]  args){
//        Map<String,Object> context = new HashMap<>();
//        context.put(Constant.EDPT_REQSEQNO,"bbbbb");
//        context.put(Constant.EDPT_SEQBUS,"cccc");
//        EbptLogger.info(EbptLogger.class,context,"xxxxxx:[{}]","aaaaa");
//    }
}
