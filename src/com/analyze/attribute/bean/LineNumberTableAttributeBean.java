package com.analyze.attribute.bean;

import java.util.Arrays;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class LineNumberTableAttributeBean extends AttributeInfoBean {
    private LineNumberInfo[] lineNumberInfoTable;

    public LineNumberTableAttributeBean(byte[] infoBytes) {
        int i = 0;
        int lineNumberTableLength = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        this.lineNumberInfoTable = getLineNumberInfoTable(infoBytes, lineNumberTableLength, i);
    }

    public static LineNumberInfo[] getLineNumberInfoTable(byte[] infoBytes, int tableLegth, int currentIndex) {
        LineNumberInfo[] lineNumberInfoTable = new LineNumberInfo[tableLegth];
        for (int i = 0; i < tableLegth; i++) {
            LineNumberInfo lineNumberInfo = new LineNumberInfo();
            lineNumberInfo.setStartPc((infoBytes[currentIndex++] & 0xFF) << 8 | (infoBytes[currentIndex++] & 0xFF));
            lineNumberInfo.setLineNumber((infoBytes[currentIndex++] & 0xFF) << 8 | (infoBytes[currentIndex++] & 0xFF));
            lineNumberInfoTable[i] = lineNumberInfo;
        }
        return lineNumberInfoTable;
    }

    static class LineNumberInfo {
        private int startPc;
        private int lineNumber;

        public int getStartPc() {
            return startPc;
        }

        public void setStartPc(int startPc) {
            this.startPc = startPc;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(int lineNumber) {
            this.lineNumber = lineNumber;
        }
    }
}
