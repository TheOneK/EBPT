package com.cyh.ebptpubjar.utils.ebptbeanCopier;

import org.springframework.cglib.core.Converter;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/**
 *拷贝对象属性值
 */
// TODO 待修改
public class ConverterToStr implements Converter {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Object convert(Object value, Class target, Object context) {
        if (value instanceof Integer) {
            return (Integer) value;
        } else if (value instanceof BigDecimal) {
            BigDecimal bd = (BigDecimal) value;
            return bd.toPlainString();
        }
        return null;
    }
}