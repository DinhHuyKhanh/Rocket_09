package untils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connection {

     public Connection connection() throws IOException, ClassNotFoundException, SQLException {
         Properties properties = new Properties();
         properties.load(new FileInputStream("src/main/resources/connect.properties"));

         String url = properties.getProperty("url");
         String username = properties.getProperty("username");
         String password = properties.getProperty("password");

         Class.forName("com.mysql.cj.jdbc.Driver");

         Connection connection = DriverManager.getConnection(url,username,password);
         System.out.println("Connect success! ");

         return connection;
     }

}
