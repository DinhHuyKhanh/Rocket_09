package backend.businesslayer;

import entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException;
}
