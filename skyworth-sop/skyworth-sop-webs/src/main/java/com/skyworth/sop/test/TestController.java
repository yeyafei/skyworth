package com.skyworth.sop.test;

import com.skyworth.sop.bean.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: skyworth-sop
 * @description: 测试Controller
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-06 15:43
 */
@Api(value = "Test")
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService service;

    @PostMapping("/success")
    public R<String> success() {
        return service.success();
    }

    @PostMapping("/error")
    public R<String> error() {
        return service.error();
    }
}
