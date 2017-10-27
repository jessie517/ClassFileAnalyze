package com.analyze.accessFlag.bean;

import com.analyze.accessFlag.FieldAccessFlagAnalyze;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class FieldAccessBean {

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
        int accessFlag = b[0] << 8 | b[1];
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_PUBLIC) == FieldAccessFlagAnalyze.ACC_PUBLIC) {
            this.isPublic = true;
        }
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_PRIVATE) == FieldAccessFlagAnalyze.ACC_PRIVATE) {
            this.isPrivate = true;
        }
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_PROTECTED) == FieldAccessFlagAnalyze.ACC_PROTECTED) {
            this.isProtected = true;
        }
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_STATIC) == FieldAccessFlagAnalyze.ACC_STATIC) {
            this.isStatic = true;
        }
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_FINAL) == FieldAccessFlagAnalyze.ACC_FINAL) {
            this.isFinal = true;
        }
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_VOLATILE) == FieldAccessFlagAnalyze.ACC_VOLATILE) {
            this.isVolatile = true;
        }
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_TRANSIENT) == FieldAccessFlagAnalyze.ACC_TRANSIENT) {
            this.isTransient = true;
        }
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_SYNTHETIC) == FieldAccessFlagAnalyze.ACC_SYNTHETIC) {
            this.isSynthtic = true;
        }
        if ((accessFlag & FieldAccessFlagAnalyze.ACC_ENUM) == FieldAccessFlagAnalyze.ACC_ENUM) {
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
}
