package com.cyh.ebptpubjar.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.Properties;

/**
 *服务器信息类
 */
public class ServerInfoApi {
    // 服务器名称
    public static String SERVER_NAME = getServerName();

    /**
     * 获取服务器名称
     * @return hostName
     */
    private static String getServerName(){
        // TODO 增加日志打印
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        }catch (Exception e){
            e.printStackTrace();
        }
        return hostName;
    }
}
