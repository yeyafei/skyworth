package com.skyworth.sop.utils;


import java.util.UUID;

import org.slf4j.MDC;


public class MDCUtils {

    private final static String TRACE_ID = "traceId";


    private static String getRequestId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }


    public static void setMdc() {
        MDC.put(TRACE_ID, getRequestId());
    }
    

    public static void setMdc(String traceId) {
        MDC.put(TRACE_ID, traceId);
    }


    public static void removeMdc() {
        MDC.remove(TRACE_ID);
    }
    

    public static String getMdc() {
        return MDC.get(TRACE_ID);
    }

}
