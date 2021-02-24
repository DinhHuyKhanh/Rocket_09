import backend.POJO.DepartmentConvert;
import backend.POJO.Repository.Criteria.DepartmentCriteria;
import backend.POJO.Repository.HQL.DepartmentRepository;
import entity.DetailDepartment;

import java.util.List;

public class program {
            public static void main(String[] args) {
//                ControllerGroup controllerGroup = new ControllerGroup();
//
//                controllerGroup.getAllGroup();
                //controllerGroup.createGroup();
                //controllerGroup.getGroupById();
                //controllerGroup.getGroupByName();
                //controllerGroup.updateGroup();
//        controllerGroup.deleteGroup();
//        controllerGroup.isGroupExistsById();
//        controllerGroup.isGroupExistsByName();
//        ExamRepository repository = new ExamRepository();
//        //Scanner scanner = new Scanner(System.in);
//        //String s;
//        Exam exam = new Exam();
//        exam.setTitle("Bài thi đầu vào 2");
//        exam.setDuration((short) 185);
//        repository.creatExam(exam);

//                DepartmentRepository repository = new DepartmentRepository();
//                List<DepartmentConvert> departments;
//                departments = repository.getAllDepartment(null,(short)0);
//                for (DepartmentConvert department : departments){
//                    System.out.println(department);
//                }
//
//                System.out.println("Test hàm COUNT :  "+repository.onCountDepartment());

                DepartmentCriteria criteria = new DepartmentCriteria();
                List<DepartmentConvert> departments = criteria.getAllDepartment(null,(short)0);

                for(DepartmentConvert department : departments)
                    System.out.println(department);
    }
}
