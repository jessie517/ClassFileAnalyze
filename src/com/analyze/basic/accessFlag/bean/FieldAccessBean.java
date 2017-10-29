package com.analyze.basic.accessFlag.bean;

import com.analyze.basic.accessFlag.FieldAccessFlagAnalyze;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class FieldAccessBean {
    public static final int ACC_PUBLIC = 0X0001;
    public static final int ACC_PRIVATE = 0X0002;
    public static final int ACC_PROTECTED = 0X0004;
    public static final int ACC_STATIC = 0X0008;
    public static final int ACC_FINAL = 0X0010;
    public static final int ACC_VOLATILE = 0X0040;
    public static final int ACC_TRANSIENT = 0X0080;
    public static final int ACC_SYNTHETIC = 0X1000;
    public static final int ACC_ENUM = 0X4000;
    
    private boolean isPublic;
    private boolean isPrivate;
    private boolean isProtected;
    private boolean isStatic;
    private boolean isFinal;
    private boolean isVolatile;
    private boolean isTransient;
    private boolean isSynthtic;
    private boolean isEnum;

    public FieldAccessBean(byte[] b) {
        int accessFlag = (b[0] & 0xFF) << 8 | (b[1] & 0xFF);
        if ((accessFlag & ACC_PUBLIC) == ACC_PUBLIC) {
            this.isPublic = true;
        }
        if ((accessFlag & ACC_PRIVATE) == ACC_PRIVATE) {
            this.isPrivate = true;
        }
        if ((accessFlag & ACC_PROTECTED) == ACC_PROTECTED) {
            this.isProtected = true;
        }
        if ((accessFlag & ACC_STATIC) == ACC_STATIC) {
            this.isStatic = true;
        }
        if ((accessFlag & ACC_FINAL) == ACC_FINAL) {
            this.isFinal = true;
        }
        if ((accessFlag & ACC_VOLATILE) == ACC_VOLATILE) {
            this.isVolatile = true;
        }
        if ((accessFlag & ACC_TRANSIENT) == ACC_TRANSIENT) {
            this.isTransient = true;
        }
        if ((accessFlag & ACC_SYNTHETIC) == ACC_SYNTHETIC) {
            this.isSynthtic = true;
        }
        if ((accessFlag & ACC_ENUM) == ACC_ENUM) {
            this.isEnum = true;
        }
    }

    public boolean isPublic() {
        return isPublic;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public boolean isVolatile() {
        return isVolatile;
    }

    public boolean isTransient() {
        return isTransient;
    }

    public boolean isSynthtic() {
        return isSynthtic;
    }

    public boolean isEnum() {
        return isEnum;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (isPublic()) {
            stringBuffer.append("public ");
        } else if (isPrivate()){
            stringBuffer.append("private ");
        } else if (isProtected()){
            stringBuffer.append("protected ");
        }
        if(isStatic()){
            stringBuffer.append("static ");
        }
        if (isFinal()) {
            stringBuffer.append("final ");
        }
        if (isVolatile()) {
            stringBuffer.append("volatile ");
        }
        if (isTransient()) {
            stringBuffer.append("transient ");
        }
        if (isEnum()) {
            stringBuffer.append("enum ");
        }

        return stringBuffer.toString();
    }
}
