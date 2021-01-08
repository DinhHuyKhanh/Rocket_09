package backend.ex2;

import untils.connection;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class testing_category {

    public void question1(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        String sql= "SELECT id,name FROM testing_category";
        ResultSet mySet = statement.executeQuery(sql);
        System.out.println("Thông tin testing_category ");
        System.out.println("-----------------------------------------");
        while(mySet.next())
        {
            System.out.printf("%s  | %-10s \n",mySet.getString("id"),mySet.getString("name"));
            System.out.println("-----------------------------------------");
        }

    }
        // question 2 +3;
    public void question2(Connection connection) throws SQLException {
        String id;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Mời bạn nhập id muốn tìm: ");
        id = scanner.nextLine();
        String sql= "SELECT id,name FROM testing_category";

        Statement statement = connection.createStatement();
        ResultSet mySet = statement.executeQuery(sql);
        int dem=0;
        while(mySet.next())
        {
            if(mySet.getString("id").equals(id)) {
                System.out.println("id : " + mySet.getString("id") + "\n name: " + mySet.getString("name"));
                dem+=1;
            }
        }
        if(dem==0) System.out.println("Không tìm thấy thông tin testing exam có id : "+id);
        connection.close();

    }

    public Boolean question4(String name) throws SQLException, IOException, ClassNotFoundException {
        connection cn = new connection();
        Connection connection = cn.connection();

        Statement statement = connection.createStatement();
        String sql= "SELECT id,name FROM testing_category";
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next())
        {
            if(resultSet.getString("name").equals(name)) return true;
        }
        return false;
    }

    public void question4() throws SQLException, IOException, ClassNotFoundException {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập name muốn check: ");
        name = scanner.nextLine();

    //   System.out.println(name);
      System.out.println(question4(name)?"YES":"NO");
//        if(question4(name) == true) System.out.println("YES");
//        else System.out.println("NO");
    }
    public Boolean isCheckID(String id) throws SQLException, IOException, ClassNotFoundException {
        connection connect = new connection();

        Connection connection = connect.connection();

        Statement statement = connection.createStatement();
        String sql= "SELECT id,name FROM testing_category";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next())
        {
            if(resultSet.getString("id").equals(id))  return true;
        }
        return false;
    }
    public void updateName(String id , String name) throws SQLException, IOException, ClassNotFoundException {
        connection connect = new connection();

        Connection connection = connect.connection();
        String sql="UPDATE `testing_category` SET name =? WHERE id=? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(2,id);
        preparedStatement.setString(1,name);

        int effectedRecordAmount = preparedStatement.executeUpdate();
        System.out.println("Effected Record Amount: " + effectedRecordAmount);

        connection.close();
    }
    public void question6(String id, String newName) throws SQLException, IOException, ClassNotFoundException {
        connection connect = new connection();

        Connection connection = connect.connection();

        Statement statement = connection.createStatement();
        String sql = "SELECT id,name FROM testing_category";
        ResultSet resultSet = statement.executeQuery(sql);

        if (isCheckID(id) == true) {
            if (question4(newName) == true)
                System.out.println("Department Name is Exists!");
            else {
                updateName(id, newName);
            }
        } else {
            System.out.println("Cannot find department which has id = " + id);
        }
    }
        public void question6() throws SQLException, IOException, ClassNotFoundException {
            Scanner scanner = new Scanner(System.in);
            String id, name;
            System.out.println("Nhập id: ");
            id = scanner.nextLine();
            System.out.println("Nhập name: ");
            name = scanner.nextLine();

            question6(id,name);
        }
    }
