package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
    private byte[] u2 = new byte[2];
    private byte[] u4 = new byte[4];
    private byte[] u8 = new byte[8];

    public int setConst(int i, int type, InputStream in, Object[] consts) throws IOException {
        Map<String, Object> constMap = new HashMap<String, Object>();
        constMap.put("type", type);
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

        constMap.put("value", value);
        consts[i] = constMap;
        return newI;
    }

}
