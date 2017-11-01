package com.analyze.attribute.bean;

import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class SyntheticAttributeBean implements AttributeInfoBean {

    public SyntheticAttributeBean(byte[] infoBytes){

    }

    public String toString(ConstBean[] constBeans) {
        return "true";
    }
}
