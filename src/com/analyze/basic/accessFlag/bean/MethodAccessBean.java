package com.analyze.basic.accessFlag.bean;

import com.analyze.basic.accessFlag.MethodAccessFlagAnalyze;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class MethodAccessBean {

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
        int accessFlag = b[0] << 8 | b[1];
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_PUBLIC) == MethodAccessFlagAnalyze.ACC_PUBLIC) {
            this.isPublic = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_PRIVATE) == MethodAccessFlagAnalyze.ACC_PRIVATE) {
            this.isPrivate = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_PROTECTED) == MethodAccessFlagAnalyze.ACC_PROTECTED) {
            this.isProtected = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_STATIC) == MethodAccessFlagAnalyze.ACC_STATIC) {
            this.isStatic = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_FINAL) == MethodAccessFlagAnalyze.ACC_FINAL) {
            this.isFinal = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_SYNCHRONIZED) == MethodAccessFlagAnalyze.ACC_SYNCHRONIZED) {
            this.isSynchronized = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_BRIDGE) == MethodAccessFlagAnalyze.ACC_BRIDGE) {
            this.isBridge = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_VARARGS) == MethodAccessFlagAnalyze.ACC_VARARGS) {
            this.isVarargs = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_NATIVE) == MethodAccessFlagAnalyze.ACC_NATIVE) {
            this.isNative = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_ABSTRACT) == MethodAccessFlagAnalyze.ACC_ABSTRACT) {
            this.isAbstract = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_STRICT) == MethodAccessFlagAnalyze.ACC_STRICT) {
            this.isStrict = true;
        }
        if ((accessFlag & MethodAccessFlagAnalyze.ACC_SYNTHETIC) == MethodAccessFlagAnalyze.ACC_SYNTHETIC) {
            this.isSynthtic = true;
        }
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public boolean isSynchronized() {
        return isSynchronized;
    }

    public void setSynchronized(boolean aSynchronized) {
        isSynchronized = aSynchronized;
    }

    public boolean isBridge() {
        return isBridge;
    }

    public void setBridge(boolean bridge) {
        isBridge = bridge;
    }

    public boolean isVarargs() {
        return isVarargs;
    }

    public void setVarargs(boolean varargs) {
        isVarargs = varargs;
    }

    public boolean isNative() {
        return isNative;
    }

    public void setNative(boolean aNative) {
        isNative = aNative;
    }

    public boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(boolean anAbstract) {
        isAbstract = anAbstract;
    }

    public boolean isStrict() {
        return isStrict;
    }

    public void setStrict(boolean strict) {
        isStrict = strict;
    }

    public boolean isSynthtic() {
        return isSynthtic;
    }

    public void setSynthtic(boolean synthtic) {
        isSynthtic = synthtic;
    }
}
