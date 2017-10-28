package com.analyze.accessFlag.bean;

import com.analyze.accessFlag.ClassAccessFlagAnalyze;

/**
 * Created by chenjiaxu on 2017/10/27.
 */
public class ClassAccessBean {
    private boolean isPublic;
    private boolean isFinal;
    private boolean isSuper;

    private boolean isInterface;
    private boolean isAbstract;

    private boolean isSynthtic;
    private boolean isAnnotation;
    private boolean isEnum;

    public ClassAccessBean(byte[] b) {
        int accessFlag = b[0] << 8 | b[1];
        if ((accessFlag & ClassAccessFlagAnalyze.ACC_PUBLIC) == ClassAccessFlagAnalyze.ACC_PUBLIC) {
            this.isPublic = true;
        }
        if ((accessFlag & ClassAccessFlagAnalyze.ACC_FINAL) == ClassAccessFlagAnalyze.ACC_FINAL) {
            this.isFinal = true;
        }
        if ((accessFlag & ClassAccessFlagAnalyze.ACC_SUPER) == ClassAccessFlagAnalyze.ACC_SUPER) {
            this.isSuper = true;
        }
        if ((accessFlag & ClassAccessFlagAnalyze.ACC_INTERFACE) == ClassAccessFlagAnalyze.ACC_INTERFACE) {
            this.isInterface = true;
        }
        if ((accessFlag & ClassAccessFlagAnalyze.ACC_ABSTRACT) == ClassAccessFlagAnalyze.ACC_ABSTRACT) {
            this.isAbstract = true;
        }
        if ((accessFlag & ClassAccessFlagAnalyze.ACC_SYNTHETIC) == ClassAccessFlagAnalyze.ACC_SYNTHETIC) {
            this.isSynthtic = true;
        }
        if ((accessFlag & ClassAccessFlagAnalyze.ACC_ANNOTATION) == ClassAccessFlagAnalyze.ACC_ANNOTATION) {
            this.isAnnotation = true;
        }
        if ((accessFlag & ClassAccessFlagAnalyze.ACC_ENUM) == ClassAccessFlagAnalyze.ACC_ENUM) {
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

}
