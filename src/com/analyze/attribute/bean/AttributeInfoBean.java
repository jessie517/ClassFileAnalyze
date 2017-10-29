package com.analyze.attribute.bean;

import com.analyze.constant.bean.ConstBean;
import com.analyze.field.bean.FieldBean;

import java.io.InputStream;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class AttributeInfoBean {
    private int attributeNameIndex;
    private byte[] infoBytes;
    private AttributeInfoBean attributeInfoBean;

    public int getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(int attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public byte[] getInfoBytes() {
        return infoBytes;
    }

    public void setInfoBytes(byte[] infoBytes) {
        this.infoBytes = infoBytes;
    }

    public AttributeInfoBean getAttributeInfoBean() {
        return attributeInfoBean;
    }

    public void setAttributeInfoBean(AttributeInfoBean attributeInfoBean) {
        this.attributeInfoBean = attributeInfoBean;
    }

    public void generateAttributeInfoBean(ConstBean[] constBeans) throws Exception {
        Object attributeName = constBeans[attributeNameIndex].getValue();
        if ("Code".equals(attributeName)) {
            this.setAttributeInfoBean(new CodeAttributeBean(infoBytes, constBeans));
        } else if ("StackMapTable".equals(attributeName)) {

        } else if ("Exceptions".equals(attributeName)) {
            this.setAttributeInfoBean(new ExceptionAttributeBean(infoBytes));
        } else if ("LineNumberTable".equals(attributeName)) {
            this.setAttributeInfoBean(new LineNumberTableAttributeBean(infoBytes));
        } else if ("LocalVariableTable".equals(attributeName)) {
            this.setAttributeInfoBean(new LocalVariableTableAttributeBean(infoBytes));
        } else if ("LocalVariableTypeTable".equals(attributeName)) {
            this.setAttributeInfoBean(new LocalVariableTypeTableAttributeBean(infoBytes));
        } else if ("RuntimeVisibleParameterAnnotations".equals(attributeName)) {

        } else if ("RuntimeInvisibleParameterAnnotations".equals(attributeName)) {

        } else if ("AnnotationDefault".equals(attributeName)) {

        } else if ("RuntimeVisibleAnnotations".equals(attributeName)) {

        } else if ("RuntimeInvisibleAnnotations".equals(attributeName)) {

        } else if ("Signature".equals(attributeName)) {
            this.setAttributeInfoBean(new SignatureAttributeBean(infoBytes));
        } else if ("SourceFile".equals(attributeName)) {
            this.setAttributeInfoBean(new SourceFileAttributeBean(infoBytes));
        } else if ("ConstantValue".equals(attributeName)) {
            this.setAttributeInfoBean(new ConstantValueAttributeBean(infoBytes));
        } else if ("InnerClasses".equals(attributeName)) {
            this.setAttributeInfoBean(new InnerClassesAttributeBean(infoBytes));
        } else if ("Deprecated".equals(attributeName)) {
            this.setAttributeInfoBean(new DeprecatedAttributeBean(infoBytes));
        } else if ("Synthetic".equals(attributeName)) {
            this.setAttributeInfoBean(new SyntheticAttributeBean(infoBytes));
        } else {
            System.out.println(attributeName);
        }
    }

    public String toString(ConstBean[] constBeans){
        if(this.getAttributeInfoBean() != null){
            return this.getAttributeInfoBean().toString();
        } else {
            return "待完善";
        }
    }
}
