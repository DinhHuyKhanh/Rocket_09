package frontend;

import backend.presentationlayer.AccountController;
import entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class program {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        AccountController accountController = new AccountController();

        List<Account> accounts = accountController.getListAccounts();

        Account account = new Account();
        account.print();
        for(Account x : accounts)
        {
            x.printf();
        }
    }


}
