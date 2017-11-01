package com.analyze.attribute.bean;

import com.analyze.constant.bean.ConstBean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class LocalVariableTypeTableAttributeBean implements AttributeInfoBean {

    private LocalVariableTypeInfo[] localVariableTypeTable;

    public LocalVariableTypeTableAttributeBean(byte[] infoBytes) {
        int localVariableTableLength = (infoBytes[0] & 0xFF) << 8 | (infoBytes[1] & 0xFF);
        this.localVariableTypeTable = getLocalVariableTypeTable(infoBytes, localVariableTableLength, 2);
    }

    public static LocalVariableTypeInfo[] getLocalVariableTypeTable(byte[] infoBytes, int tableLegth, int currentIndex) {
        LocalVariableTypeInfo[] localVariableTable = new LocalVariableTypeInfo[tableLegth];
        for (int i = 0; i < tableLegth; i++) {
            LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo();
            localVariableTypeInfo.setStartPc((infoBytes[currentIndex++] & 0xFF) << 8 | (infoBytes[currentIndex++] & 0xFF));
            localVariableTypeInfo.setLength((infoBytes[currentIndex++] & 0xFF) << 8 | (infoBytes[currentIndex++] & 0xFF));
            localVariableTypeInfo.setNameIndex((infoBytes[currentIndex++] & 0xFF) << 8 | (infoBytes[currentIndex++] & 0xFF));
            localVariableTypeInfo.setSignatureIndex((infoBytes[currentIndex++] & 0xFF) << 8 | (infoBytes[currentIndex++] & 0xFF));
            localVariableTypeInfo.setIndex((infoBytes[currentIndex++] & 0xFF) << 8 | (infoBytes[currentIndex++] & 0xFF));

            localVariableTable[i] = localVariableTypeInfo;
        }
        return localVariableTable;
    }

    public String toString(ConstBean[] constBeans) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < localVariableTypeTable.length; i++) {
            stringBuffer.append(localVariableTypeTable[i].toString(constBeans) + "\n");
        }
        return stringBuffer.toString();
    }

    static class LocalVariableTypeInfo {
        private int startPc;
        private int length;
        private int nameIndex;
        private int signatureIndex;
        private int index;

        public int getStartPc() {
            return startPc;
        }

        public void setStartPc(int startPc) {
            this.startPc = startPc;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getNameIndex() {
            return nameIndex;
        }

        public void setNameIndex(int nameIndex) {
            this.nameIndex = nameIndex;
        }

        public int getSignatureIndex() {
            return signatureIndex;
        }

        public void setSignatureIndex(int signatureIndex) {
            this.signatureIndex = signatureIndex;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String toString(ConstBean[] constBeans) {
            return "startPc: " + startPc + ", length: " + length + ", name: " + constBeans[nameIndex].getValue()
                    + ", signature: " + constBeans[signatureIndex].getValue() + ", index: " + index;
        }
    }
}
