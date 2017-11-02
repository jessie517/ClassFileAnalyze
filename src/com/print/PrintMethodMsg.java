package com.print;

import com.analyze.ClassAnalyze;
import com.analyze.method.bean.MethodBean;

/**
 * Created by chenjiaxu on 2017/11/2.
 */
public class PrintMethodMsg {
    public static void print(ClassAnalyze classAnalyze){
        StringBuffer methodMsgBuffer = new StringBuffer();
        MethodBean[] methodBeans = classAnalyze.getMethodBeans();
        for (int i = 0; i < methodBeans.length; i++) {
            methodMsgBuffer.append("\t" + methodBeans[i].toString(classAnalyze.getConstBeans()) + "\n");
        }

        System.out.println(methodMsgBuffer.toString());
    }
}
