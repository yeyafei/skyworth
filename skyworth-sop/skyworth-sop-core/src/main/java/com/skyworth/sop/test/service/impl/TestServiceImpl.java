package com.skyworth.sop.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.skyworth.sop.bean.R;
import com.skyworth.sop.test.dao.TestDao;
import com.skyworth.sop.test.entity.TestEntity;
import com.skyworth.sop.test.frm.TestFrm;
import com.skyworth.sop.test.service.TestService;
import com.skyworth.sop.test.vo.TestVo;
import com.skyworth.sop.utils.Query;

/**
 * 测试表TEST实现类
 *
 * @author yeyafei
 * @date 2018-12-07 14:50:14
 */
@Service("testService")
public class TestServiceImpl extends ServiceImpl<TestDao, TestEntity> implements TestService {
	@Autowired
	private TestDao testDao;
	@Override
	public R<Page<TestVo>> queryPage(TestFrm frm) {
		Page<TestVo> page = new Query<TestVo>(frm.pageParam()).getPage();
		page.setRecords(testDao.queryPage(page, frm));
		return new R<Page<TestVo>>().ok(page);
	}
}
