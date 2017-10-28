package com.analyze.attribute;

import com.analyze.attribute.bean.AttributeInfoBean;
import com.analyze.constant.bean.ConstBean;
import com.utils.UToNumeric;

import java.io.InputStream;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class AttributeAnalyze {
    private byte[] u2 = new byte[2];
    private byte[] u4 = new byte[4];

    public AttributeInfoBean[] getAttributeInfoBeans(InputStream in, ConstBean[] constBeans) throws Exception {
        in.read(u2);
        int attributeCount = UToNumeric.u2ToInt(u2);

        AttributeInfoBean[] attributeInfoBeans = new AttributeInfoBean[attributeCount];
        for(int i=0; i<attributeCount;i++){
            AttributeInfoBean attributeInfoBean = new AttributeInfoBean();
            in.read(u2);
            attributeInfoBean.setAttributeNameIndex(UToNumeric.u2ToInt(u2));
            in.read(u4);
            byte[] infoBytes = new byte[UToNumeric.u4ToInt(u4)];
            in.read(infoBytes);
            attributeInfoBean.setInfoBytes(infoBytes);
            attributeInfoBean.generateAttributeInfoBean(constBeans);
            attributeInfoBeans[i] = attributeInfoBean;
        }
        return attributeInfoBeans;
    }
}
