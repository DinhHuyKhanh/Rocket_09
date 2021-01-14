package backend.datalayer;

import Utils.JDBCUtils;
import entity.Employee;
import entity.Manager;
import entity.Project;
import entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
        private JDBCUtils jdbcUtils;

    public Repository(){
    jdbcUtils  = new JDBCUtils();
    }

    public List<User> getListUser() throws SQLException, IOException, ClassNotFoundException {
        List<User> userList = new ArrayList<>();

        //
        Connection connection = jdbcUtils.getConnection();

        //
        String sql = "SELECT * FROM `user`";
        Statement statement = connection.createStatement();

        //
        ResultSet resultSet = statement.executeQuery(sql);

        //
        while(resultSet.next())
        {
            User  user = new User(resultSet.getInt("id"),
                    resultSet.getString("FullName"),
                    resultSet.getString("Email"),
                    resultSet.getString("Password") );
            userList.add(user);
        }
        connection.isClosed();
        return userList;
    }

    public List<Employee> getListEmployee() throws SQLException, IOException, ClassNotFoundException {
        List<Employee> employeesList = new ArrayList<>();

        //
        Connection connection = jdbcUtils.getConnection();

        //
        String sql = "SELECT \n" +
                "a.*,\n" +
                "b.projectid, b.ProSkill \n" +
                "FROM  \n" +
                "`user` a\n" +
                "RIGHT JOIN `employee` b ON a.id = b.userid;";

        Statement statement = connection.createStatement();

        //
        ResultSet resultSet = statement.executeQuery(sql);

        //
        while(resultSet.next())
        {
            Employee employee = new Employee(resultSet.getInt("id"),
                    resultSet.getString("FullName"),
                    resultSet.getString("Email"),
                    resultSet.getString("password"),
                    resultSet.getInt("projectid"),
                    resultSet.getString("ProSkill"));
            employeesList.add(employee);
        }
        connection.isClosed();
        return employeesList;
    }


    public List<Manager> getListManager() throws SQLException, IOException, ClassNotFoundException {
        List<Manager> managerList = new ArrayList<>();

        //
        Connection connection = jdbcUtils.getConnection();

        //
        String sql = "SELECT \n" +
                "a.*,\n" +
                "b.ExpInYear\n" +
                "FROM  \n" +
                "`user` a\n" +
                "RIGHT JOIN `Manager` b ON a.id = b.userid;";
        Statement statement = connection.createStatement();

        //
        ResultSet resultSet = statement.executeQuery(sql);

        //
        while(resultSet.next())
        {
            Manager manager = new Manager(resultSet.getInt("id"),
                    resultSet.getString("FullName"),
                    resultSet.getString("Email"),
                    resultSet.getString("password"),
                    resultSet.getInt("ExpInYear"));
            managerList.add(manager);
        }
        connection.isClosed();
        return managerList;
    }

    public List<Project> getListProject() throws SQLException, IOException, ClassNotFoundException {
        List<Project> projects = new ArrayList<>();
        //
        Connection connection = jdbcUtils.getConnection();

        //
        String sql = "SELECT * FROM `project`";
        Statement statement = connection.createStatement();

        //
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next())
        {
            Project project = new Project(resultSet.getInt("projectid"),
                    resultSet.getInt("teamSize"),
                    resultSet.getInt("idManager"));
            projects.add(project);
        }
        connection.isClosed();
        return projects;
    }
}
