package com.print;

import com.analyze.ClassAnalyze;

/**
 * Created by chenjiaxu on 2017/11/2.
 */
public class PrintMsg {
    public static void print(ClassAnalyze classAnalyze){
        PrintClassMsg.print(classAnalyze);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        PrintConstPool.print(classAnalyze);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        PrintFieldMsg.print(classAnalyze);
        System.out.println("----------------------------------------------------------------------------------------------------------");
        PrintMethodMsg.print(classAnalyze);
    }
}
