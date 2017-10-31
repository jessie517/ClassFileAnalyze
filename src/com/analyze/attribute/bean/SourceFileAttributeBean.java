package com.analyze.attribute.bean;

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
}
