package backend.datalayer;

import entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IAccountRepository {

    List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException;

}
