package com.skyworth.sop.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.skyworth.sop.utils.MDCUtils;

@Component
public class WebLogMdcConfig implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebLogMdcConfig.class);

	private static final ThreadLocal<Long> START_TTIME_THREAD_LOCAL = new NamedThreadLocal<Long>("HttpRequestStartTime");
	
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
        throws Exception {
        MDCUtils.setMdc(); 
        long beginTime = System.nanoTime();
        START_TTIME_THREAD_LOCAL.set(beginTime);
        return true;
    }
    
    
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
        ModelAndView modelAndView) throws Exception {

    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
        Object o, Exception e) throws Exception {
        long beginTime = START_TTIME_THREAD_LOCAL.get();
        long endTime = System.nanoTime();
        long time = (endTime - beginTime) / 1000000;
        if (time > 1000) {
            LOGGER.warn(getLogMsg(httpServletRequest) + time);
        }
        START_TTIME_THREAD_LOCAL.remove();
        MDCUtils.removeMdc();
    }
    
    
    private String getLogMsg(HttpServletRequest httpServletRequest) {
        StringBuilder strBuld = new StringBuilder();
        strBuld.append("URL[");
        strBuld.append(httpServletRequest.getRequestURI());
        strBuld.append("]耗时(毫秒):");
        return strBuld.toString();
    }

    

}
