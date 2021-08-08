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

    public EbptException(EbptExceptionCode errorCode, Map<String,Object> context){
        super(errorCode.cnname()+(context.get(Constant.ERRMSG)==null ? "":context.get(Constant.ERRMSG)));
    }

    public EbptExceptionCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(EbptExceptionCode errorCode) {
        this.errorCode = errorCode;
    }
}
