package backend.businesslayer;

import backend.datalayer.IRepository;
import backend.datalayer.Repository;
import entity.Employee;
import entity.Manager;
import entity.Project;
import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 * @Description
 * @author: Đinh Huy Khánh
 * @creat_date: 13-1-2021
 * @modifer:
 * @modifer_date:
 * */

public class Service implements  IService{

    private Scanner scanner = new Scanner(System.in);

    private IRepository repository;

    public Service(){
        repository = new Repository();
    }


    public List<User> getListUser() throws SQLException, IOException, ClassNotFoundException {
        return repository.getListUser();
    }
    public List<Manager> getListManager() throws SQLException, IOException, ClassNotFoundException {
        return repository.getListManager();
    }

    public List<Employee> getListEmployee() throws SQLException, IOException, ClassNotFoundException {
        return repository.getListEmployee();
    }

    public List<Project> getListProject() throws SQLException, IOException, ClassNotFoundException {
        return repository.getListProject();
    }

    public int idManager(int projectID) throws SQLException, IOException, ClassNotFoundException {
        List<Project> projects = getListProject();

        for(Project x: projects)
        {
            if(x.getProjectId() == projectID)
            {
                return x.getIdManager(); // nếu tìm thấy trả về id của manager
            }
        }
        return -1; // nếu không tìm thấy method trả về -1;
    }

    public Boolean checkProject(int projectID) throws SQLException, IOException, ClassNotFoundException {
        List<Project> projects = getListProject();
        for(int i=0;i<projects.size();i++)
        {
            if(projects.get(i).getProjectId() == projectID)
            {
                return true; // nếu project này có thì trả về true
            }
        }
        return false; // nếu project này không có thì trả về false
    }


    public void question2(int projectId) throws SQLException, IOException, ClassNotFoundException {
        List<Project> projects = getListProject();
        List<Manager> managerList = getListManager();
        List<Employee> employees = getListEmployee();

        if(checkProject(projectId) == false) // kiểm tra project có tồn tại hay chưa
        {
            System.out.println("Không tìm thấy project ID: "+projectId +" này");
        }
        else
        {
            int managerid = idManager(projectId);
            if(managerid == -1)
            {
                System.out.println("Project này chưa có người quản lí.");
            }
            else
            {
                // in ra thong tin
                System.out.println("Thông tin của manager: ");
                Manager.tieuDe();
                for(Manager x: managerList)
                {
                    if(x.getId() == managerid)
                    {
                            x.inThongTin();
                            break;
                    }
                }
            }
        }

        System.out.println("Thông tin của nhân viên.");
        Employee.tieuDe();
        for(Employee x: employees)
        {
            if(x.getProjectid() == projectId)
            {
                x.inThongTin();
            }
        }
    }

    // In ra thông tin các Manager có trong các dự án đang làm.
    public void question3() throws SQLException, IOException, ClassNotFoundException {
        List<Project> projects = getListProject();
        List<Manager> managerList = getListManager();

        // mot mang lưu id cua tất cả các manager đang tham gia vào các dự án.
        int[] id = new int[projects.size()];
        for(int i=0;i<projects.size();i++)
        {
            id[i] = projects.get(i).getIdManager();
        }

        // in thong tin cua cac manager nay ra.
        Manager.tieuDe();
        for(int i=0;i<projects.size();i++)
        {
            for(Manager x : managerList)
            {
                if(id[i]== x.getId())
                {
                    x.inThongTin();
                    break;
                }
            }
        }
    }

    public boolean checkEmail(String email){
        char[] ch = email.toCharArray();
        int demA=0,vitriA=-1;
        int demdot=0;

        for(int i=0;i<ch.length;i++)
        {
            if(String.valueOf(ch[i]).equals("@"))
            {
                demA++;
                vitriA=i;
            }
            if(vitriA!=-1)
            {
                if(String.valueOf(ch[i]).equals("."))
                {
                    demdot++;
                    break;
                }
            }
        }
        if(demdot !=0 && demA !=0 )
            return true;
        else {
            if(demA==0) System.out.println("Email của bạn không có @.");
            else if(demdot == 0) System.out.println("Tên miền không xác định.");
            return false;
        }
    }

    public boolean checkPassWord(String password){
        char[] ch = password.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]<=90 && ch[i]>=65)
                return true;
        }
        System.out.println("Password phải có chữ cái viết hoa");
        return false;
    }

    public boolean checkLogin(String email, String passWord) throws SQLException, IOException, ClassNotFoundException {
         List<User> userList = getListUser();
         for(User x: userList)
         {
             if(x.getEmail().equals(email) && x.getPassword().equals(passWord))
             return true;
         }
        return false;
    }

    public boolean question4(String email, String passWord) throws SQLException, IOException, ClassNotFoundException {
        if(checkEmail(email) == true && checkPassWord(passWord)==true)
        {
            if(checkLogin(email,passWord)==true)
            {
                System.out.println("Login thành công.");
                return true;
            }
            else
             System.out.println("Login thất bại." +
                        "\nMật khẩu hoặc tài khoản sai\n" +
                        "Nếu chưa có tài khoản hãy yêu cầu quản trị viên tạo tài khoản cho bạn");
        }
        else
        {
            System.out.println("Login thất bại! ");
        }
        return false;
    }


}
