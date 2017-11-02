package com.print;

import com.analyze.ClassAnalyze;
import com.analyze.field.bean.FieldBean;
import com.analyze.method.bean.MethodBean;

/**
 * Created by chenjiaxu on 2017/11/2.
 */
public class PrintFieldMsg {
    public static void print(ClassAnalyze classAnalyze){
        StringBuffer fieldMsgBuffer = new StringBuffer();
        FieldBean[] fieldBeans = classAnalyze.getFieldBeans();
        for (int i = 0; i < fieldBeans.length; i++) {
            fieldMsgBuffer.append(i + " : " + fieldBeans[i].toString(classAnalyze.getConstBeans()) + "\n");
        }

        System.out.println(fieldMsgBuffer);
    }
}
