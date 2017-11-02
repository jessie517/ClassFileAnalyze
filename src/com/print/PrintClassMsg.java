package com.print;

import com.analyze.ClassAnalyze;
import com.analyze.attribute.bean.AttributeInfoBean;
import com.analyze.constant.bean.ConstBean;
import com.analyze.field.bean.FieldBean;
import com.analyze.method.bean.MethodBean;

import java.util.Map;
import java.util.Set;

/**
 * Created by chenjiaxu on 2017/10/29.
 * 输出class基本信息
 */
public class PrintClassMsg {
    public static void print(ClassAnalyze classAnalyze) {
        StringBuffer classMsgBuffer = new StringBuffer();

        classMsgBuffer.append("version: " + classAnalyze.getVersion() + "\n");

        ConstBean[] constBeans = classAnalyze.getConstBeans();

        classMsgBuffer.append(classAnalyze.getClassBasicMsg().toString(constBeans) + "\n");

        Set<Map.Entry<String, AttributeInfoBean>> entries = classAnalyze.getClassAttributes().entrySet();
        for (Map.Entry<String, AttributeInfoBean> entry : entries) {
            classMsgBuffer.append("\t" + entry.getKey() + ":" + entry.getValue().toString(constBeans) + "\n");
        }

        System.out.println(classMsgBuffer);
    }
}
