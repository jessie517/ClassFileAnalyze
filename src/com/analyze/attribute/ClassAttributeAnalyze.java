package com.analyze.attribute;

import com.analyze.attribute.bean.*;
import com.analyze.attribute.bean.annotationBean.RuntimeInvisibleAnnotations;
import com.analyze.attribute.bean.annotationBean.RuntimeVisibleAnnotations;
import com.analyze.constant.bean.ConstBean;
import com.utils.UToNumeric;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class ClassAttributeAnalyze extends AttributeAnalyze {
    @Override
    public AttributeInfoBean getAttributeBean(String attributeName, byte[] infoBytes, ConstBean[] constBeans) throws Exception {
        if ("SourceFile".equals(attributeName)) {
            return new SourceFileAttributeBean(infoBytes);
        } else if ("LocalVariableTypeTable".equals(attributeName)) {
            return new LocalVariableTypeTableAttributeBean(infoBytes);
        } else if ("RuntimeVisibleAnnotations".equals(attributeName)) {
            return new RuntimeVisibleAnnotations(infoBytes);
        } else if ("RuntimeInvisibleAnnotations".equals(attributeName)) {
            return new RuntimeInvisibleAnnotations(infoBytes);
        } else if ("InnerClasses".equals(attributeName)) {
            return new InnerClassesAttributeBean(infoBytes);
        } else {
            System.out.println(attributeName);
        }
        return null;
    }
}
