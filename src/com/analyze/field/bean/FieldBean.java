package com.analyze.field.bean;

import com.analyze.accessFlag.bean.FieldAccessBean;
import com.analyze.attribute.bean.AttributeInfoBean;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class FieldBean {
    private FieldAccessBean fieldAccessBean;
    private int nameIndex;
    private int descriptorInde;
    private AttributeInfoBean[] attributeInfoBeans;

    public FieldAccessBean getFieldAccessBean() {
        return fieldAccessBean;
    }

    public void setFieldAccessBean(FieldAccessBean fieldAccessBean) {
        this.fieldAccessBean = fieldAccessBean;
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
