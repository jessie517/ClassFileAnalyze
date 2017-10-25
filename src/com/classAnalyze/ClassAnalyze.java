package com.classAnalyze;

import com.utils.ConstAnalyze;
import com.utils.UToNumeric;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by chenjiaxu on 2017/10/23.
 */
public class ClassAnalyze {
    public void analyze(String path) throws IOException {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        BufferedInputStream in = new BufferedInputStream(inputStream);
        byte[] u4 = new byte[4];
        byte[] u2 = new byte[2];
        byte[] u1 = new byte[1];

        //魔数
        in.read(u4);
        if(!isJavaClass(u4)){
            System.out.println("class文件魔数校验失败");
        }

        //版本号
        in.read(u4);
        System.out.println(getVersion(u4));

        //常量池长度
        in.read(u2);
        int constL = UToNumeric.u2ToInt(u2);
        System.out.println("常量池长度：" + constL);

        Object[] consts = new Object[constL];
        ConstAnalyze constAnalyze = new ConstAnalyze();
        for(int i = 1; i < constL; i++){
            in.read(u1);
            int type = UToNumeric.u1ToInt(u1);
            i = constAnalyze.setConst(i, type, in, consts);
        }
        System.out.println(Arrays.toString(consts));
        in.close();
    }

    private boolean isJavaClass(byte[] b){
        BigInteger bigInteger = new BigInteger(1, b);
        String hexString = bigInteger.toString(16);
        //0xCAFEBABE
        return hexString.equalsIgnoreCase("CAFEBABE");
    }

    private double getVersion(byte[] b){
         int minor =  (b[1] & 0xFF) | (b[0] & 0xFF) << 8;
         int major = b[3] & 0xFF | (b[2] & 0xFF) << 8;
         return Double.parseDouble(major+"."+minor);
    }

}
