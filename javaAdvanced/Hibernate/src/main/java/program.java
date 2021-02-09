import backend.Controller.ControllerGroup;
import backend.Repository.ExamRepository;
import entity.Exam;
import entity.group;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        //ControllerGroup controllerGroup = new ControllerGroup();

        //controllerGroup.getAllGroup();
        //controllerGroup.createGroup();
        //controllerGroup.getGroupById();
        //controllerGroup.getGroupByName();
        //controllerGroup.updateGroup();
//        controllerGroup.deleteGroup();
//        controllerGroup.isGroupExistsById();
//        controllerGroup.isGroupExistsByName();
        ExamRepository repository = new ExamRepository();
        //Scanner scanner = new Scanner(System.in);
        //String s;
        Exam exam = new Exam();
        exam.setTitle("Bài thi đầu vào 2");
        exam.setDuration((short) 185);
        repository.creatExam(exam);

    }
}
