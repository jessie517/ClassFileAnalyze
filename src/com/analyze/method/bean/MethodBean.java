package com.analyze.method.bean;

import com.analyze.basic.accessFlag.bean.MethodAccessBean;
import com.analyze.attribute.bean.AttributeInfoBean;
import com.analyze.constant.bean.ConstBean;

import java.util.Map;
import java.util.Set;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class MethodBean {
    private MethodAccessBean methodAccessBean;
    private int nameIndex;
    private int descriptorIndex;
    private Map<String, AttributeInfoBean> attributeInfoBeanMap;

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

    public Map<String, AttributeInfoBean> getAttributeInfoBeanMap() {
        return attributeInfoBeanMap;
    }

    public void setAttributeInfoBeanMap(Map<String, AttributeInfoBean> attributeInfoBeanMap) {
        this.attributeInfoBeanMap = attributeInfoBeanMap;
    }

    public String toString(ConstBean[] constBeans) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(constBeans[nameIndex].getValue() + "\n");
        stringBuffer.append("\taccessFlag: " + methodAccessBean.toString() + "\n");
        stringBuffer.append("\tdescriptor: " + constBeans[descriptorIndex].getValue() + "\n");
        stringBuffer.append("\tattributes: " + "\n");
        Set<Map.Entry<String, AttributeInfoBean>> entries = attributeInfoBeanMap.entrySet();
        for (Map.Entry<String, AttributeInfoBean> entry : entries) {
            stringBuffer.append("\t\t" + entry.getKey() + ":" + entry.getValue().toString(constBeans) + "\n");
        }
        return stringBuffer.toString();
    }
}
