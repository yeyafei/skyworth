package com.skyworth.sop.test.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.skyworth.sop.bean.R;
import com.skyworth.sop.test.entity.TestEntity;
import com.skyworth.sop.test.frm.TestFrm;
import com.skyworth.sop.test.service.TestService;
import com.skyworth.sop.test.vo.TestVo;
import com.skyworth.sop.utils.BeanUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 测试表TEST
 *
 * @author yeyafei
 * @date 2018-12-07 14:50:14
 */
@Api(value = "测试表TEST")
@RestController
@RequestMapping("test/test")
public class TestController {
//    @Autowired
//    private TestService testService;
//    
//    /**
// 	 * @description 分页
// 	 * @author yeyafei
// 	 * @date 2018-12-07
// 	 * @param frm 
// 	 */
//    @PostMapping("/list")
//	@ApiOperation(value = "分页")
//	@ApiImplicitParam(value = "查询对象", name = "frm", dataType = "TestFrm", required = true)
//	public R<Page<TestVo>> list(@RequestBody TestFrm frm) {
//		return testService.queryPage(frm);
//	}
    
//    /**
// 	 * @description 保存
// 	 * @author yeyafei
// 	 * @date 2018-12-07
// 	 * @param frm 
// 	 */
// 	@PostMapping("/save")
//	@ApiOperation("保存")
//    @ApiImplicitParam(value="新增对象",name="frm",dataType="TestFrm",required=true)
// 	public R<Boolean> save(@RequestBody TestFrm frm) throws Exception { //此处仅做示例 异常处理应在Service层处理
// 		TestEntity testEntity = BeanUtil.copyNew(frm, TestEntity.class);
// 		return new R<Boolean>().ok(testService.insert(testEntity)); //此处仅做示例 逻辑处理本不应在Controller层处理
// 	}
//
//    /**
//	 * @description 根据ID删除
//	 * @author yeyafei
//	 * @date 2018-12-07
//	 * @param id 
//	 */
//	@PostMapping("/delete")
//	@ApiOperation("根据ID删除")
//	public R<Boolean> delete(@ApiParam(required = true,value="id")  @RequestParam("id") Integer id) {
//		return new R<Boolean>().ok(testService.deleteById(id)); //此处仅做示例 逻辑处理本不应在Controller层处理
//	}
//	
//    /**
//	 * @description 根据ID修改
//	 * @author yeyafei
//	 * @date 2018-12-07
//	 * @param frm 
//	 */
// 	@PostMapping("/update")
//	@ApiOperation("修改")
//    @ApiImplicitParam(value="修改对象",name="frm",dataType="TestFrm",required=true)
// 	public R<Boolean> update(@RequestBody TestFrm frm) throws Exception { //此处仅做示例 异常处理应在Service层处理
// 		TestEntity testEntity = BeanUtil.copyNew(frm, TestEntity.class);
// 		return new R<Boolean>().ok(testService.updateById(testEntity)); //此处仅做示例 逻辑处理本不应在Controller层处理
// 	}
//
// 	
//    /**
//	 * @description 根据ID查找
//	 * @author yeyafei
//	 * @date 2018-12-07
//	 * @param id 
//	 */
//	@PostMapping("/info")
//	@ApiOperation("根据ID查找")
//	public R<TestEntity> info(@ApiParam(required = true,value="id")  @RequestParam("id") Integer id) {
//		return new R<TestEntity>().ok(testService.selectById(id)); //此处仅做示例 逻辑处理本不应在Controller层处理
//	}
//	
//	
// 	
//    /**
//	 * @description 组合查找
//	 * @author yeyafei
//	 * @date 2018-12-07
//	 * @param id 
//	 */
//	@PostMapping("/search")
//	@ApiOperation("组合查找<test1 & test2>")
//    @ApiImplicitParam(value="查找对象",name="frm",dataType="TestFrm",required=true)
//	public R<List<TestEntity>> search(@RequestBody TestFrm frm) {
//		 EntityWrapper<TestEntity> ew = new EntityWrapper<TestEntity>(); //此处仅做示例 逻辑处理本不应在Controller层处理
//		 ew.eq("test1", frm.getTest1());
//		 ew.eq("test2", frm.getTest2());
//		 List<TestEntity> userList = testService.selectList(ew);				 
//		return new R<List<TestEntity>>().ok(userList); 
//	}
}
