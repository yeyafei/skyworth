package com.skyworth.sop.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * BeanUtil
 */
public class BeanUtil {


	public static <T> List<T> copy(List<?> oriList,Class<T> cls) throws Exception {
		List<T> destList=null;
		if(oriList!=null&&oriList.size()>0) {
			destList=new ArrayList<T>(oriList.size());
			for (@SuppressWarnings("rawtypes")
			Iterator iterator = oriList.iterator(); iterator.hasNext();) {
				T dest=cls.newInstance();
                ConvertUtils.register(new DateConverter(null), Date.class);
				BeanUtils.copyProperties(dest, iterator.next());
				destList.add(dest);
			}
		}
		return destList;
    }
	
	public static <T> T copyNew(Object src,Class<T> cls) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		T dest=cls.newInstance();
        ConvertUtils.register(new DateConverter(null), Date.class);
		BeanUtils.copyProperties(dest, src);
		return dest;
    }
	
	public static void initCreateTimeAndUpdateTime(Object...objs){
		initCreateTime(objs);
		initUpdateTime(objs);
    }
	
	public static void initCreateTime(Object...objs){
        if(objs!=null&&objs.length>0){
            for(int i=0;i< objs.length;i++){
                Object obj=objs[i];
               if(obj!=null){
                   try {
                	   Method method=getDeclaredMethod(obj, "setCreateTime", new Class[]{Date.class});
                       method.setAccessible(true);
                       if (method!=null) {
                    	   method.invoke(obj,new Object[] {new Date()});
                       }
                   } catch (Exception e) {
                        e.printStackTrace();
                   }

               }
            }
        }
    }
	
	public static Method getDeclaredMethod(Object object, String methodName, Class<?> ... parameterTypes){  
        Method method = null ;  
          
        for(Class<?> clazz = object.getClass() ; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
            try {  
                method = clazz.getDeclaredMethod(methodName, parameterTypes) ;  
                return method ;  
            } catch (Exception e) {  
                //这里甚么都不能抛出去。  
                //如果这里的异常打印或者往外抛，则就不会进入              
            }  
        }  
          
        return null;  
    } 
	public static void initUpdateTime(Object...objs){
        if(objs!=null&&objs.length>0){
            for(int i=0;i< objs.length;i++){
                Object obj=objs[i];
               if(obj!=null){
                   try {
                	   Method method=getDeclaredMethod(obj, "setUpdateTime", new Class[]{Date.class});
                	   method.setAccessible(true);
                       if (method!=null) {
                    	   method.invoke(obj,new Object[] {new Date()});
                       }
                   } catch (Exception e) {
                        
                   }

               }
            }
        }
    }
	
	private static  ObjectMapper objectMapper = new ObjectMapper();
	public static <T> T parseJsonStr(String str,Class<T> cls) throws JsonParseException, JsonMappingException, IOException{
		return  objectMapper.readValue(str.getBytes(),cls);
    }
	
}
