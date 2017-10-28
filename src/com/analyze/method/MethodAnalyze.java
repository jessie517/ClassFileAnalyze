package com.analyze.method;

import com.analyze.basic.accessFlag.MethodAccessFlagAnalyze;
import com.analyze.attribute.AttributeAnalyze;
import com.analyze.constant.bean.ConstBean;
import com.analyze.method.bean.MethodBean;
import com.utils.UToNumeric;

import java.io.InputStream;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class MethodAnalyze {

    private byte[] u1 = new byte[1];
    private byte[] u2 = new byte[2];

    public MethodBean[] getMethodBeans(InputStream in, ConstBean[] constBeans) throws Exception {
        // 方法表长度
        in.read(u2);
        int methodCount = UToNumeric.u2ToInt(u2);

        MethodBean[] methodBeans = new MethodBean[methodCount];
        AttributeAnalyze attributeAnalyze = new AttributeAnalyze();
        for (int i = 0; i < methodCount; i++) {
            MethodBean methodBean = new MethodBean();

            in.read(u2);
            methodBean.setMethodAccessBean(MethodAccessFlagAnalyze.getAccessBean(u2));

            in.read(u2);
            methodBean.setNameIndex(UToNumeric.u2ToInt(u2));

            in.read(u2);
            methodBean.setDescriptorInde(UToNumeric.u2ToInt(u2));

            methodBean.setAttributeInfoBeans(attributeAnalyze.getAttributeInfoBeans(in,constBeans));

            methodBeans[i] = methodBean;
        }
        return methodBeans;
    }
}
