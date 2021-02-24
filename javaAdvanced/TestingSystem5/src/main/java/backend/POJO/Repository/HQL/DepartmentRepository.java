package backend.POJO.Repository.HQL;

import backend.POJO.DepartmentConvert;
import entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.UtilsHibernate;

import java.util.List;

public class DepartmentRepository {
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

    public List<DepartmentConvert> getAllDepartment(String fieldName, short filter){
        Session session = null;

        try{
            session = utilsHibernate.openSession();

            String hql = "select new backend.POJO.DepartmentConvert(b.departmentID, b.departmentName, b.address.addressName) " +
                    "from DetailDepartment b ";

            if(filter != 0 && fieldName != null){
                hql += "WHERE b.departmentName = :fieldName AND b.emulationPoint > :filter ";

            }else if( filter !=0 ){
                hql += "WHERE b.emulationPoint > :filter ";
            }else if( fieldName != null){
                hql += "WHERE b.departmentName = :fieldName ";
            }
            hql += "order by b.departmentName asc";

            Query<DepartmentConvert> query = session.createQuery(hql);

            if(filter != 0 && fieldName != null) {
                query.setParameter("filter", filter);
                query.setParameter("fieldName",fieldName);
            }else if(fieldName != null){
                query.setParameter("fieldName",fieldName);
            }else if(filter != 0){
                query.setParameter("filter", filter);
            }

            query.setFirstResult(0);
            query.setMaxResults(10);

            return query.list();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }


    public short onCountDepartment(){
        List<DepartmentConvert> departmentConverts = getAllDepartment(null, (short) 0);

        return (short) departmentConverts.size();
    }



    public void onDeleteDepartment(short id){
        Session session = null;
        try{
            session = utilsHibernate.openSession();
            session.beginTransaction();

            String hql = "DELETE FROM Department s WHERE s.departmentID = :idDepartment";

            Query query = session.createQuery(hql);

            query.setParameter("idDepartment",id);
            int result = query.executeUpdate();

            session.getTransaction().commit();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }

    public DepartmentConvert getDepartmentByID(short id){
        List<DepartmentConvert> departments = getAllDepartment(null,(short)0);
        for (DepartmentConvert department : departments) {
            if(department.getId() == id){
                return department;
            }
        }
        return null;
    }
    public DepartmentConvert getDepartmentByName(String name){
        List<DepartmentConvert> departments = getAllDepartment(null,(short)0);
        for (DepartmentConvert department : departments) {
            if(department.getName() == name){
                return department;
            }
        }
        return null;
    }

    public boolean isDepartmentExistsByID(short id){
        DepartmentConvert department = getDepartmentByID(id);
        if(department != null) return true;
        return false;
    }

    public boolean isDepartmentExistsByName(String name){
        DepartmentConvert department = getDepartmentByName(name);
        if(department != null) return true;
        return false;
    }

}
