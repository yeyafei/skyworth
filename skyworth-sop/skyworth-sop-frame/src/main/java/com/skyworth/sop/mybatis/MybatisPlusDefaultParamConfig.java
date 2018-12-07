package com.skyworth.sop.mybatis;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.skyworth.sop.constant.Constant;

/**
 * @program: skyworth-sop
 * @description: 自动填充
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-06 14:16
*/
@Component
public class MybatisPlusDefaultParamConfig extends MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName(Constant.CREATE_TIME, new Date(), metaObject);
		//TODO
		//新增人MARK
	}
	
    @Override
    public void updateFill(MetaObject metaObject) { 
    	  this.setFieldValByName(Constant.UPDATE_TIME, new Date(), metaObject);
    	//TODO
    	//修改人人MARK
    }


} 