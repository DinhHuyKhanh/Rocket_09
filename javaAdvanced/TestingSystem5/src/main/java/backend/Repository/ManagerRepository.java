package backend.Repository;

import entity.CategoryQuestion;
import entity.Manager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class ManagerRepository {
    UtilsHibernate utilsHibernate;

    public ManagerRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createManagerRepository(Manager manager){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(manager);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Manager> getAllManager(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Manager> query = session.createQuery("FROM Manager ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }




    public void onDeleteManager(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            Manager manager = (Manager) session.load(Manager.class, id);

            session.delete(manager);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
