package com.analyze.attribute.bean;

import com.analyze.attribute.CodeAttributeAnalyze;
import com.analyze.constant.bean.ConstBean;
import com.code.CodeToString;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class CodeAttributeBean implements AttributeInfoBean {
    private int maxStack;
    private int maxLocals;
    private byte[] code;
    private ExceptionInfoBean[] exceptionTable;
    private Map<String, AttributeInfoBean> attributeInfoBeanMap;
    public static final int EXCEPTION_INFO_BYTE_LENGTH = 8;

    public CodeAttributeBean(byte[] infoBytes, ConstBean[] constBeans) throws Exception {
        int i = 0;
        this.maxStack = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        this.maxLocals = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);

        int codeLength = (infoBytes[i++] & 0xFF) << 24 | (infoBytes[i++] & 0xFF) << 16 | (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        this.code = Arrays.copyOfRange(infoBytes, i, (i = i + codeLength));

        int exceptionTableLength = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        byte[] exceptionTableBytes = Arrays.copyOfRange(infoBytes, i, (i = i + exceptionTableLength * EXCEPTION_INFO_BYTE_LENGTH));
        this.exceptionTable = getExceptionTable(exceptionTableBytes);

        byte[] attributeBytes = Arrays.copyOfRange(infoBytes, i, infoBytes.length);
        this.attributeInfoBeanMap = new CodeAttributeAnalyze().getAttributeInfoBeans(new ByteArrayInputStream(attributeBytes), constBeans);
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

    public Map<String, AttributeInfoBean> getAttributeInfoBeanMap() {
        return attributeInfoBeanMap;
    }

    public void setAttributeInfoBeanMap(Map<String, AttributeInfoBean> attributeInfoBeanMap) {
        this.attributeInfoBeanMap = attributeInfoBeanMap;
    }

    public String toString(ConstBean[] constBeans) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] code = this.getCode();
        stringBuffer.append("maxStack: " + maxStack + ", maxLocals: " + maxLocals + "\n");
        stringBuffer.append("code: " + Arrays.toString(CodeToString.codesToString(code)) + "\n");
        stringBuffer.append("exceptionTable: " + "\n");
        for (int i = 0; i < exceptionTable.length; i++) {
            stringBuffer.append("\t" + exceptionTable[i].toString() + "\n");
        }
        stringBuffer.append("attributes: " + "\n");
        Set<Map.Entry<String, AttributeInfoBean>> entries = attributeInfoBeanMap.entrySet();
        for (Map.Entry<String, AttributeInfoBean> entry : entries) {
            stringBuffer.append("\t" + entry.getKey() + ":" + entry.getValue().toString(constBeans) + "\n");
        }

        return stringBuffer.toString();
    }

    public static ExceptionInfoBean[] getExceptionTable(byte[] exceptionTableBytes) throws Exception {
        int exceptionTableLength = exceptionTableBytes.length / EXCEPTION_INFO_BYTE_LENGTH;
        ExceptionInfoBean[] exceptionInfoBeanTable = new ExceptionInfoBean[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            ExceptionInfoBean exceptionInfoBean = new ExceptionInfoBean();
            exceptionInfoBean.setStartPc((exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH] & 0xFF) << 8 | (exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 1] & 0xFF));
            exceptionInfoBean.setEndPc((exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 2] & 0xFF) << 8 | (exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 3] & 0xFF));
            exceptionInfoBean.setHandlerPc((exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 4] & 0xFF) << 8 | (exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 5] & 0xFF));
            exceptionInfoBean.setCatchType((exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 6] & 0xFF) << 8 | (exceptionTableBytes[i * EXCEPTION_INFO_BYTE_LENGTH + 7] & 0xFF));
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

        public String toString() {
            return "startPc: " + getStartPc() + "; endPc: " + getEndPc() + "; handlerPc: " + handlerPc + "; catchType: " + catchType;
        }
    }
}
