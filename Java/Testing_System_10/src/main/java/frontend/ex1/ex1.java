package frontend.ex1;

import backend.ex1.backendone;
import untils.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ex1 {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
       Connection connection;
       connection cn1 = new connection();
       connection = cn1.connection();

        backendone back1= new backendone();
        back1.question2(connection);

        //back1.question3(connection);
        //back1.question4(connection);
       //back1.question5(connection);

    }
}
