package com.analyze.attribute.bean.annotationBean;

import com.analyze.attribute.AnnotationsAnalyze;
import com.analyze.attribute.bean.AttributeInfoBean;
import com.analyze.constant.bean.ConstBean;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * Created by chenjiaxu on 2017/11/1.
 */
public class RuntimeVisibleAnnotations implements AttributeInfoBean {
    private AnnotationBean[] annotations;

    public RuntimeVisibleAnnotations(byte[] infoBytes) throws Exception {
        int i = 0;
        int numAnnotations = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        byte[] annotationBytes = Arrays.copyOfRange(infoBytes, i, infoBytes.length);
        this.annotations = new AnnotationsAnalyze().getAnnotations(numAnnotations, new ByteArrayInputStream(annotationBytes));
    }

    public String toString(ConstBean[] constBeans) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < annotations.length; i++) {
            stringBuffer.append(annotations[i].toString(constBeans) + ", ");
        }
        return stringBuffer.toString();
    }

    public AnnotationBean[] getAnnotations() {
        return annotations;
    }

    public void setAnnotations(AnnotationBean[] annotations) {
        this.annotations = annotations;
    }
}
