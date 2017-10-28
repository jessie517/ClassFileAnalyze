package com.analyze.basic.accessFlag;

import com.analyze.basic.accessFlag.bean.ClassAccessBean;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class ClassAccessFlagAnalyze {
    public static ClassAccessBean getAccessBean(byte[] b){
        return new ClassAccessBean(b);
    }
}
