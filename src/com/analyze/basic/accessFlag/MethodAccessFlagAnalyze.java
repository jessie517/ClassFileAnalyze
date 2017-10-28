package com.analyze.basic.accessFlag;

import com.analyze.basic.accessFlag.bean.MethodAccessBean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class MethodAccessFlagAnalyze {
    public static int ACC_PUBLIC = 0X0001;
    public static int ACC_PRIVATE = 0X0002;
    public static int ACC_PROTECTED = 0X0004;
    public static int ACC_STATIC = 0X0008;
    public static int ACC_FINAL = 0X0010;
    public static int ACC_SYNCHRONIZED = 0X0020;
    public static int ACC_BRIDGE = 0X0040;
    public static int ACC_VARARGS = 0X0080;
    public static int ACC_NATIVE = 0X0100;
    public static int ACC_ABSTRACT = 0X0400;
    public static int ACC_STRICT = 0X0800;
    public static int ACC_SYNTHETIC = 0X1000;

    public static MethodAccessBean getAccessBean(byte[] b){
        return new MethodAccessBean(b);
    }


}
