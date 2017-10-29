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
    private double version;
    private ClassBasicMsg classBasicMsg;
    private ConstBean[] constBeans;
    private FieldBean[] fieldBeans;
    private MethodBean[] methodBeans;
    private AttributeInfoBean[] classAttributes;

    public ClassAnalyze(String path) throws Exception {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        BufferedInputStream in = new BufferedInputStream(inputStream);
        byte[] u4 = new byte[4];
        byte[] u2 = new byte[2];
        byte[] u1 = new byte[1];

        //魔数
        in.read(u4);
        if (!isJavaClass(u4)) {
            System.out.println("class文件魔数校验失败");
        }

        //版本号
        in.read(u4);
        this.version = getVersion(u4);

        this.constBeans = new ConstAnalyze().getConstBeans(in);

        this.classBasicMsg = new ClassBasicMsgAnalyze().getClassBasicMsg(in);

        this.fieldBeans = new FieldAnalyze().getFieldBeans(in, constBeans);

        this.methodBeans = new MethodAnalyze().getMethodBeans(in, constBeans);

        this.classAttributes = new AttributeAnalyze().getAttributeInfoBeans(in, constBeans);

        System.out.println("class文件流中尚未解析字节数：" + in.available());
        in.close();
    }

    private boolean isJavaClass(byte[] b) {
        BigInteger bigInteger = new BigInteger(1, b);
        String hexString = bigInteger.toString(16);
        //0xCAFEBABE
        return hexString.equalsIgnoreCase("CAFEBABE");
    }

    private double getVersion(byte[] b) {
        int minor = (b[1] & 0xFF) | (b[0] & 0xFF) << 8;
        int major = b[3] & 0xFF | (b[2] & 0xFF) << 8;
        return Double.parseDouble(major + "." + minor);
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public ClassBasicMsg getClassBasicMsg() {
        return classBasicMsg;
    }

    public void setClassBasicMsg(ClassBasicMsg classBasicMsg) {
        this.classBasicMsg = classBasicMsg;
    }

    public ConstBean[] getConstBeans() {
        return constBeans;
    }

    public void setConstBeans(ConstBean[] constBeans) {
        this.constBeans = constBeans;
    }

    public FieldBean[] getFieldBeans() {
        return fieldBeans;
    }

    public void setFieldBeans(FieldBean[] fieldBeans) {
        this.fieldBeans = fieldBeans;
    }

    public MethodBean[] getMethodBeans() {
        return methodBeans;
    }

    public void setMethodBeans(MethodBean[] methodBeans) {
        this.methodBeans = methodBeans;
    }

    public AttributeInfoBean[] getClassAttributes() {
        return classAttributes;
    }

    public void setClassAttributes(AttributeInfoBean[] classAttributes) {
        this.classAttributes = classAttributes;
    }
}
