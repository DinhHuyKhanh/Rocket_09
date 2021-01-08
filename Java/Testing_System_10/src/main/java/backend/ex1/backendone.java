package backend.ex1;

import java.sql.*;
import java.util.Scanner;

public class backendone {


    public void question2(Connection connection) throws SQLException {
        Statement myStm = connection.createStatement();
        ResultSet myRs = myStm.executeQuery("SELECT id, username FROM `user`");

        while (myRs.next())
        {
            System.out.println("----------------------------------------");
            System.out.println("id: "+myRs.getString("id"));
            System.out.println("name: "+myRs.getString("username"));
            System.out.println("----------------------------------------");
        }
        connection.close();
    }

    public void question3(Connection connection) throws SQLException {

        String sql = "INSERT INTO `testing_exam` (`exam_id` ,`testing_id`)" +
                "VALUE                            (?        ,?            )";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int exam_id;
        int testing_id;
        Scanner a = new Scanner(System.in);
        System.out.println("Them 1 testing_exam");
        System.out.println("Mời bạn nhập exam_id: "); exam_id = a.nextInt();
        System.out.println("Mời bạn nập testing_id: "); testing_id = a.nextInt();

        preparedStatement.setInt(1,exam_id);
        preparedStatement.setInt(2,testing_id);

        System.out.println("Đã thêm thành công !");
        int effectedRecordAmount = preparedStatement.executeUpdate();

        System.out.println("Effected Record Amount: " + effectedRecordAmount);

        connection.close();
    }
    public void question4(Connection connection) throws SQLException {

        String sql = "UPDATE  `user`" +
                "SET lastName = 'Xuan Mai' "+
                " WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int id;
        Scanner a = new Scanner(System.in);
        System.out.println("Update last name");
        System.out.println("Mời bạn nhập id nguoi muon update: "); id = a.nextInt();


        preparedStatement.setInt(1,id);

        System.out.println("Đã thêm thành công !");
        int effectedRecordAmount = preparedStatement.executeUpdate();

        System.out.println("Effected Record Amount: " + effectedRecordAmount);

        connection.close();
    }

    public void question5(Connection connection) throws SQLException {

        String sql = "DELETE FROM  `testing_exam`" +
                " WHERE exam_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        int id;
        Scanner a = new Scanner(System.in);
        System.out.println("Delete testing_exam theo id ");
        System.out.println("Mời bạn nhập id testing exam muon delete: "); id = a.nextInt();


        preparedStatement.setInt(1,id);

        System.out.println("Đã xóa thành công !");
        int effectedRecordAmount = preparedStatement.executeUpdate();

        System.out.println("Effected Record Amount: " + effectedRecordAmount);

        connection.close();
    }








}
