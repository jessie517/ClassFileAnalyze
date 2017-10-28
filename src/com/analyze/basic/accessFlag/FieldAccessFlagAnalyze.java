package com.analyze.basic.accessFlag;

import com.analyze.basic.accessFlag.bean.FieldAccessBean;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class FieldAccessFlagAnalyze {

    public static FieldAccessBean getAccessBean(byte[] b){
        return new FieldAccessBean(b);
    }

}
