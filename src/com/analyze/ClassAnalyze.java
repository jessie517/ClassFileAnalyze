package com.analyze;

import com.analyze.attribute.AttributeAnalyze;
import com.analyze.attribute.bean.AttributeInfoBean;
import com.analyze.basic.accessFlag.ClassAccessFlagAnalyze;
import com.analyze.basic.accessFlag.bean.ClassAccessBean;
import com.analyze.basic.classMsg.ClassBasicMsgAnalyze;
import com.analyze.basic.classMsg.bean.ClassBasicMsg;
import com.analyze.constant.ConstAnalyze;
import com.analyze.constant.bean.ConstBean;
import com.analyze.field.FieldAnalyze;
import com.analyze.field.bean.FieldBean;
import com.analyze.method.MethodAnalyze;
import com.analyze.method.bean.MethodBean;
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

        ConstBean[] consts = new ConstAnalyze().getConstBeans(in);

        ClassBasicMsg classBasicMsg = new ClassBasicMsgAnalyze().getClassBasicMsg(in);

        FieldBean[] fieldBeans = new FieldAnalyze().getFieldBeans(in);

        MethodBean[] methodBeans = new MethodAnalyze().getMethodBeans(in);

        AttributeInfoBean[] classAttributes = new AttributeAnalyze().getAttributeInfoBeans(in);

        System.out.println("class文件流中尚未解析字节数：" + in.available());
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
