package backend.datalayer;

import Utils.JDBCUtils;
import entity.Account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements  IAccountRepository {
    private JDBCUtils jdbcUtils;

    public AccountRepository() {
        jdbcUtils = new JDBCUtils();
    }

    public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();

        // get connection
        Connection connection = jdbcUtils.getConnection();

        //
        String sql = "SELECT * FROM `account`";
        Statement statement = connection.createStatement();

        //execute query
        ResultSet resultSet = statement.executeQuery(sql);

        // handling result Set
        while(resultSet.next())
        {
            Account account = new Account(resultSet.getInt("AccountID"),
                    resultSet.getString("Email"),
                    resultSet.getString("UserName"),
                    resultSet.getString("FullName"),
                    resultSet.getInt("DepartmentID"),
                    resultSet.getInt("PositionID"),
                    resultSet.getString("CreateDate"));

            accounts.add(account);
        }

        jdbcUtils.disConnect();

        return accounts;
    }
}
