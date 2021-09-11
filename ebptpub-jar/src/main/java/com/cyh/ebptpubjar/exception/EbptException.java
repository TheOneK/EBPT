package com.cyh.ebptpubjar.exception;

import com.cyh.ebptpubjar.common.Constant;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 系统自定义错误类
 */
public class EbptException extends Exception{
    /**
     * 错误码
     */
    private EbptExceptionCode errorCode;


    public EbptException(){
        super();
    }

    public EbptException(EbptExceptionCode errorCode){
        super(errorCode.cnname());
        this.errorCode = errorCode;
    }

    /**
     * 将错误码装入数据总线
     * @param errorCode 错误码
     * @param context 数据总线
     */
    public EbptException(EbptExceptionCode errorCode, Map<String,Object> context){
        super(errorCode.cnname()+(context.get(Constant.ERRMSG)==null ? "":context.get(Constant.ERRMSG)));
        this.errorCode = errorCode;
        context.put(Constant.ERRCODE,errorCode);
    }

    /**
     * 将详细的报错信息显示出来
     * @param errorCode 错误码
     * @param context 数据总线
     * @param cause 报错信息
     */
    public EbptException(EbptExceptionCode errorCode, Map<String,Object> context,Throwable cause){
        super(errorCode.cnname()+(context.get(Constant.ERRMSG)==null ? ":":context.get(Constant.ERRMSG)),cause);
        this.errorCode = errorCode;
        context.put(Constant.ERRCODE,errorCode);
    }

    /**
     * 抛出详细异常
     * @param errorCode 错误码
     * @param cause 错误原因
     */
    public EbptException(EbptExceptionCode errorCode, Throwable cause){
        super(errorCode.cnname(),cause);
        this.errorCode = errorCode;
    }

    /**
     * 补充错误描述，不装入数据总线
     * @param errorCode 错误码
     * @param msg 错误原因
     */
    public EbptException(EbptExceptionCode errorCode, String msg){
        super(errorCode.cnname()+":"+(StringUtils.isNotBlank(msg) ? msg:""));
        this.errorCode = errorCode;
    }

    public EbptExceptionCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(EbptExceptionCode errorCode) {
        this.errorCode = errorCode;
    }
}
