package backend.Repository;

import entity.CategoryQuestion;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class EmployeeRepository {
    UtilsHibernate utilsHibernate;

    public EmployeeRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createEmployee(Employee employee){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(employee);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Employee> getAllEmployee(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Employee> query = session.createQuery("FROM Employee ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public void onUpdateEmployee(short id, short newYear){
        Session session = null;
        try{

            // get
            session = utilsHibernate.openSession();
            session.beginTransaction();

            //get group
            Employee employee = (Employee) session.load(Employee.class, id);

            // update group
            employee.setWorkingNumberOfYear(newYear);
            // commit lại
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void onDeleteEmployee(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            Employee employee = (Employee) session.load(Employee.class, id);

            session.delete(employee);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
