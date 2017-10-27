package com.analyze.field;

import com.analyze.accessFlag.FieldAccessFlagAnalyze;
import com.analyze.attribute.AttributeAnalyze;
import com.analyze.field.bean.FieldBean;
import com.utils.UToNumeric;

import java.io.InputStream;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class FieldAnalyze {
    private byte[] u1 = new byte[1];
    private byte[] u2 = new byte[2];

    public FieldBean[] getFieldBeans(int fieldCount, InputStream in) throws Exception {
        FieldBean[] constBeans = new FieldBean[fieldCount];
        AttributeAnalyze attributeAnalyze = new AttributeAnalyze();
        for (int i = 1; i < fieldCount; i++) {
            FieldBean fieldBean = new FieldBean();
            in.read(u2);
            fieldBean.setFieldAccessBean(FieldAccessFlagAnalyze.getAccessBean(u2));
            in.read(u2);
            fieldBean.setNameIndex(UToNumeric.u2ToInt(u2));
            in.read(u2);
            fieldBean.setDescriptorInde(UToNumeric.u2ToInt(u2));
            in.read(u2);
            int attributeCount = UToNumeric.u2ToInt(u2);
            fieldBean.setAttributeInfoBeans(attributeAnalyze.getAttributeInfoBeans(attributeCount, in));
        }
        return constBeans;
    }

}
