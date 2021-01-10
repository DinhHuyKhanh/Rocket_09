package backend.businesslayer;

import backend.datalayer.AccountRepository;
import backend.datalayer.IAccountRepository;
import entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountService implements  IAccountService{

    private IAccountRepository accountRepository;

    public AccountService() {
        accountRepository = new AccountRepository();
    }

    public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
        return accountRepository.getListAccounts();
    }


}
