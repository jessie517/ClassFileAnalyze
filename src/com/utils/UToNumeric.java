package com.utils;

import java.nio.ByteBuffer;

/**
 * Created by chenjiaxu on 2017/10/23.
 */
public class UToNumeric {
    public static int u4ToInt(byte[] b) {
        int temp = (b[3] & 0xFF) | (b[2] & 0xFF) << 8 | (b[1] & 0xFF) << 16 | (b[0] & 0xFF) << 24;
        return temp;
    }

    public static float u4ToFloat(byte[] b) {
        int temp = u4ToInt(b);
        return Float.intBitsToFloat(temp);
    }

    public static long u8ToLong(byte[] b) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.put(b);
        byteBuffer.flip();
        return byteBuffer.getLong();
    }

    public static double u8ToDouble(byte[] b){
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.put(b);
        byteBuffer.flip();
        return byteBuffer.getDouble();
    }

    public static int u2ToInt(byte[] b) {
        int temp = (b[1] & 0xFF) | (b[0] & 0xFF) << 8;
        return temp;
    }

    public static int u1ToInt(byte[] b) {
        int temp = b[0] & 0xFF;
        return temp;
    }
}
