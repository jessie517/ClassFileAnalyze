package com.analyze.accessFlag;

import com.analyze.accessFlag.bean.FieldAccessBean;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class FieldAccessFlagAnalyze {
    public static int ACC_PUBLIC = 0X0001;
    public static int ACC_PRIVATE = 0X0002;
    public static int ACC_PROTECTED = 0X0004;
    public static int ACC_STATIC = 0X0008;
    public static int ACC_FINAL = 0X0010;
    public static int ACC_VOLATILE = 0X0040;
    public static int ACC_TRANSIENT = 0X0080;
    public static int ACC_SYNTHETIC = 0X1000;
    public static int ACC_ENUM = 0X4000;

    public static FieldAccessBean getAccessBean(byte[] b){
        return new FieldAccessBean(b);
    }

}
