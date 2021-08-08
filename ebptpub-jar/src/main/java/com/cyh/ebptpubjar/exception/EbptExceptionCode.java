package com.cyh.ebptpubjar.exception;

/**
 * 自定义错误类
 */

public enum EbptExceptionCode {
    // 操作成功
    SUCCESS("0000"),
    // 操作失败
    FAILURE("0001"),
    // 系统异常（自己系统的异常）
    ERROR("0002");

    private final String code;

    EbptExceptionCode(String code){
        this.code = code;
    }

    public String code(){
         return code;
    }

    /**
     * 返回对应的中文名
     */
    public String cnname(){
        switch (this){
            case SUCCESS:
                return "操作成功";
            case FAILURE:
                return "操作失败";
            case ERROR:
                return "系统异常";
            default:
                return "未定义异常";
        }
    }


}
