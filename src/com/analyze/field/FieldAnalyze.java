package com.analyze.field;

import com.analyze.attribute.AttributeAnalyze;
import com.analyze.attribute.FieldAttributeAnalyze;
import com.analyze.basic.accessFlag.FieldAccessFlagAnalyze;
import com.analyze.constant.bean.ConstBean;
import com.analyze.field.bean.FieldBean;
import com.utils.UToNumeric;

import java.io.InputStream;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class FieldAnalyze {
    private byte[] u1 = new byte[1];
    private byte[] u2 = new byte[2];

    public FieldBean[] getFieldBeans(InputStream in, ConstBean[] constBeans) throws Exception {
        // 字段表长度
        in.read(u2);
        int fieldCount = UToNumeric.u2ToInt(u2);

        FieldBean[] fieldBeans = new FieldBean[fieldCount];
        AttributeAnalyze attributeAnalyze = new FieldAttributeAnalyze();
        for (int i = 0; i < fieldCount; i++) {
            FieldBean fieldBean = new FieldBean();

            in.read(u2);
            fieldBean.setFieldAccessBean(FieldAccessFlagAnalyze.getAccessBean(u2));

            in.read(u2);
            fieldBean.setNameIndex(UToNumeric.u2ToInt(u2));

            in.read(u2);
            fieldBean.setDescriptorIndex(UToNumeric.u2ToInt(u2));

            fieldBean.setAttributeInfoBeanMap(attributeAnalyze.getAttributeInfoBeans(in, constBeans));

            fieldBeans[i] = fieldBean;
        }
        return fieldBeans;
    }

}
