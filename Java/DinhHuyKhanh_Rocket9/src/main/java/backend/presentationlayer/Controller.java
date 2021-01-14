package backend.presentationlayer;

import backend.businesslayer.IService;
import backend.businesslayer.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import entity.Employee;
import entity.Manager;
import entity.Project;

/**
 * @Description
 * @author: Đinh Huy Khánh
 * @creat_date: 13-1-2021
 * @modifer:
 * @modifer_date:
 * */
public class Controller {
    private IService service;

    public Controller(){
        service = new Service();
    }

    public List<Manager> getListManager() throws SQLException, IOException, ClassNotFoundException {
        return service.getListManager();
    }

    public List<Employee>  getListEmployee() throws SQLException, IOException, ClassNotFoundException {
        return service.getListEmployee();
    }

    public List<Project>  getListProject() throws SQLException, IOException, ClassNotFoundException {
        return service.getListProject();
    }


    public void question2() throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int projectID;
        System.out.println("Mời bạn nhập id: ");
        projectID = scanner.nextInt();
        service.question2(projectID);
    }

    public void question3() throws SQLException, IOException, ClassNotFoundException {
        service.question3();
    }


    public boolean question4() throws SQLException, IOException, ClassNotFoundException {
        String email, password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập email: ");
        email = scanner.nextLine();
        System.out.println("Mời bạn nhập PassWord: ");
        password = scanner.nextLine();

        if(password.length()<6 || password.length()>12)
        {
            System.out.println("Password có độ dài từ 6 đến 12 kí tự.");
        }
        else {
           return service.question4(email,password);
        }
        return  false;
    }

}
