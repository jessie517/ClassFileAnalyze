package com.analyze.attribute.bean.annotationBean;

/**
 * Created by chenjiaxu on 2017/11/1.
 */
public class AnnotationBean {
    private int typeIndex;
    private ElementValuePair[] elementValuePairs;

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
