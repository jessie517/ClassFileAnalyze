package com.analyze.basic.accessFlag.bean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class InnerClassAccessBean {
    public static final int ACC_PUBLIC = 0X0001;
    public static final int ACC_PRIVATE = 0X0002;
    public static final int ACC_PROTECTED = 0X0004;
    public static final int ACC_STATIC = 0X0008;
    public static final int ACC_FINAL = 0X0010;
    public static final int ACC_INTERFACE = 0X0200;
    public static final int ACC_ABSTRACT = 0X0400;
    public static final int ACC_SYNTHETIC = 0X1000;
    public static final int ACC_ANNOTATION = 0X2000;
    public static final int ACC_ENUM = 0X4000;

    private boolean isPublic;
    private boolean isPrivate;
    private boolean isProtected;
    private boolean isStatic;
    private boolean isFinal;

    private boolean isInterface;
    private boolean isAbstract;

    private boolean isSynthtic;
    private boolean isAnnotation;
    private boolean isEnum;

    public InnerClassAccessBean(int accessFlag) {
        if ((accessFlag & ACC_PUBLIC) == ACC_PUBLIC) {
            this.isPublic = true;
        }
        if ((accessFlag & ACC_FINAL) == ACC_FINAL) {
            this.isFinal = true;
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

    public InnerClassAccessBean(byte[] b) {
        this((b[0] & 0xFF) << 8 | (b[1] & 0xFF));
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
}
