package backend.Repository;

import entity.Account;
import entity.group;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class AccountRepository {
    UtilsHibernate utilsHibernate;

    public AccountRepository() {
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createAccount(Account account){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(account);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Account> getAllAccount(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Account> query = session.createQuery("FROM Account ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    public Account getAccountById(short id){

        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Account account = session.get(Account.class, id);

            return account;
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void updateAccount(short id, String newUsername){
        Session session = null;
        try{

            // get
            session = utilsHibernate.openSession();
            session.beginTransaction();

            //get group
            Account account = (Account) session.load(Account.class, id);

            // update group
            account.setUserName(newUsername);
            // commit lại
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void onDeleteAccount(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            Account account = (Account) session.load(Account.class, id);

            session.delete(account);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


}
