package com.analyze.field.bean;

import com.analyze.basic.accessFlag.bean.FieldAccessBean;
import com.analyze.attribute.bean.AttributeInfoBean;
import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class FieldBean {
    private FieldAccessBean fieldAccessBean;
    private int nameIndex;
    private int descriptorIndex;
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

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    public AttributeInfoBean[] getAttributeInfoBeans() {
        return attributeInfoBeans;
    }

    public void setAttributeInfoBeans(AttributeInfoBean[] attributeInfoBeans) {
        this.attributeInfoBeans = attributeInfoBeans;
    }

    public String toString(ConstBean[] constBeans){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(constBeans[nameIndex].getValue() + "\n");
        stringBuffer.append("\taccessFlag: " + fieldAccessBean.toString() + "\n");
        stringBuffer.append("\tdescriptor: " + constBeans[descriptorIndex].getValue() + "\n");
        stringBuffer.append("\tattributes: " + "\n");
        for (int i = 0; i < attributeInfoBeans.length; i++) {
            stringBuffer.append("\t\t" + attributeInfoBeans[i].toString() + "\n");
        }

        return stringBuffer.toString();
    }
}
