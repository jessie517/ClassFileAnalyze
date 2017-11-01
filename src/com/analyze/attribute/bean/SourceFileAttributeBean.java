package com.analyze.attribute.bean;

import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class SourceFileAttributeBean implements AttributeInfoBean {
    private int sourceFileIndex;

    public SourceFileAttributeBean(byte[] infoBytes) {
        this.sourceFileIndex = (infoBytes[0] & 0xFF) << 8 | (infoBytes[1] & 0xFF);
    }

    public int getSourceFileIndex() {
        return sourceFileIndex;
    }

    public void setSourceFileIndex(int sourceFileIndex) {
        this.sourceFileIndex = sourceFileIndex;
    }

    public String toString(ConstBean[] constBeans) {
        return constBeans[sourceFileIndex].getValue().toString();
    }
}
