package com.analyze.constant;

import com.analyze.constant.bean.ConstBean;
import com.utils.UToNumeric;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenjiaxu on 2017/10/23.
 */
public class ConstAnalyze {
    private static final int CONSTANT_Utf8_info = 1;
    private static final int CONSTANT_Integer_info = 3;
    private static final int CONSTANT_Float_info = 4;
    private static final int CONSTANT_Long_info = 5;
    private static final int CONSTANT_Double_info = 6;
    private static final int CONSTANT_Class_info = 7;
    private static final int CONSTANT_String_info = 8;
    private static final int CONSTANT_Fieldref_info = 9;
    private static final int CONSTANT_Methodref_info = 10;
    private static final int CONSTANT_InterfaceMethodref_info = 11;
    private static final int CONSTANT_NameAndType_info = 12;
    private byte[] u1 = new byte[1];
    private byte[] u2 = new byte[2];
    private byte[] u4 = new byte[4];
    private byte[] u8 = new byte[8];

    public ConstBean[] getConstBeans(InputStream in) throws Exception {
        //常量池长度
        in.read(u2);
        int constCount = UToNumeric.u2ToInt(u2);

        ConstBean[] constBeans = new ConstBean[constCount];
        for(int i = 1; i < constCount; i++){
            in.read(u1);
            int type = UToNumeric.u1ToInt(u1);
            i = this.setConst(i, type, in, constBeans);
        }

        return constBeans;
    }

    private int setConst(int i, int type, InputStream in, Object[] consts) throws Exception {
        ConstBean constBean = new ConstBean();
        constBean.setType(type);
        Object value = null;
        int newI = i;
        switch (type) {
            case CONSTANT_Utf8_info: {
                in.read(u2);
                int length = UToNumeric.u2ToInt(u2);
                byte[] utf8Bytes = new byte[length];
                in.read(utf8Bytes);
                value = new String(utf8Bytes, "utf-8");
                break;
            }
            case CONSTANT_Integer_info: {
                in.read(u4);
                value = UToNumeric.u4ToInt(u4);
                break;
            }
            case CONSTANT_Float_info: {
                in.read(u4);
                value = UToNumeric.u4ToFloat(u4);
                break;
            }
            case CONSTANT_Long_info: {
                in.read(u8);
                value = UToNumeric.u8ToLong(u8);
                newI = i+1;
                break;
            }
            case CONSTANT_Double_info: {
                in.read(u8);
                value = UToNumeric.u8ToDouble(u8);
                newI = i+1;
                break;
            }
            case CONSTANT_Class_info:
            case CONSTANT_String_info: {
                in.read(u2);
                int index = UToNumeric.u2ToInt(u2);
                value = new int[]{index};
                break;
            }
            case CONSTANT_Fieldref_info:
            case CONSTANT_Methodref_info:
            case CONSTANT_InterfaceMethodref_info:
            case CONSTANT_NameAndType_info: {
                in.read(u2);
                int firstIndex = UToNumeric.u2ToInt(u2);
                in.read(u2);
                int secondIndex = UToNumeric.u2ToInt(u2);
                value = new int[]{firstIndex, secondIndex};
                break;
            }
            default: {
                break;
            }
        }

        constBean.setValue(value);
        consts[i] = constBean;
        return newI;
    }

}
