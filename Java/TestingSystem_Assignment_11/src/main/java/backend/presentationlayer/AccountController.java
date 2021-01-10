package backend.presentationlayer;

import backend.businesslayer.AccountService;
import backend.businesslayer.IAccountService;
import entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountController {

    private IAccountService accountService;

    public AccountController(){
        accountService = new AccountService();
    }

    public List<Account> getListAccounts() throws SQLException, IOException, ClassNotFoundException {
        return accountService.getListAccounts();
    }


}
