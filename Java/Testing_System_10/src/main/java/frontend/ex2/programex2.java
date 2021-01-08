package frontend.ex2;

import backend.ex2.testing_category;
import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import untils.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class programex2 {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        connection conect = new connection();

         Connection   connection = conect.connection();


        testing_category tc = new testing_category();
       // tc.question1(connection);
       //tc.question2(connection);
       // tc.question4();
        tc.question6();

    }
}
