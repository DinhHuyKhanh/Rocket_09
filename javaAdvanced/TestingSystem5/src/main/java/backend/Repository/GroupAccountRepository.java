package backend.Repository;

import entity.CategoryQuestion;
import entity.GroupAccount;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class GroupAccountRepository {
    UtilsHibernate utilsHibernate;

    public GroupAccountRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createCategoryQuestion(GroupAccount groupAccount){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(groupAccount);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<GroupAccount> getAllGroupAccount(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<GroupAccount> query = session.createQuery("FROM GroupAccount ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }




    public void onDeleteGroupAccount(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            GroupAccount groupAccount = (GroupAccount) session.load(GroupAccount.class, id);

            session.delete(groupAccount);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
