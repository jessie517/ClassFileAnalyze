package com.analyze.method.bean;

import com.analyze.basic.accessFlag.bean.MethodAccessBean;
import com.analyze.attribute.bean.AttributeInfoBean;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class MethodBean {
    private MethodAccessBean methodAccessBean;
    private int nameIndex;
    private int descriptorInde;
    private AttributeInfoBean[] attributeInfoBeans;

    public MethodAccessBean getMethodAccessBean() {
        return methodAccessBean;
    }

    public void setMethodAccessBean(MethodAccessBean methodAccessBean) {
        this.methodAccessBean = methodAccessBean;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getDescriptorInde() {
        return descriptorInde;
    }

    public void setDescriptorInde(int descriptorInde) {
        this.descriptorInde = descriptorInde;
    }

    public AttributeInfoBean[] getAttributeInfoBeans() {
        return attributeInfoBeans;
    }

    public void setAttributeInfoBeans(AttributeInfoBean[] attributeInfoBeans) {
        this.attributeInfoBeans = attributeInfoBeans;
    }
}
