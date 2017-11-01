package com.utils;

import java.nio.ByteBuffer;

/**
 * Created by chenjiaxu on 2017/10/23.
 */
public class UToNumeric {
    public static int u4ToInt(byte[] u4) {
        int temp = (u4[3] & 0xFF) | (u4[2] & 0xFF) << 8 | (u4[1] & 0xFF) << 16 | (u4[0] & 0xFF) << 24;
        return temp;
    }

    public static float u4ToFloat(byte[] u4) {
        int temp = u4ToInt(u4);
        return Float.intBitsToFloat(temp);
    }

    public static long u8ToLong(byte[] u8) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.put(u8);
        byteBuffer.flip();
        return byteBuffer.getLong();
    }

    public static double u8ToDouble(byte[] u8) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        byteBuffer.put(u8);
        byteBuffer.flip();
        return byteBuffer.getDouble();
    }

    public static int u2ToInt(byte[] u2) {
        int temp = (u2[1] & 0xFF) | (u2[0] & 0xFF) << 8;
        return temp;
    }

    public static int u1ToInt(byte[] u1) {
        int temp = u1[0] & 0xFF;
        return temp;
    }
}
