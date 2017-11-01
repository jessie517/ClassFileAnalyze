package com.analyze.attribute;

import com.analyze.attribute.bean.AttributeInfoBean;
import com.analyze.attribute.bean.annotationBean.AnnotationBean;
import com.analyze.attribute.bean.annotationBean.ElementValue;
import com.analyze.constant.bean.ConstBean;
import com.utils.UToNumeric;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjiaxu on 2017/11/1.
 */
public class AnnotationsAnalyze {
    private byte[] u1 = new byte[1];
    private byte[] u2 = new byte[2];

    public AnnotationBean[] getAnnotations(int numAnnotations, InputStream in) throws Exception {
        AnnotationBean[] annotationBeans = new AnnotationBean[numAnnotations];
        for (int i = 0; i < numAnnotations; i++) {
            AnnotationBean annotationBean = new AnnotationBean();
            in.read(u2);
            annotationBean.setTypeIndex(UToNumeric.u2ToInt(u2));
            in.read(u2);
            int numElementValuePairs = UToNumeric.u2ToInt(u2);
            AnnotationBean.ElementValuePair[] elementValuePairs = new AnnotationBean.ElementValuePair[numElementValuePairs];
            for (int j = 0; j < numElementValuePairs; j++) {
                AnnotationBean.ElementValuePair elementValuePair = new AnnotationBean.ElementValuePair();
                in.read(u2);
                elementValuePair.setNameIndex(UToNumeric.u2ToInt(u2));
                elementValuePair.setElementValue(getElementValue(in));
                elementValuePairs[j] = elementValuePair;
            }

            annotationBean.setElementValuePairs(elementValuePairs);
            annotationBeans[i] = annotationBean;
        }

        return annotationBeans;
    }

    public ElementValue getElementValue(InputStream in) throws Exception {
        ElementValue elementValue = new ElementValue();
        in.read(u1);
        char tag = (char) u1[0];
        elementValue.setTag(tag);
        Map<String, Object> value = new HashMap<String, Object>();
        if (tag == 's' || tag == 'B' || tag == 'C' || tag == 'D' || tag == 'F' || tag == 'I' || tag == 'J' || tag == 'S' || tag == 'Z') {
            in.read(u2);
            value.put("const_value_index", UToNumeric.u2ToInt(u2));
        } else if (tag == 'c') {
            in.read(u2);
            value.put("class_info_index", UToNumeric.u2ToInt(u2));
        } else if (tag == 'e') {
            Map<String,Integer> enumMap = new HashMap<String,Integer>();
            in.read(u2);
            enumMap.put("type_name_index", UToNumeric.u2ToInt(u2));
            in.read(u2);
            enumMap.put("const_name_index", UToNumeric.u2ToInt(u2));
            value.put("enum_const_value", enumMap);
        } else if (tag == '@') {
            value.put("annotation_value", getAnnotations(1, in)[0]);
        } else if (tag == '[') {
            in.read(u2);
            ElementValue[] values = new ElementValue[UToNumeric.u2ToInt(u2)];
            for(int i=0; i<values.length;i++){
                values[i] = getElementValue(in);
            }
            value.put("array_value", values);
        }

        elementValue.setValue(value);

        return elementValue;
    }

}
