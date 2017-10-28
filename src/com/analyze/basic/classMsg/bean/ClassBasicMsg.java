package com.analyze.basic.classMsg.bean;

import com.analyze.basic.accessFlag.bean.ClassAccessBean;

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
}
