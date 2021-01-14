package backend.businesslayer;

import entity.Employee;
import entity.Manager;
import entity.Project;


import  java.util.List;
import java.io.IOException;
import java.sql.SQLException;

public interface IService {
    // danh sach quan li
    List<Manager> getListManager() throws SQLException, IOException, ClassNotFoundException;
    // danh sach nhan vien
    List<Employee> getListEmployee() throws SQLException, IOException, ClassNotFoundException;
    // danh sach du an
    List<Project> getListProject() throws SQLException, IOException, ClassNotFoundException;

    // tra ve id cua manager trong 1 du an
    public int idManager(int projectID) throws SQLException, IOException, ClassNotFoundException;

    // kiem tra du an co ton tai hay khong
    public Boolean checkProject(int projectID) throws SQLException, IOException, ClassNotFoundException;

    // question2: in thong tin  quan li va nhan vien trong du an co id  là :..
    public void question2(int projectId) throws SQLException, IOException, ClassNotFoundException;

    // In ra thông tin tất cả các quản lí trong các dự án đang làm
    public void question3() throws SQLException, IOException, ClassNotFoundException;

    // kiểm tra email có hợp lệ hay không
    public boolean checkEmail(String email);

    // kiểm tra password có hợp lệ hay không
    public boolean checkPassWord(String password);

    // kiểm tra thông tin tài khoản này có trong DB hay không.
    public boolean checkLogin(String email, String passWord) throws SQLException, IOException, ClassNotFoundException;

    // Login vào chương trình.
    public boolean question4(String email, String passWord) throws SQLException, IOException, ClassNotFoundException;

}
