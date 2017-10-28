package com.analyze.attribute.bean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class ExceptionAttributeBean extends AttributeInfoBean {
    private int exceptionIndexs[];

    public ExceptionAttributeBean(byte[] infoBytes) {
        int i = 0;
        // 异常总数
        int exceptionTotal = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        this.exceptionIndexs = new int[exceptionTotal];
        for (int count = 0; count < exceptionTotal; count++) {
            exceptionIndexs[count] = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        }
    }

    public int[] getExceptionIndexs() {
        return exceptionIndexs;
    }

    public void setExceptionIndexs(int[] exceptionIndexs) {
        this.exceptionIndexs = exceptionIndexs;
    }
}
