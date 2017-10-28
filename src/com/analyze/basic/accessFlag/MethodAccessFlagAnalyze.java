package com.analyze.basic.accessFlag;

import com.analyze.basic.accessFlag.bean.MethodAccessBean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class MethodAccessFlagAnalyze {

    public static MethodAccessBean getAccessBean(byte[] b){
        return new MethodAccessBean(b);
    }

}
