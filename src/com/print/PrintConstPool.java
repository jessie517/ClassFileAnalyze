package com.print;

import com.analyze.ClassAnalyze;
import com.analyze.constant.bean.ConstBean;

import java.util.Arrays;

/**
 * Created by chenjiaxu on 2017/11/2.
 * 输出常量池信息
 */
public class PrintConstPool {
    public static void print(ClassAnalyze classAnalyze) {
        StringBuffer constPoolBuffer = new StringBuffer();
        ConstBean[] constBeans = classAnalyze.getConstBeans();
        for (int i = 0; i < constBeans.length; i++) {
            if (constBeans[i] != null) {
                constPoolBuffer.append(i + " : ");
                if (constBeans[i].getValue() instanceof int[]) {
                    constPoolBuffer.append(Arrays.toString((int[]) constBeans[i].getValue()));
                } else {
                    constPoolBuffer.append(constBeans[i].getValue());
                }
                constPoolBuffer.append("\n");
            }
        }

        System.out.println(constPoolBuffer);
    }
}
