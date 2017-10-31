package com.analyze.attribute;

import com.analyze.attribute.bean.*;
import com.analyze.constant.bean.ConstBean;
import com.utils.UToNumeric;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class CodeAttributeAnalyze extends AttributeAnalyze {

    @Override
    public AttributeInfoBean getAttributeBean(String attributeName, byte[] infoBytes, ConstBean[] constBeans) throws Exception {
        if ("LineNumberTable".equals(attributeName)) {
            return new LineNumberTableAttributeBean(infoBytes);
        } else if ("LocalVariableTable".equals(attributeName)) {
            return new LocalVariableTableAttributeBean(infoBytes);
        } else if ("LocalVariableTypeTable".equals(attributeName)) {
            return new LocalVariableTypeTableAttributeBean(infoBytes);
        } else if ("StackMapTable".equals(attributeName)) {

        } else {
            System.out.println(attributeName);
        }
        return null;
    }
}
