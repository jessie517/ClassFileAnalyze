package com.analyze.attribute.bean;

import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class ExceptionAttributeBean implements AttributeInfoBean {
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

    public String toString(ConstBean[] constBeans) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < exceptionIndexs.length; i++) {
            int nameIndex = ((int[]) constBeans[exceptionIndexs[i]].getValue())[0];
            stringBuffer.append(constBeans[nameIndex].getValue() + ", ");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 2);
    }

    public int[] getExceptionIndexs() {
        return exceptionIndexs;
    }

    public void setExceptionIndexs(int[] exceptionIndexs) {
        this.exceptionIndexs = exceptionIndexs;
    }
}
