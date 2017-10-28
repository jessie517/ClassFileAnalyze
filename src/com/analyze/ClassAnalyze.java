package com.analyze;

import com.analyze.accessFlag.ClassAccessFlagAnalyze;
import com.analyze.accessFlag.bean.ClassAccessBean;
import com.analyze.constant.ConstAnalyze;
import com.analyze.constant.bean.ConstBean;
import com.analyze.field.FieldAnalyze;
import com.analyze.field.bean.FieldBean;
import com.utils.UToNumeric;

import java.io.*;
import java.math.BigInteger;

/**
 * Created by chenjiaxu on 2017/10/23.
 */
public class ClassAnalyze {
    public void analyze(String path) throws Exception {
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
        int constCount = UToNumeric.u2ToInt(u2);
        System.out.println("常量池长度：" + constCount);

        ConstBean[] consts = new ConstAnalyze().getConstBeans(constCount, in);

        in.read(u2);
        ClassAccessBean classAccessBean = ClassAccessFlagAnalyze.getAccessBean(u2);

        in.read(u2);
        int classIndex = UToNumeric.u2ToInt(u2);

        in.read(u2);
        int parentClassIndex = UToNumeric.u2ToInt(u2);

        in.read(u2);
        int interfaceCount = UToNumeric.u2ToInt(u2);
        int[] interfaceIndexs = new int[interfaceCount];
        if(interfaceCount > 0){
            for(int i=0; i< interfaceCount;i++){
                in.read(u2);
                int interfaceIndex = UToNumeric.u2ToInt(u2);
                interfaceIndexs[i] = interfaceIndex;
            }
        }

        in.read(u2);
        int fieldCount = UToNumeric.u2ToInt(u2);
        FieldBean[] fieldBeans = new FieldAnalyze().getFieldBeans(fieldCount, in);

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
