package backend.Repository;

import entity.CategoryQuestion;
import entity.Salary;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class SalaryRepository {
    UtilsHibernate utilsHibernate;

    public SalaryRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createSalary(Salary salary){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(salary);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Salary> getAllSalary(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Salary> query = session.createQuery("FROM Salary ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
