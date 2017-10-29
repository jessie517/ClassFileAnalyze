package com.analyze.basic.accessFlag.bean;

import com.analyze.basic.accessFlag.MethodAccessFlagAnalyze;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class MethodAccessBean {
    public static final int ACC_PUBLIC = 0X0001;
    public static final int ACC_PRIVATE = 0X0002;
    public static final int ACC_PROTECTED = 0X0004;
    public static final int ACC_STATIC = 0X0008;
    public static final int ACC_FINAL = 0X0010;
    public static final int ACC_SYNCHRONIZED = 0X0020;
    public static final int ACC_BRIDGE = 0X0040;
    public static final int ACC_VARARGS = 0X0080;
    public static final int ACC_NATIVE = 0X0100;
    public static final int ACC_ABSTRACT = 0X0400;
    public static final int ACC_STRICT = 0X0800;
    public static final int ACC_SYNTHETIC = 0X1000;
    
    private boolean isPublic;
    private boolean isPrivate;
    private boolean isProtected;
    private boolean isStatic;
    private boolean isFinal;
    private boolean isSynchronized;
    private boolean isBridge;
    private boolean isVarargs;
    private boolean isNative;
    private boolean isAbstract;
    private boolean isStrict;
    private boolean isSynthtic;

    public MethodAccessBean(byte[] b) {
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
        if ((accessFlag & ACC_SYNCHRONIZED) == ACC_SYNCHRONIZED) {
            this.isSynchronized = true;
        }
        if ((accessFlag & ACC_BRIDGE) == ACC_BRIDGE) {
            this.isBridge = true;
        }
        if ((accessFlag & ACC_VARARGS) == ACC_VARARGS) {
            this.isVarargs = true;
        }
        if ((accessFlag & ACC_NATIVE) == ACC_NATIVE) {
            this.isNative = true;
        }
        if ((accessFlag & ACC_ABSTRACT) == ACC_ABSTRACT) {
            this.isAbstract = true;
        }
        if ((accessFlag & ACC_STRICT) == ACC_STRICT) {
            this.isStrict = true;
        }
        if ((accessFlag & ACC_SYNTHETIC) == ACC_SYNTHETIC) {
            this.isSynthtic = true;
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

    public boolean isSynchronized() {
        return isSynchronized;
    }

    public boolean isBridge() {
        return isBridge;
    }

    public boolean isVarargs() {
        return isVarargs;
    }

    public boolean isNative() {
        return isNative;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public boolean isStrict() {
        return isStrict;
    }

    public boolean isSynthtic() {
        return isSynthtic;
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
        if(isSynchronized()){
            stringBuffer.append("synchronized ");
        }
        if(isNative()){
            stringBuffer.append("native ");
        }
        if(isStatic()){
            stringBuffer.append("static ");
        }
        if(isAbstract()){
            stringBuffer.append("abstract ");
        } else if (isFinal()) {
            stringBuffer.append("final ");
        }
        if(isVarargs()){
            stringBuffer.append("varargs ");
        }
        return stringBuffer.toString();
    }
}
