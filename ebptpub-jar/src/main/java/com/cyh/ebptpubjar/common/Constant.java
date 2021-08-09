package com.cyh.ebptpubjar.common;

import java.io.Serializable;

/**
 * 静态变量类
 */
public class Constant implements Serializable {
    // 错误码
    public static final String ERRCODE = "errCode";
    // 错误信息,对应的信息要为字符串
    public static final String ERRMSG = "errMsg";
    // ebpt请求流水号
    public static final String EDPT_REQSEQNO = "edptReqSeqNo";
    // ebpt业务流水号
    public static final String EDPT_SEQBUS = "edptSeqBus";
}
