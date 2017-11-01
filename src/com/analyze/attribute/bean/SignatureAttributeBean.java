package com.analyze.attribute.bean;

import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/10/29.
 * 用于泛型类型
 */
public class SignatureAttributeBean implements AttributeInfoBean {
    private int signatureIndex;

    public SignatureAttributeBean(byte[] infoBytes) {
        this.signatureIndex = (infoBytes[0] & 0xFF) << 8 | (infoBytes[1] & 0xFF);
    }

    public int getSignatureIndex() {
        return signatureIndex;
    }

    public void setSignatureIndex(int signatureIndex) {
        this.signatureIndex = signatureIndex;
    }

    public String toString(ConstBean[] constBeans) {
        return constBeans[signatureIndex].getValue().toString();
    }
}
