package com.cyh.ebptpubjar.utils.ebptbeanCopier;

import com.cyh.ebptpubjar.ebptLogger.EbptLogger;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

import java.util.HashMap;
import java.util.Map;

/**
 * 拷贝对象属性值
 */
// TODO 待修改
public class EbptBeanCopier {
    static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap<>();

    public static void copy(Object srcObj, Object destObj, boolean useConverter,Converter converter,HashMap<String,Object> context) throws Exception{
        String key = genKey(srcObj.getClass(), destObj.getClass(), useConverter);
        BeanCopier copier ;
        EbptLogger.info(EbptBeanCopier.class,context,"BEAN_COPIERS.containsKey(key):[{}]",BEAN_COPIERS.containsKey(key));
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(srcObj.getClass(), destObj.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        EbptLogger.info(EbptBeanCopier.class,context,"useConverter:[{}]",converter);
        //当参数需要转换器但是传入的参数为空时报错
        if(useConverter && converter==null){
            throw new NullPointerException("converter is null");
        }
        EbptLogger.info(EbptBeanCopier.class,context,"useConverter:[{}]",useConverter);
        if(useConverter){
            copier.copy(srcObj, destObj, converter);
        }else{
            copier.copy(srcObj, destObj, null);
        }

    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz, boolean useConverter) {
        if (useConverter) {
            return srcClazz.getName() + destClazz.getName() + "0";
        } else {
            return srcClazz.getName() + destClazz.getName() + "1";
        }
    }

}
