package com.analyze.attribute;

import com.analyze.attribute.bean.*;
import com.analyze.constant.bean.ConstBean;
import com.utils.UToNumeric;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjiaxu on 2017/10/31.
 */
public abstract class AttributeAnalyze {
    private byte[] u2 = new byte[2];
    private byte[] u4 = new byte[4];

    public Map<String, AttributeInfoBean> getAttributeInfoBeans(InputStream in, ConstBean[] constBeans) throws Exception {
        in.read(u2);
        int attributeCount = UToNumeric.u2ToInt(u2);

        Map<String, AttributeInfoBean> attributeInfoBeanMap = new HashMap<String, AttributeInfoBean>();
        for (int i = 0; i < attributeCount; i++) {
            in.read(u2);
            int nameIndex = UToNumeric.u2ToInt(u2);
            in.read(u4);
            byte[] infoBytes = new byte[UToNumeric.u4ToInt(u4)];
            in.read(infoBytes);
            String attributeName = (String)constBeans[nameIndex].getValue();
            attributeInfoBeanMap.put(attributeName, getAttributeBean(attributeName, infoBytes, constBeans));
        }
        return attributeInfoBeanMap;
    }

    public abstract AttributeInfoBean getAttributeBean(String attributeName, byte[] infoBytes, ConstBean[] constBeans) throws Exception;

}
