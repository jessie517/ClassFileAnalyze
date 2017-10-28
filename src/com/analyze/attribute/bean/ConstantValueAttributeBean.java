package com.analyze.attribute.bean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class ConstantValueAttributeBean extends AttributeInfoBean {
    private int constantValueIndex;

    public ConstantValueAttributeBean(byte[] infoBytes) {
        this.constantValueIndex = infoBytes[0] << 8 | infoBytes[1];
    }
}