package com.analyze.attribute.bean;

import com.analyze.basic.accessFlag.bean.InnerClassAccessBean;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class InnerClassesAttributeBean extends AttributeInfoBean {
    private InnerClassesInfo[] innerClassesInfoTable;

    public InnerClassesAttributeBean(byte[] infoBytes) {
        int tableLength = (infoBytes[0] & 0xFF) << 8 | (infoBytes[1] & 0xFF);
        getInnerClassesInfoTable(infoBytes, tableLength, 2);
    }

    public static InnerClassesInfo[] getInnerClassesInfoTable(byte[] infoBytes, int tableLegth, int currentIndex) {
        InnerClassesInfo[] innerClassesInfoTable = new InnerClassesInfo[tableLegth];
        for (int i = 0; i < tableLegth; i++) {
            InnerClassesInfo innerClassesInfo = new InnerClassesInfo();
            innerClassesInfo.setInnerClassInfoIndex((infoBytes[currentIndex++] & 0xFF)  << 8 | (infoBytes[currentIndex++] & 0xFF) );
            innerClassesInfo.setOuterClassInfoIndex((infoBytes[currentIndex++] & 0xFF)  << 8 | (infoBytes[currentIndex++] & 0xFF) );
            innerClassesInfo.setInnerNameIndex((infoBytes[currentIndex++] & 0xFF)  << 8 | (infoBytes[currentIndex++] & 0xFF) );
            innerClassesInfo.setInnerClassAccessBean(new InnerClassAccessBean((infoBytes[currentIndex++] & 0xFF)  << 8 | (infoBytes[currentIndex++] & 0xFF) ));

            innerClassesInfoTable[i] = innerClassesInfo;
        }
        return innerClassesInfoTable;
    }

    static class InnerClassesInfo {
        private int innerClassInfoIndex;
        private int outerClassInfoIndex;
        private int innerNameIndex;
        private InnerClassAccessBean innerClassAccessBean;

        public int getInnerClassInfoIndex() {
            return innerClassInfoIndex;
        }

        public void setInnerClassInfoIndex(int innerClassInfoIndex) {
            this.innerClassInfoIndex = innerClassInfoIndex;
        }

        public int getOuterClassInfoIndex() {
            return outerClassInfoIndex;
        }

        public void setOuterClassInfoIndex(int outerClassInfoIndex) {
            this.outerClassInfoIndex = outerClassInfoIndex;
        }

        public int getInnerNameIndex() {
            return innerNameIndex;
        }

        public void setInnerNameIndex(int innerNameIndex) {
            this.innerNameIndex = innerNameIndex;
        }

        public InnerClassAccessBean getInnerClassAccessBean() {
            return innerClassAccessBean;
        }

        public void setInnerClassAccessBean(InnerClassAccessBean innerClassAccessBean) {
            this.innerClassAccessBean = innerClassAccessBean;
        }
    }

}
