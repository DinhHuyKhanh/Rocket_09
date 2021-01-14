package backend.datalayer;

import entity.Employee;
import entity.Manager;
import entity.Project;
import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
* @Description
* @author: Đinh Huy Khánh
* @creat_date: 13-1-2021
* @modifer:
 * @modifer_date:
* */
public interface IRepository {
    // Đọc DB từ databse vào arraylis

    // Lấy danh sách các User
    List<User>  getListUser() throws SQLException, IOException, ClassNotFoundException;

    // Lấy danh sách các Manager
    List<Manager> getListManager() throws SQLException, IOException, ClassNotFoundException;

    // Lấy danh sách các Employee
    List<Employee> getListEmployee() throws SQLException, IOException, ClassNotFoundException;

    // Lấy danh sách các Project
    List<Project> getListProject() throws SQLException, IOException, ClassNotFoundException;
}
