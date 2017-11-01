package com.analyze.attribute.bean.annotationBean;

import java.util.Map;

/**
 * Created by chenjiaxu on 2017/11/1.
 */
public class ElementValue {
    private char tag;
    private Map<String, Object> value;

    public char getTag() {
        return tag;
    }

    public void setTag(char tag) {
        this.tag = tag;
    }

    public Map<String, Object> getValue() {
        return value;
    }

    public void setValue(Map<String, Object> value) {
        this.value = value;
    }


}
