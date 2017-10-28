package com.analyze.attribute.bean;

import com.analyze.attribute.AttributeAnalyze;
import com.analyze.constant.bean.ConstBean;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class CodeAttributeBean extends AttributeInfoBean {
    private int maxStack;
    private int maxLocals;
    private byte[] code;
    private ExceptionInfoBean[] exceptionTable;
    private AttributeInfoBean[] attributeInfoBeans;
    public static final int EXCEPTION_INFO_BYTE_LENGTH = 8;

    public CodeAttributeBean(byte[] infoBytes, ConstBean[] constBeans) throws Exception {
        int i = 0;
        this.maxStack = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        this.maxLocals = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);

        //TODO
        int codeLength = (infoBytes[i++] & 0xFF) << 24 | (infoBytes[i++] & 0xFF) << 16 | (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        this.code = Arrays.copyOfRange(infoBytes, i, (i = i + codeLength));

        int exceptionTableLength = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        byte[] exceptionTableBytes = Arrays.copyOfRange(infoBytes, i, (i = i + exceptionTableLength * EXCEPTION_INFO_BYTE_LENGTH));
        this.exceptionTable = getExceptionTable(exceptionTableBytes);

        byte[] attributeBytes = Arrays.copyOfRange(infoBytes, i, infoBytes.length);
        this.attributeInfoBeans = new AttributeAnalyze().getAttributeInfoBeans(new ByteArrayInputStream(attributeBytes), constBeans);
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public ExceptionInfoBean[] getExceptionTable() {
        return exceptionTable;
    }

    public void setExceptionTable(ExceptionInfoBean[] exceptionTable) {
        this.exceptionTable = exceptionTable;
    }

    public AttributeInfoBean[] getAttributeInfoBeans() {
        return attributeInfoBeans;
    }

    public void setAttributeInfoBeans(AttributeInfoBean[] attributeInfoBeans) {
        this.attributeInfoBeans = attributeInfoBeans;
    }

    public static ExceptionInfoBean[] getExceptionTable(byte[] exceptionTableBytes) throws Exception {
        int exceptionTableLength = exceptionTableBytes.length / EXCEPTION_INFO_BYTE_LENGTH;
        ExceptionInfoBean[] exceptionInfoBeanTable = new ExceptionInfoBean[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            ExceptionInfoBean exceptionInfoBean = new ExceptionInfoBean();
            exceptionInfoBean.setStartPc((exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH] & 0xFF) << 8 | (exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 1] & 0xFF) );
            exceptionInfoBean.setEndPc((exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 2] & 0xFF)  << 8 | (exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 3] & 0xFF) );
            exceptionInfoBean.setHandlerPc((exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 4] & 0xFF)  << 8 | (exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 5] & 0xFF) );
            exceptionInfoBean.setCatchType((exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 6] & 0xFF)  << 8 | (exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 7] & 0xFF) );
            exceptionInfoBeanTable[i] = exceptionInfoBean;
        }
        return exceptionInfoBeanTable;
    }

    static class ExceptionInfoBean {
        private int startPc;
        private int endPc;
        private int handlerPc;
        private int catchType;

        public int getStartPc() {
            return startPc;
        }

        public void setStartPc(int startPc) {
            this.startPc = startPc;
        }

        public int getEndPc() {
            return endPc;
        }

        public void setEndPc(int endPc) {
            this.endPc = endPc;
        }

        public int getHandlerPc() {
            return handlerPc;
        }

        public void setHandlerPc(int handlerPc) {
            this.handlerPc = handlerPc;
        }

        public int getCatchType() {
            return catchType;
        }

        public void setCatchType(int catchType) {
            this.catchType = catchType;
        }
    }
}
