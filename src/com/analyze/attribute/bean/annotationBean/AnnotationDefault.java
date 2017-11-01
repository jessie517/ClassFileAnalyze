package com.analyze.attribute.bean.annotationBean;

import com.analyze.attribute.AnnotationsAnalyze;
import com.analyze.attribute.bean.AttributeInfoBean;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * Created by chenjiaxu on 2017/11/1.
 */
public class AnnotationDefault implements AttributeInfoBean {
    private ElementValue defaultValue;

    public AnnotationDefault(byte[] infoBytes) throws Exception {
        this.defaultValue = new AnnotationsAnalyze().getElementValue(new ByteArrayInputStream(infoBytes));
    }

    public ElementValue getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(ElementValue defaultValue) {
        this.defaultValue = defaultValue;
    }
}
