package com.analyze.attribute.bean;

import com.analyze.field.bean.FieldBean;

import java.io.InputStream;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class AttributeInfoBean {
    private int attributeNameIndex;
    private byte[] infoBytes;

    public int getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(int attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public byte[] getInfoBytes() {
        return infoBytes;
    }

    public void setInfoBytes(byte[] infoBytes) {
        this.infoBytes = infoBytes;
    }
}
