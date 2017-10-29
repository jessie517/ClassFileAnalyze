package com.code;

/**
 * Created by chenjiaxu on 2017/10/29.
 */
public class CodeToString {
    public static String[] codesToString(byte[] bytes) {
        String[] mnemonics = new String[bytes.length];
        for (int i = 0; i < mnemonics.length; i++) {
            String translateResult = CodeMnemonicMap.getCodeTranslate(bytes[i] & 0xFF);
            if(translateResult != null){
                mnemonics[i] = translateResult;
                i = i + CodeOperandMap.getOperandLength(bytes[i] & 0xFF);
            } else {
                mnemonics[i] = "未知指令";
            }
        }
        return mnemonics;
    }

}
