package backend.Repository;

import entity.CategoryQuestion;
import entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;


import java.util.List;

public class DepartmentRepository implements IDepartmentRepository {
    UtilsHibernate utilsHibernate;

    public DepartmentRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createDepartment(Department department){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(department);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<Department> getAllDepartment(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<Department> query = session.createQuery("FROM Department ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public void onUpdateDepartment(short id, String newDepartmentName){
        Session session = null;
        try{

            // get
            session = utilsHibernate.openSession();
            session.beginTransaction();

            //get group
            Department department = (Department) session.load(Department.class, id);

            // update group
            department.setDepartmentName(newDepartmentName);
            // commit lại
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void onDeleteDepartment(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            Department department = (Department) session.load(Department.class, id);

            session.delete(department);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
