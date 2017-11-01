package com.analyze.attribute.bean;

import com.analyze.attribute.AnnotationsAnalyze;
import com.utils.UToNumeric;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenjiaxu on 2017/10/31.
 */
public class StackMapTableAttributeBean implements AttributeInfoBean {
    private StackMapFrame[] entries;

    public StackMapTableAttributeBean(byte[] infoBytes) throws Exception {
        int i = 0;
        int numberOfEntries = (infoBytes[i++] & 0xFF) << 8 | (infoBytes[i++] & 0xFF);
        byte[] entriesBytes = Arrays.copyOfRange(infoBytes, i, infoBytes.length);
        this.entries = getEntries(numberOfEntries, new ByteArrayInputStream(entriesBytes));
    }

    public StackMapFrame[] getEntries() {
        return entries;
    }

    public void setEntries(StackMapFrame[] entries) {
        this.entries = entries;
    }

    public static StackMapFrame[] getEntries(int numberOfEntries, InputStream in) throws Exception {
        byte[] u1 = new byte[1];
        byte[] u2 = new byte[2];
        StackMapFrame[] stackMapFrames = new StackMapFrame[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            StackMapFrame stackMapFrame = new StackMapFrame();
            in.read(u1);
            int type = UToNumeric.u1ToInt(u1);
            stackMapFrame.setFrameType(type);
            if (type <= 63) {
                // same_frame nothing need do
            } else if (type <= 127) {
                // same_locals_1_stack_item_frame
                VerificationTypeInfo[] stacks = new VerificationTypeInfo[]{getVerificationTypeInfo(in)};
                stackMapFrame.setStack(stacks);
            } else if (type <= 247) {
                // same_locals_1_stack_item_frame_extended
                in.read(u2);
                stackMapFrame.setOffsetDelta(UToNumeric.u2ToInt(u2));
                VerificationTypeInfo[] stacks = new VerificationTypeInfo[]{getVerificationTypeInfo(in)};
                stackMapFrame.setStack(stacks);
            } else if (type <= 250) {
                // chop_frame
                in.read(u2);
                stackMapFrame.setOffsetDelta(UToNumeric.u2ToInt(u2));
            } else if (type == 251) {
                // same_frame_extended
                in.read(u2);
                stackMapFrame.setOffsetDelta(UToNumeric.u2ToInt(u2));
            } else if (type <= 254) {
                // append_frame
                in.read(u2);
                stackMapFrame.setOffsetDelta(UToNumeric.u2ToInt(u2));
                VerificationTypeInfo[] locals = new VerificationTypeInfo[type - 251];
                for (int j = 0; j < type - 251; j++) {
                    locals[j] = getVerificationTypeInfo(in);
                }
                stackMapFrame.setLocals(locals);
            } else {
                // full_frame
                in.read(u2);
                stackMapFrame.setOffsetDelta(UToNumeric.u2ToInt(u2));
                in.read(u2);
                int numOfLocals = UToNumeric.u2ToInt(u2);
                VerificationTypeInfo[] locals = new VerificationTypeInfo[numOfLocals];
                for (int j = 0; j < numOfLocals; j++) {
                    locals[j] = getVerificationTypeInfo(in);
                }
                stackMapFrame.setLocals(locals);

                in.read(u2);
                int numOfStack = UToNumeric.u2ToInt(u2);
                VerificationTypeInfo[] stacks = new VerificationTypeInfo[numOfStack];
                for (int j = 0; j < numOfStack; j++) {
                    stacks[j] = getVerificationTypeInfo(in);
                }
                stackMapFrame.setStack(stacks);
            }
            stackMapFrames[i] = stackMapFrame;
        }

        return stackMapFrames;
    }

    public static VerificationTypeInfo getVerificationTypeInfo(InputStream in) throws Exception {
        VerificationTypeInfo verificationTypeInfo = new VerificationTypeInfo();
        byte[] u1 = new byte[1];
        byte[] u2 = new byte[2];
        in.read(u1);
        int tag = UToNumeric.u1ToInt(u1);
        verificationTypeInfo.setTag(tag);
        if (tag == 0) {
            // ITEM_TOP
        } else if (tag == 1) {
            // ITEM_Integer
        } else if (tag == 2) {
            // ITEM_Float
        } else if (tag == 4) {
            // ITEM_Long
        } else if (tag == 5) {
            // ITEM_Double
        } else if (tag == 6) {
            // ITEM_UninitializedThis
        } else if (tag == 7) {
            // ITEM_Object
            in.read(u2);
            verificationTypeInfo.setCpoolIndex(UToNumeric.u2ToInt(u2));
        } else if (tag == 8) {
            // ITEM_Uninitialized
            in.read(u2);
            verificationTypeInfo.setOffset(UToNumeric.u2ToInt(u2));
        }
        return verificationTypeInfo;
    }

    public static class StackMapFrame {
        private int frameType;
        private int offsetDelta;
        private VerificationTypeInfo[] locals;
        private VerificationTypeInfo[] stack;

        public int getFrameType() {
            return frameType;
        }

        public void setFrameType(int frameType) {
            this.frameType = frameType;
        }

        public int getOffsetDelta() {
            return offsetDelta;
        }

        public void setOffsetDelta(int offsetDelta) {
            this.offsetDelta = offsetDelta;
        }

        public VerificationTypeInfo[] getLocals() {
            return locals;
        }

        public void setLocals(VerificationTypeInfo[] locals) {
            this.locals = locals;
        }

        public VerificationTypeInfo[] getStack() {
            return stack;
        }

        public void setStack(VerificationTypeInfo[] stack) {
            this.stack = stack;
        }
    }

    static class VerificationTypeInfo {
        private int tag;
        private int cpoolIndex;
        private int offset;

        public int getTag() {
            return tag;
        }

        public void setTag(int tag) {
            this.tag = tag;
        }

        public int getCpoolIndex() {
            return cpoolIndex;
        }

        public void setCpoolIndex(int cpoolIndex) {
            this.cpoolIndex = cpoolIndex;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        //        union verification_type_info {
//            Top_variable_info;
//            Integer_variable_info;
//            Float_variable_info;
//            Long_variable_info;
//            Double_variable_info;
//            Null_variable_info;
//            UninitializedThis_variable_info;
//            Object_variable_info;
//            Uninitialized_variable_info;
//        }
    }
}
