package com.analyze.basic.classMsg;

import com.analyze.basic.accessFlag.ClassAccessFlagAnalyze;
import com.analyze.basic.accessFlag.bean.ClassAccessBean;
import com.analyze.basic.classMsg.bean.ClassBasicMsg;
import com.utils.UToNumeric;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenjiaxu on 2017/10/28.
 */
public class ClassBasicMsgAnalyze {
    private byte[] u2 = new byte[2];

    public ClassBasicMsg getClassBasicMsg(InputStream in) throws Exception {
        ClassBasicMsg classBasicMsg = new ClassBasicMsg();
        in.read(u2);
        classBasicMsg.setClassAccessBean(ClassAccessFlagAnalyze.getAccessBean(u2));

        in.read(u2);
        classBasicMsg.setClassIndex(UToNumeric.u2ToInt(u2));

        in.read(u2);
        classBasicMsg.setParentClassIndex(UToNumeric.u2ToInt(u2));

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
        classBasicMsg.setInterfaceIndexs(interfaceIndexs);

        return classBasicMsg;
    }
}
