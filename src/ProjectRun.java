import com.classAnalyze.ClassAnalyze;

import java.io.IOException;

/**
 * Created by chenjiaxu on 2017/10/23.
 */
public class ProjectRun {
    public static void main(String[] args){
        ClassAnalyze classAnalyze = new ClassAnalyze();
        try {
            classAnalyze.analyze("C:\\Users\\chenjiaxu\\Desktop\\QueryService.class");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
