package backend.Repository;

import entity.DetailDepartment;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class DetailDepartmentRepository {
    UtilsHibernate utilsHibernate;

    public DetailDepartmentRepository(){
        this.utilsHibernate = UtilsHibernate.getInstance();
    }

    public void createDetailDepartment(DetailDepartment detailDepartment){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.getTransaction();

            //create
            session.save(detailDepartment);

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public List<DetailDepartment> getAllDetailDepartment(){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment ");

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public void onDeleteDetailDepartment(short id){
        Session session = null;

        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            // get group
            DetailDepartment detailDepartment = (DetailDepartment) session.load(DetailDepartment.class, id);

            session.delete(detailDepartment);
            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
