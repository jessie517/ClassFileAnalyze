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

    public void generateAttributeInfoBean(ConstBean[] constBeans) {
        Object attributeName = constBeans[attributeNameIndex].getValue();
        if ("CODE".equals(attributeName)) {
            this.setAttributeInfoBean(new CodeAttributeBean(infoBytes));
        } else if ("EXCEPTION".equals(attributeName)) {
            this.setAttributeInfoBean(new ExceptionAttributeBean(infoBytes));
        } else if ("LINENUMBERTABLE".equals(attributeName)) {
            this.setAttributeInfoBean(new LineNumberTableAttributeBean(infoBytes));
        } else if ("LOCALVARIABLETABLE".equals(attributeName)) {
            this.setAttributeInfoBean(new LocalVariableTableAttributeBean(infoBytes));
        } else if ("SOURCEFILE".equals(attributeName)) {
            this.setAttributeInfoBean(new SourceFileAttributeBean(infoBytes));
        } else if ("CONSTANTVALUE".equals(attributeName)) {
            this.setAttributeInfoBean(new ConstantValueAttributeBean(infoBytes));
        } else if ("INNERCLASSES".equals(attributeName)) {
            this.setAttributeInfoBean(new InnerClassesAttributeBean(infoBytes));
        } else if ("DEPRECATED".equals(attributeName)) {
            this.setAttributeInfoBean(new DeprecatedAttributeBean(infoBytes));
        } else if ("SYNTHETIC".equals(attributeName)) {
            this.setAttributeInfoBean(new SyntheticAttributeBean(infoBytes));
        }
    }

}
