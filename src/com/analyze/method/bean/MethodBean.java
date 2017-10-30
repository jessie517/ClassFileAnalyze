package com.analyze.method.bean;

import com.analyze.basic.accessFlag.bean.MethodAccessBean;
import com.analyze.attribute.bean.AttributeInfoBean;
import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class MethodBean {
    private MethodAccessBean methodAccessBean;
    private int nameIndex;
    private int descriptorIndex;
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
        stringBuffer.append("\taccessFlag: " + methodAccessBean.toString() + "\n");
        stringBuffer.append("\tdescriptor: " + constBeans[descriptorIndex].getValue() + "\n");
        stringBuffer.append("\tattributes: " + "\n");
        for (int i = 0; i < attributeInfoBeans.length; i++) {
            stringBuffer.append("\t\t" + attributeInfoBeans[i].toString() + "\n");
        }

        return stringBuffer.toString();
    }
}
