package com.cyh.ebptpubjar.utils;

import java.net.InetAddress;
import java.util.UUID;

/**
 *生成32位的UUID
 */
public class UUID32 {
    public static String newGUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
