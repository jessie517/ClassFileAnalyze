package com.analyze.attribute.bean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class LocalVariableTableAttributeBean extends AttributeInfoBean {

    private LocalVariableInfo[] localVariableTable;

    public LocalVariableTableAttributeBean(byte[] infoBytes) {
        int localVariableTableLength = infoBytes[0] << 8 | infoBytes[1];
        this.localVariableTable = getLocalVariableTable(infoBytes, localVariableTableLength, 2);
    }

    public static LocalVariableInfo[] getLocalVariableTable(byte[] infoBytes, int tableLegth, int currentIndex) {
        LocalVariableInfo[] localVariableTable = new LocalVariableInfo[tableLegth];
        for (int i = 0; i < tableLegth; i++) {
            LocalVariableInfo localVariableInfo = new LocalVariableInfo();
            localVariableInfo.setStartPc(infoBytes[currentIndex++] << 8 | infoBytes[currentIndex++]);
            localVariableInfo.setLength(infoBytes[currentIndex++] << 8 | infoBytes[currentIndex++]);
            localVariableInfo.setNameIndex(infoBytes[currentIndex++] << 8 | infoBytes[currentIndex++]);
            localVariableInfo.setDescriptorIndex(infoBytes[currentIndex++] << 8 | infoBytes[currentIndex++]);
            localVariableInfo.setIndex(infoBytes[currentIndex++] << 8 | infoBytes[currentIndex++]);

            localVariableTable[i] = localVariableInfo;
        }
        return localVariableTable;
    }

    static class LocalVariableInfo {
        private int startPc;
        private int length;
        private int nameIndex;
        private int descriptorIndex;
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

        public int getDescriptorIndex() {
            return descriptorIndex;
        }

        public void setDescriptorIndex(int descriptorIndex) {
            this.descriptorIndex = descriptorIndex;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}