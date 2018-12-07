package com.skyworth.sop.test.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.skyworth.sop.bean.R;
import com.skyworth.sop.test.entity.TestEntity;
import com.skyworth.sop.test.frm.TestFrm;
import com.skyworth.sop.test.vo.TestVo;


/**
 * 测试表TEST
 *
 * @author yeyafei
 * @date 2018-12-07 14:50:14
 */
public interface TestService extends IService<TestEntity> {

	/** 
	 * @description 分页
 	 * @author yeyafei
 	 * @date 2018-12-07
	 * @param frm
	 * @return
	 */
	R<Page<TestVo>> queryPage(TestFrm frm);

}

