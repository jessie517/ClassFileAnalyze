package com.analyze.basic.accessFlag.bean;

import com.analyze.basic.accessFlag.ClassAccessFlagAnalyze;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class ClassAccessBean {
    public static final int ACC_PUBLIC = 0X0001;
    public static final int ACC_FINAL = 0X0010;
    public static final int ACC_SUPER = 0X0020;

    public static final int ACC_INTERFACE = 0X0200;
    public static final int ACC_ABSTRACT = 0X0400;

    public static final int ACC_SYNTHETIC = 0X1000;
    public static final int ACC_ANNOTATION = 0X2000;
    public static final int ACC_ENUM = 0X4000;

    private boolean isPublic;
    private boolean isFinal;
    private boolean isSuper;

    private boolean isInterface;
    private boolean isAbstract;

    private boolean isSynthtic;
    private boolean isAnnotation;
    private boolean isEnum;

    public ClassAccessBean(byte[] b) {
        int accessFlag = (b[0] & 0xFF) << 8 | (b[1] & 0xFF);
        if ((accessFlag & ACC_PUBLIC) == ACC_PUBLIC) {
            this.isPublic = true;
        }
        if ((accessFlag & ACC_FINAL) == ACC_FINAL) {
            this.isFinal = true;
        }
        if ((accessFlag & ACC_SUPER) == ACC_SUPER) {
            this.isSuper = true;
        }
        if ((accessFlag & ACC_INTERFACE) == ACC_INTERFACE) {
            this.isInterface = true;
        }
        if ((accessFlag & ACC_ABSTRACT) == ACC_ABSTRACT) {
            this.isAbstract = true;
        }
        if ((accessFlag & ACC_SYNTHETIC) == ACC_SYNTHETIC) {
            this.isSynthtic = true;
        }
        if ((accessFlag & ACC_ANNOTATION) == ACC_ANNOTATION) {
            this.isAnnotation = true;
        }
        if ((accessFlag & ACC_ENUM) == ACC_ENUM) {
            this.isEnum = true;
        }
    }

    public boolean isPublic() {
        return isPublic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public boolean isSuper() {
        return isSuper;
    }

    public boolean isInterface() {
        return isInterface;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public boolean isSynthtic() {
        return isSynthtic;
    }

    public boolean isAnnotation() {
        return isAnnotation;
    }

    public boolean isEnum() {
        return isEnum;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (isPublic()) {
            stringBuffer.append("public ");
        }
        if (isAbstract()) {
            stringBuffer.append("abstract ");
        }
        if (isFinal()) {
            stringBuffer.append("final ");
        }
        if (isAnnotation()) {
            stringBuffer.append("annotation ");
        } else if (isInterface()) {
            stringBuffer.append("interface ");
        } else if (isEnum()) {
            stringBuffer.append("enum ");
        } else {
            stringBuffer.append("class ");
        }

        return stringBuffer.toString();
    }
}
