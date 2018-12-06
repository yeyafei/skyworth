package com.skyworth.sop.test;
import com.skyworth.sop.bean.R;
import com.skyworth.sop.exception.ServiceException;
import org.springframework.stereotype.Service;

/**
 * @program: skyworth-sop
 * @description: 测试Service
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-06 15:48
 */
@Service
public class TestService {
    public R<String> success(){
        return  new R<String>().ok("SUCCESS");
    }
    public R<String> error(){
        throw new ServiceException("10000","测试ERROR");
    }
}
