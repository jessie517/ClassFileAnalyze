package com.analyze.basic.classMsg.bean;

import com.analyze.basic.accessFlag.bean.ClassAccessBean;
import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class ClassBasicMsg {
    private ClassAccessBean classAccessBean;
    private int classIndex;
    private int parentClassIndex;
    private int[] interfaceIndexs;

    public ClassAccessBean getClassAccessBean() {
        return classAccessBean;
    }

    public void setClassAccessBean(ClassAccessBean classAccessBean) {
        this.classAccessBean = classAccessBean;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(int classIndex) {
        this.classIndex = classIndex;
    }

    public int getParentClassIndex() {
        return parentClassIndex;
    }

    public void setParentClassIndex(int parentClassIndex) {
        this.parentClassIndex = parentClassIndex;
    }

    public int[] getInterfaceIndexs() {
        return interfaceIndexs;
    }

    public void setInterfaceIndexs(int[] interfaceIndexs) {
        this.interfaceIndexs = interfaceIndexs;
    }

    public String toString(ConstBean[] constBeans) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("class: " + constBeans[((int[]) constBeans[classIndex].getValue())[0]].getValue() + "\n");
        stringBuffer.append("accessFlag: " + classAccessBean.toString() + "\n");
        stringBuffer.append("parentClass: " + constBeans[((int[]) constBeans[parentClassIndex].getValue())[0]].getValue() + "\n");
        stringBuffer.append("interfaces: ");
        for (int i = 0; i < interfaceIndexs.length; i++) {
            stringBuffer.append(constBeans[((int[]) constBeans[interfaceIndexs[i]].getValue())[0]].getValue() + ", ");
        }
        return stringBuffer.toString();
    }
}
