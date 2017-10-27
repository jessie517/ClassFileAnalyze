package com.analyze.accessFlag;

import com.analyze.accessFlag.bean.ClassAccessBean;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class ClassAccessFlagAnalyze {
    public static int ACC_PUBLIC = 0X0001;
    public static int ACC_FINAL = 0X0010;
    public static int ACC_SUPER = 0X0020;

    public static int ACC_INTERFACE = 0X0200;
    public static int ACC_ABSTRACT = 0X0400;

    public static int ACC_SYNTHETIC = 0X1000;
    public static int ACC_ANNOTATION = 0X2000;
    public static int ACC_ENUM = 0X4000;

    public static ClassAccessBean getAccessBean(byte[] b){
        return new ClassAccessBean(b);
    }
}
