package com.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenjiaxu on 2017/10/29.
 */
public class CodeOperandMap {
    // key-字节码指令，value-指令所需操作数占用字节数
    private static Map<Integer, Integer> codeOperandMap = new HashMap<Integer, Integer>();

    static {
        codeOperandMap.put(0x10, 1);
        codeOperandMap.put(0x11, 2);
        codeOperandMap.put(0x12, 1);
        codeOperandMap.put(0x13, 2);
        codeOperandMap.put(0x14, 2);
        codeOperandMap.put(0x15, 1);
        codeOperandMap.put(0x16, 1);
        codeOperandMap.put(0x17, 1);
        codeOperandMap.put(0x18, 1);
        codeOperandMap.put(0x19, 1);
        codeOperandMap.put(0x36, 1);
        codeOperandMap.put(0x37, 1);
        codeOperandMap.put(0x38, 1);
        codeOperandMap.put(0x39, 1);
        codeOperandMap.put(0x3a, 1);
        codeOperandMap.put(0x84, 2);
        codeOperandMap.put(0x99, 2);
        codeOperandMap.put(0x9a, 2);
        codeOperandMap.put(0x9b, 2);
        codeOperandMap.put(0x9c, 2);
        codeOperandMap.put(0x9d, 2);
        codeOperandMap.put(0x9e, 2);
        codeOperandMap.put(0x9f, 2);
        codeOperandMap.put(0xa0, 2);
        codeOperandMap.put(0xa1, 2);
        codeOperandMap.put(0xa2, 2);
        codeOperandMap.put(0xa3, 2);
        codeOperandMap.put(0xa4, 2);
        codeOperandMap.put(0xa5, 2);
        codeOperandMap.put(0xa6, 2);
        codeOperandMap.put(0xc6, 2);
        codeOperandMap.put(0xc7, 2);
        codeOperandMap.put(0xa7, 2);
        codeOperandMap.put(0xa8, 2);
        codeOperandMap.put(0xc8, 4);
        codeOperandMap.put(0xc9, 4);
        codeOperandMap.put(0xa9, 1);
        codeOperandMap.put(0xbb, 2);
        codeOperandMap.put(0xc0, 2);
        codeOperandMap.put(0xc1, 2);
        codeOperandMap.put(0xb4, 2);
        codeOperandMap.put(0xb5, 2);
        codeOperandMap.put(0xb2, 2);
        codeOperandMap.put(0xb3, 2);
        codeOperandMap.put(0xbc, 1);
        codeOperandMap.put(0xbd, 2);
        codeOperandMap.put(0xc5, 3);
        codeOperandMap.put(0xb6, 2);
        codeOperandMap.put(0xb7, 2);
        codeOperandMap.put(0xb8, 2);
        codeOperandMap.put(0xb9, 4);
        //TODO tableswitch 和 lookupswitch 待处理
        codeOperandMap.put(0xaa, 0);
        codeOperandMap.put(0xab, 0);
    }

    public static int getOperandLength(int code) {
        if (codeOperandMap.containsKey(code)) {
            return codeOperandMap.get(code);
        } else {
            return 0;
        }

    }
}
