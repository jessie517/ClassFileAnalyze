package com.analyze.attribute.bean.annotationBean;

import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/11/1.
 */
public class AnnotationBean {
    private int typeIndex;
    private ElementValuePair[] elementValuePairs;

    public String toString(ConstBean[] constBeans){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(constBeans[typeIndex].getValue());
        for(int i=0; i < elementValuePairs.length; i++){
            //TODO
            System.out.println("待解析");
        }
        return stringBuffer.toString();
    }
    public int getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(int typeIndex) {
        this.typeIndex = typeIndex;
    }

    public ElementValuePair[] getElementValuePairs() {
        return elementValuePairs;
    }

    public void setElementValuePairs(ElementValuePair[] elementValuePairs) {
        this.elementValuePairs = elementValuePairs;
    }

    public static class ElementValuePair {
        private int nameIndex;
        private ElementValue elementValue;

        public int getNameIndex() {
            return nameIndex;
        }

        public void setNameIndex(int nameIndex) {
            this.nameIndex = nameIndex;
        }

        public ElementValue getElementValue() {
            return elementValue;
        }

        public void setElementValue(ElementValue elementValue) {
            this.elementValue = elementValue;
        }
    }


}
