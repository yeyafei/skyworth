package com.skyworth.sop.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

import com.skyworth.sop.test.entity.TestEntity;
import com.skyworth.sop.test.frm.TestFrm;
import com.skyworth.sop.test.vo.TestVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 测试表TEST
 * 
 * @author yeyafei
 * @date 2018-12-07 14:50:14
 */
@Mapper
public interface TestDao extends BaseMapper<TestEntity> {

	/**
	 * @description 分页
 	 * @author yeyafei
	 * @param page
	 * @param frm
	 * @return
	 */
	List<TestVo> queryPage(Page<TestVo> page,@Param("frm") TestFrm frm);
	
}
