import com.analyze.ClassAnalyze;
import com.print.*;

import java.io.IOException;

/**
 * Created by chenjiaxu on 2017/10/23.
 */
public class ProjectRun {
    public static void main(String[] args) {
        try {
            ClassAnalyze classAnalyze = new ClassAnalyze("C:\\Users\\chenjiaxu\\Desktop\\QueryService.class");
            PrintMsg.print(classAnalyze);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
