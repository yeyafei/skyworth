package com.skyworth.sop.enums;

/**
 * @program: skyworth-sop
 * @description: 错误枚举类
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-06 15:30
 */
public class ErrorCode {
    /**
     * 系统枚举类型
     *
     */
    public enum SysErrorType {
        SYSTEM_ERROR("S40001","系统错误");

        private String code;
        private String desc;

        private SysErrorType(String code, String desc) {
            this.setCode(code);
            this.setDesc(desc);
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
