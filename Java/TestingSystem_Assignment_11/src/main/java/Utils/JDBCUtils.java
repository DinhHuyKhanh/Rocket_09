package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private Connection connection;

    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

        if(connection==null || connection.isClosed()) {
        // den file luu duong dan dang nhap mysql
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/connect.properties"));

            String url = properties.getProperty("url");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connect success! ");
        }
        return connection;
    }

    public void disConnect() throws SQLException {
        if(connection != null || !connection.isClosed())
        {
            connection.close();
        }
    }


}
